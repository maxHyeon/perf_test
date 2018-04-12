package com.sds.perf.ch03.exception;

public class TryCatch {
	
	int LOOP_COUNT=1000;
	boolean result;
	
	public static void main(String[] args) {
		TryCatch tc = new TryCatch();
		tc.tryCatchExceptionThrow();
		tc.tryCatchNoException();
		tc.normal();
	}
	
	public void tryCatchExceptionThrow() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			try {
				result=resultProcessThrow(0);
			} catch(Exception e) {
				
			}
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("tryCatchExceptionThrow nano="+elapsedTime);
	}
	
	public void tryCatchNoException() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			try {
				result=resultProcessThrow(1);
			} catch(Exception e) {
				
			}
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("tryCatchNoException nano="+elapsedTime);
	}

	public void normal() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=resultProcess(0);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("normal nano="+elapsedTime);
	}
	
	public boolean resultProcessThrow(int data) throws RuntimeException{
		if(data==0) {
			throw new RuntimeException("Exception Occured");
		} else {
			return true;
		}
	}
	
	public boolean resultProcess(int data) {
		if(data==0) {
			return false;
		} else {
			return true;
		}
	}
}
