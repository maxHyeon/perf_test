package com.sds.perf.ch04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomKeyUtil {
	public static int[] generateRandomNumberKeysRemove(int size) { 
		ArrayList<Integer> data = new ArrayList<Integer>(size);
		int result[] = new int[size];
		Random random = new Random();
		int maxNumber = size;
		for (int loop = 0; loop < size; loop++) {
			data.add(loop);
		}
		for (int loop = 0; loop < size; loop++) {
			int randomNumber = random.nextInt(maxNumber--);
			result[loop] = data.remove(randomNumber);
		}
		return result;
	}
	public static int[] generateRandomNumberKeysSwap(int size) { 
		int result[] = new int[size];
		Random random = new Random();
		int maxNumber = size;
		for (int loop = 0; loop < size; loop++) {
			result[loop]=loop;
		}
		for (int loop = 0; loop < size; loop++) {
			int randomNumber1 = random.nextInt(maxNumber);
			int randomNumber2 = random.nextInt(maxNumber);
			int temp=result[randomNumber2];
			result[randomNumber2]=result[randomNumber1];
			result[randomNumber1]=temp;
		}
		return result;
	}
	public static String[] generateRandomSetKeysRemove(Set<String> set) {
		int size=set.size();
		ArrayList<String> data = new ArrayList<String>(size);
		String result[] = new String[size];
		Random random = new Random();
		int maxNumber = size;
		Iterator<String> iterator=set.iterator();
		while (iterator.hasNext()) {
			data.add(iterator.next());
		}
		for (int loop = 0; loop < size; loop++) {
			int randomNumber = random.nextInt(maxNumber--);
			result[loop] = data.remove(randomNumber);
		}
		return result;
	}
	
	public static String[] generateRandomSetKeysSwap(Set<String> set) {
		int size=set.size();
		String result[] = new String[size];
		Random random = new Random();
		int maxNumber = size;
		Iterator<String> iterator=set.iterator();
		int resultPos=0;
		while (iterator.hasNext()) {
			result[resultPos++]=iterator.next();
		}
		for (int loop = 0; loop < size; loop++) {
			int randomNumber1 = random.nextInt(maxNumber);
			int randomNumber2 = random.nextInt(maxNumber);
			String temp=result[randomNumber2];
			result[randomNumber2]=result[randomNumber1];
			result[randomNumber1]=temp;
		}
		
		return result;
	}
	
	public void generateRemove() {
//		generateRandomNumberKeysRemove(1000);
		Set<String> set=new HashSet<String>();
		for(int loop=0;loop<1000;loop++) {
			set.add(""+loop);
		}
		generateRandomSetKeysRemove(set);
	}
	public void generateSwap() {
//		generateRandomNumberKeysSwap(1000);
		Set<String> set=new HashSet<String>();
		for(int loop=0;loop<1000;loop++) {
			set.add(""+loop);
		}
		generateRandomSetKeysSwap(set);
	}
	
}
