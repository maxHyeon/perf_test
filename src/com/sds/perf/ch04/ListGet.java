package com.sds.perf.ch04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListGet  {
	int LOOP_COUNT=1000;
	List<Integer> arrayList;
	List<Integer> vector;
	LinkedList<Integer> linkedList;
	
	int result=0;
	
	public static void main(String[] args) {
		ListGet list = new ListGet();
		list.setUp();	
		list.getArrayList();
		list.getLinkedList();
		list.getVector();
		list.peekLinkedList();
	}

	public void setUp() {
		arrayList=new ArrayList<Integer>();
		vector=new Vector<Integer>();
		linkedList=new LinkedList<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			arrayList.add(loop);
			vector.add(loop);
			linkedList.add(loop);
		}
		
	}

	public void getArrayList() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=arrayList.get(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getArrayList nano="+elapsedTime);
	}

	public void getVector() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=vector.get(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getVector nano="+elapsedTime);
	}

	public void getLinkedList() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=linkedList.get(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getLinkedList nano="+elapsedTime);
	}

	public void peekLinkedList() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=linkedList.peek();
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("peekLinkedList nano="+elapsedTime);
	}

}