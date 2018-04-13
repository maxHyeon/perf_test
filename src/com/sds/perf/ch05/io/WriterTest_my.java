package com.sds.perf.ch05.io;


import java.io.*;

class Performance2 {
	private String text1;
	private String text2;
	private String text3;
	private int value;
	private String sumText ;
	private byte[] sumByte;

	public Performance2(String text1, String text2, String text3, int value) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.value = value;
		this.sumText = text1 + text2 + text3 + value;
		this.sumByte = sumText.getBytes();
	}

	public String toString() {
		return text1 + text2 + text3 + value;
	}
	
	/*public byte[] toBytes() {
		return this.toString().getBytes();
	}*/
	
	public byte[] toBytes() {
		return this.sumByte;
	}
	
	
	
}


class WriterTest_my {
	public static void main(String[] args) throws IOException {
		Performance2 code1 = new Performance2("java", "performance", "TUNING", 20);
		Performance2 code2 = new Performance2("c", "performance", "TUNING", 70);
		//TODO
		long startTime = System.currentTimeMillis();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("tuning2.txt"));
//		FileOutputStream fos = new FileOutputStream("tuning.txt");
		for(int i = 0; i<1000000; i++) {
			bos.write(code1.toBytes());
			bos.write(code2.toBytes());
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		bos.close();
		
	}
}


