package com.sds.perf.ch07.secure;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class FileMgmtThread extends Thread {
	private static final String SYNC = "SYNC";
	private String manageType = "";

	public FileMgmtThread(String type) {
		manageType = type;
	}

	public void run() {
		synchronized (SYNC) {
			try {
				if (manageType.equals("READ")) {
					File f = new File("Test_367.txt");
					if (f.exists()) {
						BufferedReader br = new BufferedReader(new FileReader(f));
						br.close();
					}
				} else if (manageType.equals("DELETE")) {
					File f = new File("Test_367.txt");
					if (f.exists()) {
						f.delete();
					} else {
						// ...
					}
				}
			} catch (IOException e) {
				// ...

			}
		}
	}
}

public class CWE367 {
	public static void main(String[] args) {
		FileMgmtThread fileAccessThread = new FileMgmtThread("READ");
		FileMgmtThread fileDeleteThread = new FileMgmtThread("DELETE");
		fileAccessThread.start();
		fileDeleteThread.start();
	}
}
