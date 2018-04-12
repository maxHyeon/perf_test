package com.sds.perf.ch03.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
	
	public static void main(String[] args) throws IOException {
		String fileName = "TryWithResources.java";
		TryWithResources res = new TryWithResources();
		res.readFile(fileName);
		res.readFileNew(fileName);
	}
	
	public String readFile(String fileName) throws IOException {
		long startTime=System.nanoTime();
		FileReader reader=new FileReader(new File(fileName));
		BufferedReader br=new BufferedReader(reader);
		String data=null;
		try {
			data=br.readLine();
		} finally {
			if (br!=null) br.close();
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("readFile nano="+elapsedTime);
		return data;
	}
	
	public String readFileNew(String fileName) throws IOException {
		long startTime=System.nanoTime();
		FileReader reader=new FileReader(new File(fileName));
		try(BufferedReader br = new BufferedReader(reader)) {
			long endTime=System.nanoTime();
			double elapsedTime=(endTime-startTime)/1000000.0;
			System.out.println("readFileNew nano="+elapsedTime);
			return br.readLine();
		}

	}
}
