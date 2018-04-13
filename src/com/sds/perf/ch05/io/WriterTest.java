package com.sds.perf.ch05.io;

import java.io.*;

class Performance {
	private String text1;
	private String text2;
	private String text3;
	private int value;

	public Performance(String text1, String text2, String text3, int value) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.value = value;
	}

	public String toString() {
		return text1 + text2 + text3 + value;
	}

	public byte[] toBytes() {
		return this.toString().getBytes();
	}
}
/*
//실행시간: 4983 ms
class WriterTest {
	public static void main(String[] args) throws IOException {
		Performance code1 = new Performance("java", "performance", "TUNING", 20);
		Performance code2 = new Performance("c", "performance", "TUNING", 70);
		long startTime = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream("tuning.txt");
		for (int i = 0; i < 1000000; i++) {
			fos.write(code1.toBytes());
			fos.write(code2.toBytes());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		fos.close();
	}
}
*/
/*
//실행시간: 488 ms
class WriterTest { 
	public static void main(String[] args) throws IOException {
		Performance code1 = new Performance("java", "performance", "TUNING", 20);
		Performance code2 = new Performance("c", "performance", "TUNING", 70);
		long startTime = System.currentTimeMillis();
		BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("tuning.txt"));
		for (int i = 0; i < 1000000; i++) {
			fos.write(code1.toBytes());
			fos.write(code2.toBytes());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		fos.close();
	}
}
*/

/*
//실행시간: 1 ms
class WriterTest {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		DataInputStream dis = new DataInputStream(new FileInputStream("CopyTest.java"));
		while ((dis.readLine()) != null) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		dis.close();
	}
}
*/

/*
//실행시간: 1 ms
class WriterTest {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("CopyTest.java")));
		while ((dis.readLine()) != null) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		dis.close();
	}
}
*/

/*
//실행시간: 491 ms
class WriterTest {
	public static void main(String[] args) throws IOException {
		Performance code1 = new Performance("java", "performance", "TUNING", 20);
		Performance code2 = new Performance("c", "performance", "TUNING", 70);
		long startTime = System.currentTimeMillis();
		BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("tuning.txt"));
		for (int i = 0; i < 1000000; i++) {
			fos.write(code1.toBytes());
			fos.write(code2.toBytes());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		fos.close();
	}
}
*/

/*
//실행시간: 572 ms
class WriterTest {
	public static void main(String[] args) throws IOException {
		Performance code1 = new Performance("java", "performance", "TUNING", 20);
		Performance code2 = new Performance("c", "performance", "TUNING", 70);
		long startTime = System.currentTimeMillis();
		BufferedWriter fw = new BufferedWriter(new FileWriter("tuning4.txt"));
		for (int i = 0; i < 1000000; i++) {
			fw.write(code1.toString(), 0, code1.toString().length());
			fw.write("\r\n");
			fw.write(code2.toString(), 0, code2.toString().length());
			fw.write("\r\n");
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		fw.close();
	}
}
*/
//499 ms
class WriterTest {
	public static void main(String[] args) throws IOException {
		Performance code1 = new Performance("java", "performance", "TUNING", 20);
		Performance code2 = new Performance("c", "performance", "TUNING", 70);
		long startTime = System.currentTimeMillis();
		PrintWriter fw  = new PrintWriter(new BufferedWriter(new FileWriter("tuning5.txt")));
		for (int i = 0; i < 1000000; i++) {
			fw.println(code1.toString());
			fw.println(code2.toString());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		fw.close();
	}
}
