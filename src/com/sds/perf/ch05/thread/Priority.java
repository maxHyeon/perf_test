package com.sds.perf.ch05.thread;

class MyThread5 extends Thread {
	protected boolean stop; // flag (thread 를 종료하기 위한)

	MyThread5(String name) {
		super(name);
	}

	// Thread class의 public final void stop() 가 아님 --> overriding 이 불가
	// MyThread5 라는 class에서 만든 method
	public void stop(boolean b) {
		stop = b;
	}

	public void run() {
		/*
		 * stop 이라는 flag가 false 일 때만 수행하고, true 가 되면 while 문을 빠져나오고 run 을
		 * 빠져나온다--> thread 를 멈추게 하는 조건
		 */
		while (!stop) {
			for (int i = 0; i < 100; i++)
				;
			System.out.println(getName() + ": is running");
			yield(); // 우선순위가 낮은 thread에게는 양보하지 않는다....
		}
	}
}

public class Priority {
	static public void main(String s[]) {
		MyThread5 thr_a = new MyThread5("첫째");
		MyThread5 thr_b = new MyThread5("둘째");
		MyThread5 thr_c = new MyThread5("셋째");

		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getPriority());
		System.out.println("main이 데몬일까요??? " + Thread.currentThread().isDaemon());
		System.out.println("=================================");
		System.out.println("Starting the threads...");
		thr_a.start();
		thr_b.start();
		thr_c.start();
		System.out.println("첫째의 우선순위 :  " + thr_a.getPriority());
		System.out.println("둘째의 우선순위 :  " + thr_b.getPriority());
		System.out.println("셋째의 우선순위 :  " + thr_c.getPriority());
		System.out.println("=================================");

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("둘째의 우선순위를 2증가...");
		thr_b.setPriority(thr_b.getPriority() + 2);
		System.out.println("둘째의 우선순위 :  " + thr_b.getPriority());

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("둘째의 우선순위를 4감소");
		thr_b.setPriority(thr_b.getPriority() - 4);
		System.out.println("둘째의 우선순위 :  " + thr_b.getPriority());

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("둘째의 우선순위를 동일하게");
		thr_b.setPriority(thr_b.getPriority() + 2);
		System.out.println("둘째의 우선순위 :  " + thr_b.getPriority());

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
