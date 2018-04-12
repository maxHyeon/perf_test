package com.sds.perf.ch03.string;



//1 ms 
//725967 nano time
public class StringBufferTest {
	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
		long startTime = System.nanoTime();
		StringBuffer abc = new StringBuffer();
		for(int i=0 ; i<10000; i++){
		  abc.append( "def" );
		}
//		long endTime = System.currentTimeMillis();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
	}
}




