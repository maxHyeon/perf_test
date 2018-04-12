package com.sds.perf.ch04;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetAdd  {
	int LOOP_COUNT=1000;
	Set<String> set;
	String data = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) {
		SetAdd set = new SetAdd();
		set.addHashSet();
		set.addHashSetWithInitialSize();
		set.addLinkedHashSet();
		set.addTreeSet();
	}
	
	public void addHashSet() {
		long startTime=System.nanoTime();
		set=new HashSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("addHashSet nano="+elapsedTime);
	}
	
	public void addHashSetWithInitialSize() {
		long startTime=System.nanoTime();
		set=new HashSet<String>(LOOP_COUNT);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("addHashSetWithInitialSize nano="+elapsedTime);
	}
	
	public void addTreeSet() {
		long startTime=System.nanoTime();
		set=new TreeSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("addTreeSet nano="+elapsedTime);
	}
	
	public void addLinkedHashSet() {
		long startTime=System.nanoTime();
		set=new LinkedHashSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("addLinkedHashSet nano="+elapsedTime);
	}
}
