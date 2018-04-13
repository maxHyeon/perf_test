package com.sds.perf.ch07.prob;

import java.util.Arrays;

public class GetPrivateArrayByPublicMethod {
	private String[] colors;

	public String[] getColors() {
		return this.colors;
	}

	public GetPrivateArrayByPublicMethod() {
		this.colors = new String[] { "red", "orange", "yellow", "green", "blue", "indigo", "violet" };
	}

	public void print() {
		System.out.println(Arrays.toString(this.colors));
	}

	public static void main(String[] args) {
		GetPrivateArrayByPublicMethod innerData = new GetPrivateArrayByPublicMethod();
		innerData.print();
		String[] outerData = innerData.getColors();
		outerData[1] = "blue";
		System.out.println(Arrays.toString(outerData));
		innerData.print();
	}
}