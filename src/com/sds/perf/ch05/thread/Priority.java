package com.sds.perf.ch05.thread;

class MyThread5 extends Thread {
	protected boolean stop; // flag (thread �� �����ϱ� ����)

	MyThread5(String name) {
		super(name);
	}

	// Thread class�� public final void stop() �� �ƴ� --> overriding �� �Ұ�
	// MyThread5 ��� class���� ���� method
	public void stop(boolean b) {
		stop = b;
	}

	public void run() {
		/*
		 * stop �̶�� flag�� false �� ���� �����ϰ�, true �� �Ǹ� while ���� ���������� run ��
		 * �������´�--> thread �� ���߰� �ϴ� ����
		 */
		while (!stop) {
			for (int i = 0; i < 100; i++)
				;
			System.out.println(getName() + ": is running");
			yield(); // �켱������ ���� thread���Դ� �纸���� �ʴ´�....
		}
	}
}

public class Priority {
	static public void main(String s[]) {
		MyThread5 thr_a = new MyThread5("ù°");
		MyThread5 thr_b = new MyThread5("��°");
		MyThread5 thr_c = new MyThread5("��°");

		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getPriority());
		System.out.println("main�� �����ϱ��??? " + Thread.currentThread().isDaemon());
		System.out.println("=================================");
		System.out.println("Starting the threads...");
		thr_a.start();
		thr_b.start();
		thr_c.start();
		System.out.println("ù°�� �켱���� :  " + thr_a.getPriority());
		System.out.println("��°�� �켱���� :  " + thr_b.getPriority());
		System.out.println("��°�� �켱���� :  " + thr_c.getPriority());
		System.out.println("=================================");

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("��°�� �켱������ 2����...");
		thr_b.setPriority(thr_b.getPriority() + 2);
		System.out.println("��°�� �켱���� :  " + thr_b.getPriority());

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("��°�� �켱������ 4����");
		thr_b.setPriority(thr_b.getPriority() - 4);
		System.out.println("��°�� �켱���� :  " + thr_b.getPriority());

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("��°�� �켱������ �����ϰ�");
		thr_b.setPriority(thr_b.getPriority() + 2);
		System.out.println("��°�� �켱���� :  " + thr_b.getPriority());

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stopping the threads...");
		thr_a.stop(true);
		thr_b.stop(true);
		thr_c.stop(true);
	}
}
