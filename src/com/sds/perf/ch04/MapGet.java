package com.sds.perf.ch04;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapGet {
	int LOOP_COUNT=1000;
	Map<Integer,String> hashMap;
	Map<Integer,String> hashtable;
	Map<Integer,String> treeMap;
	Map<Integer,String> linkedHashMap;
	int keys[];
	
	public static void main(String[] args) {
		MapGet map = new MapGet();
		map.setUp();	
		map.getRandomHashMap();
		map.getRandomHashtable();
		map.getRandomLinkedHashMap();
		map.getRandomTreeMap();
		map.getSeqHashMap();
		map.getSeqHashtable();
		map.getSeqLinkedHashMap();
		map.getSeqTreeMap();
	}
	
	public void setUp() {
		if(keys==null || keys.length!=LOOP_COUNT) {
			hashMap=new HashMap<Integer,String>();
			hashtable=new Hashtable<Integer,String>();
			treeMap=new TreeMap<Integer,String>();
			linkedHashMap=new LinkedHashMap<Integer,String>();
			String data="abcdefghijklmnopqrstuvwxyz";
			for(int loop=0;loop<LOOP_COUNT;loop++) {
				String tempData=data+loop;
				hashMap.put(loop,tempData);
				hashtable.put(loop,tempData);
				treeMap.put(loop,tempData);
				linkedHashMap.put(loop,tempData);
			}
			keys=RandomKeyUtil.generateRandomNumberKeysSwap(LOOP_COUNT);
		}
	}

	public void getSeqHashMap() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashMap.get(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getSeqHashMap snano="+elapsedTime);
	}

	public void getRandomHashMap() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashMap.get(keys[loop]);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getRandomHashMap nano="+elapsedTime);
	}
	
	public void getSeqHashtable() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashtable.get(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getSeqHashtable nano="+elapsedTime);
	}

	public void getRandomHashtable() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashtable.get(keys[loop]);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getRandomHashtable nano="+elapsedTime);
	}
	

	public void getSeqTreeMap() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			treeMap.get(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getSeqTreeMap nano="+elapsedTime);
	}

	public void getRandomTreeMap() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			treeMap.get(keys[loop]);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getRandomTreeMap nano="+elapsedTime);
	}
	

	public void getSeqLinkedHashMap() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			linkedHashMap.get(loop);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getSeqLinkedHashMap nano="+elapsedTime);
	}

	public void getRandomLinkedHashMap() {
		long startTime=System.nanoTime();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			linkedHashMap.get(keys[loop]);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("getRandomLinkedHashMap nano="+elapsedTime);
	}
}