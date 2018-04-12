package com.sds.perf.ch03.objectpool;

import java.util.Date;

public class TimedObject extends java.lang.Object {
	public static int count = 0;
	public static long collectionLimit = 500;

	public TimedObject() {
		resetLastCall();
		System.out.println(++count);
	}

	private long lastCall = 0;

	public void resetLastCall() {
		lastCall = (new Date()).getTime();
	}

	public boolean isCollectTarget() {
		long now = (new Date()).getTime();
		return isCollectTarget(now);
	}

	public boolean isCollectTarget(long now) {
		return ((now - collectionLimit) > lastCall);
	}
}
