package com.sds.perf.ch03.string;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//159 ms
public class StringTest {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter("result. txt")));
		for (int i=0 ; i<1000000 ; i++){
		  pw.print("performance"+i);
		}	
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}


/*

//151 ms
public class StringTest {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("result. txt")));
		for (int i = 0; i < 1000000; i++) {
			pw.print("performance" + i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
*/