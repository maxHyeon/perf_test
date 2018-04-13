package com.sds.perf.ch07.prob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorHandling {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			URL url = new URL("http://openeg.co.kr/");
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
			Date date = format.parse(line);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
					// ...
				}
			}
		}
	}
}