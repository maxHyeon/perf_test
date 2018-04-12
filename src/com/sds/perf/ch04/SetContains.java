package com.sds.perf.ch04;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetContains  {
	int LOOP_COUNT=1000;
	Set<String> hashSet;
	Set<String> treeSet;
	Set<String> linkedHashSet;
	
	String data = "abcdefghijklmnopqrstuvwxyz";
	String []keys;
	
	public static void main(String[] args) {
		SetContains set = new SetContains();
		set.setUp();
		set.containsHashSet();
		set.containsLinkedHashSet();
		set.containsTreeSet();	
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
		if(keys==null || keys.length!=LOOP_COUNT) {
			keys=RandomKeyUtil.generateRandomSetKeysSwap(hashSet);
		}
	}

	public void containsHashSet() {
		long startTime=System.nanoTime();
		for(String key:keys) {
			hashSet.contains(key);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("containsHashSet nano="+elapsedTime);
	}

	public void containsTreeSet() {
		long startTime=System.nanoTime();
		for(String key:keys) {
			treeSet.contains(key);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("containsTreeSet nano="+elapsedTime);
	}

	public void containsLinkedHashSet() {
		long startTime=System.nanoTime();
		for(String key:keys) {
			linkedHashSet.contains(key);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("containsLinkedHashSet nano="+elapsedTime);
	}
}
