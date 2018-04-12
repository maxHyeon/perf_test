package com.sds.perf.ch04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetIterate  {
	int LOOP_COUNT=1000;
	Set<String> hashSet;
	Set<String> treeSet;
	Set<String> linkedHashSet;
	
	String data = "abcdefghijklmnopqrstuvwxyz";
	String []keys;
	
	String result=null;
	
	public static void main(String[] args) {
		SetIterate set = new SetIterate();
		set.setUp();
		set.iterateHashSet();
		set.iterateLinkedHashSet();
		set.iterateTreeSet();
	}

	public void setUp() {
		hashSet=new HashSet<String>();
		treeSet=new TreeSet<String>();
		linkedHashSet=new LinkedHashSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			String tempData=data+loop;
			hashSet.add(tempData);
			treeSet.add(tempData);
			linkedHashSet.add(tempData);
		}
	}

	public void iterateHashSet() {
		long startTime=System.nanoTime();
		Iterator<String> iter = hashSet.iterator();
		while(iter.hasNext()) {
			result = iter.next();
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("iterateHashSet nano="+elapsedTime);
	}
	
	public void iterateTreeSet() {
		long startTime=System.nanoTime();
		Iterator<String> iter = treeSet.iterator();
		while(iter.hasNext()) {
			result = iter.next();
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("iterateTreeSet nano="+elapsedTime);
	}
	
	public void iterateLinkedHashSet() {
		long startTime=System.nanoTime();
		Iterator<String> iter = linkedHashSet.iterator();
		while(iter.hasNext()) {
			result = iter.next();
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("iterateLinkedHashSet nano="+elapsedTime);
	}
}
