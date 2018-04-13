package com.sds.perf.ch07.secure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//발생할 수 있는 오류의 종류와 순서에 맞춰서 예외 처리
public class ErrorHandling {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			URL url = new URL("http://openeg.co.kr/");
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
			Date date = format.parse(line);
		} catch (MalformedURLException e) {
			System.err.println("MalformedURLException : " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IOException : " + e.getMessage());
		} catch (ParseException e) {
			System.err.println("ParseException : " + e.getMessage());
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