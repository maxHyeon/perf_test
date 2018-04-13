package com.sds.perf.ch06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoClosableTest {

	public static void main(String[] args) throws IOException {
		printReverse("sample.txt");
	}

	public static void printReverse(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		List<String> m = new ArrayList<String>();
		try {
			String line = br.readLine();
			while (line != null) {
				m.add(line);
				line = br.readLine();

			}
		} finally {
			br.close();
		}
		for (int i = m.size() - 1; i >= 0; i--) {
			System.out.println(m.get(i));
		}
	}

}
