package com.sds.perf.ch03.objectpool;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Date;

public class ObjectPool implements Runnable {
	public static final int COLLECT_PERIOD = 1000 * 20;

	private static ObjectPool _broker = new ObjectPool();

	public static ObjectPool getObjectBroker() {
		return _broker;
	}

	private TimedObjectFactory factory = new TimedObjectFactory();

	public TimedObjectFactory getFactory() {
		return factory;
	}

	private ObjectStorage inUsePool = null;
	private ObjectStorage notUsePool = null;

	private ObjectPool() {
		inUsePool = new ObjectStorage();
		notUsePool = new ObjectStorage();

		// 가비지 콜렉터를 작동시킨다.
		new Thread(this).start();
	}

	public synchronized TimedObject getObject(String key) {
		TimedObject obj = (TimedObject) notUsePool.get(key);
		if (obj == null) {
			System.out.println("OBJECT MAKING");
			obj = getFactory().getObject(key);
		}
		inUsePool.put(key, obj);
		return obj;
	}

	public synchronized boolean releaseObject(String key, TimedObject obj) {
		Vector list = null;
		for (Enumeration e = inUsePool.elements(); e.hasMoreElements();) {
			list = (Vector) e.nextElement();
			if (list != null && list.removeElement(obj)) {
				obj.resetLastCall();
				notUsePool.put(key, obj);
				return true;
			}
		}
		return false;
	}

	/**
	 * 현재 사용하지 않는 객체 풀에서 3분 이상 호출되지 않은 녀석들을 풀에서 삭제한다.
	 */
	public synchronized void garbageCollect() {
		long now = (new Date()).getTime();

		for (Enumeration e = notUsePool.elements(); e.hasMoreElements();) {
			TimedObject tempObj = null;
			Vector list = (Vector) e.nextElement();

			for (int i = (list.size() - 1); i > -1; i--) {
				tempObj = (TimedObject) list.elementAt(i);
				if (tempObj != null && tempObj.isCollectTarget(now)) {
					System.out.println(tempObj.toString() + " will be garbage collected");
					list.removeElement(tempObj);
				}
			}
		}
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(COLLECT_PERIOD);
			} catch (InterruptedException e) {
			}
			garbageCollect();
		}
	}

	public static void main(String args[]) {
		ObjectPool pool = new ObjectPool();

		TimedObject obj01 = pool.getObject("Test");
		System.out.println(obj01);

		TimedObject obj02 = pool.getObject("Test");
		System.out.println(obj02);

		System.out.println(pool.releaseObject("Test", obj01));
		System.out.println(pool.releaseObject("Test", obj02));

		TimedObject obj03 = pool.getObject("Test");
		System.out.println(obj03);

		TimedObject obj04 = pool.getObject("Test");
		System.out.println(obj04);

		System.out.println(pool.releaseObject("Test", obj03));

		TimedObject obj05 = pool.getObject("Test");
		System.out.println(obj05);

		System.out.println(pool.releaseObject("Test", obj04));

		System.out.println(pool.releaseObject("Test", obj05));
	}
}

/*
// 결과 
OBJECT MAKING
1
com.sds.perf.ch03.objectpool.TestObject01@15db9742
OBJECT MAKING
2
com.sds.perf.ch03.objectpool.TestObject01@6d06d69c
true
true
com.sds.perf.ch03.objectpool.TestObject01@15db9742
com.sds.perf.ch03.objectpool.TestObject01@6d06d69c
true
com.sds.perf.ch03.objectpool.TestObject01@15db9742
true
true
실행된 잠시후면 일정 시간 동안 사용되지 않은 객체의 참조가 해제 되어 가비지 컬렉션의 대상이 됨을 볼 수 있다.
 */