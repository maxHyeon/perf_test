package com.sds.perf.ch07.secure;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i));
		}
	}

	public void writeList() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("OutFile.txt"));
			for (int i = 0; i < SIZE; i++) {
				out.println("Value at: " + i + " = " + list.get(i));
			}
			if (out != null) {
				out.close();
			}
		} catch (IndexOutOfBoundsException e) { // ¡¦
		} catch (IOException e) { // ¡¦

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	// ......
}