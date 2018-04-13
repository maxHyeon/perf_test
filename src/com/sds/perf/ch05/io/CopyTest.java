package com.sds.perf.ch05.io;

import java.io.*;

public class CopyTest {
	public static void main(String args[]) throws Exception {
		byte[] buf = new byte[4];
		int length = 0;

		long startTime, endTime;
		startTime=System.nanoTime();

		InputStream in = new FileInputStream(args[0]);
		OutputStream out = new FileOutputStream(args[1]);

		while ((length = in.read(buf)) != -1)
			out.write(buf, 0, length);
		out.flush();
		out.close();
		in.close();

		endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("CopyFile nano="+elapsedTime);
	}
}
