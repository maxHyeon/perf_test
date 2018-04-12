package com.sds.perf.ch04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListRemove  {
	int LOOP_COUNT=10;
	List<Integer> arrayList;
	List<Integer> vector;
	LinkedList<Integer> linkedList;
	
	public static void main(String[] args) {
		ListRemove list = new ListRemove();
		list.setUp();	
		list.removeArrayListFromFirst();
		list.removeArrayListFromLast();
		list.removeLinkedListFromFirst();
		list.removeLinkedListFromLast();
		list.removeVectorFromFirst();
		list.removeVectorFromLast();
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

	public void removeArrayListFromFirst() {
		long startTime=System.nanoTime();
		ArrayList<Integer> tempList=new ArrayList<Integer>(arrayList);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.remove(0);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("removeArrayListFromFirst nano="+elapsedTime);
	}

	public void removeVectorFromFirst() {
		long startTime=System.nanoTime();
		List<Integer> tempList=new Vector<Integer>(vector);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.remove(0);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("removeVectorFromFirst nano="+elapsedTime);
	}

	public void removeLinkedListFromFirst() {
		long startTime=System.nanoTime();
		LinkedList<Integer> tempList=new LinkedList<Integer>(linkedList);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.remove(0);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("removeLinkedListFromFirst nano="+elapsedTime);
	}
	

	public void removeArrayListFromLast() {
		long startTime=System.nanoTime();
		ArrayList<Integer> tempList=new ArrayList<Integer>(arrayList);
		for(int loop=LOOP_COUNT-1;loop>=0;loop--) {
			tempList.remove(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("removeArrayListFromLast nano="+elapsedTime);
	}

	public void removeVectorFromLast() {
		long startTime=System.nanoTime();
		List<Integer> tempList=new Vector<Integer>(vector);
		for(int loop=LOOP_COUNT-1;loop>=0;loop--) {
			tempList.remove(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("removeVectorFromLast nano="+elapsedTime);
	}

	public void removeLinkedListFromLast() {
		long startTime=System.nanoTime();
		LinkedList<Integer> tempList=new LinkedList<Integer>(linkedList);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.removeLast();
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("removeLinkedListFromLast nano="+elapsedTime);
	}
	
}