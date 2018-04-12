package com.sds.perf.ch05.thread;

class Monitor {
	private char buffer[] = new char[6];
	private int eatnext = 0;
	private int addnext = 0;
	private boolean isFull = false;
	private boolean isEmpty = true;

	public synchronized char eat() {
		char toReturn;
		while (isEmpty == true) {
			try {
				System.out.println("\t\tBuffer is empty.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		toReturn = buffer[eatnext];
		eatnext = (eatnext + 1) % 6;
		if (eatnext == addnext) {
			isEmpty = true;
		}
		isFull = false;

		System.out.print("\t\t\t\t");
		for (int i = 0; i < eatnext; i++)
			System.out.print(buffer[i] + "\t");
		System.out.print("\teatnext:" + eatnext + "\taddnext:" + addnext);
		System.out.println();

		notify();
		return (toReturn);
	}

	public synchronized void add(char c) {
		while (isFull == true) {
			try {
				System.out.println("\t\tBuffer is full.");
				wait();
			} catch (InterruptedException e) {
			}
		}
		buffer[addnext] = c;

		addnext = (addnext + 1) % 6;
		if (addnext == eatnext) {
			isFull = true;
		}
		isEmpty = false;

		System.out.print("\t\t\t\t");
		for (int i = 0; i < addnext; i++)
			System.out.print(buffer[i] + "\t");
		System.out.print("\teatnext:" + eatnext + "\taddnext:" + addnext);
		System.out.println();

		notify();
	}

	public static void main(String args[]) {
		Monitor m = new Monitor();
		Producer p1 = new Producer(m);
		Consumer c1 = new Consumer(m);
		p1.start();
		c1.start();
	}
}

class Consumer extends Thread {
	private Monitor monitor;
	private int sleepTime = 500;

	public Consumer(Monitor s) {
		monitor = s;
	}

	public void run() {
		char c;
		for (int i = 0; i < 10; i++) {
			c = monitor.eat();
			System.out.println("REMOVE <-- " + c);
			try {
				sleep((int) (Math.random() * sleepTime));
				sleepTime = (int) (Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Producer extends Thread {
	private Monitor monitor;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int sleepTime = 200;

	public Producer(Monitor s) {
		monitor = s;
	}

	public void run() {
		char c;
		for (int i = 0; i < 10; i++) {
			c = alphabet.charAt((int) (Math.random() * 25));
			monitor.add(c);
			System.out.println("ADD --> " + c);
			try {
				sleep((int) (Math.random() * sleepTime));
				sleepTime = (int) (Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}