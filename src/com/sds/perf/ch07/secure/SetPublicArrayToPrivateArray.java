package com.sds.perf.ch07.secure;


import java.util.Arrays;

public class SetPublicArrayToPrivateArray {
	private String[] datas;

	public void setDatas(String[] datas) {
		this.datas = datas;
	}

	public SetPublicArrayToPrivateArray() {
		this.datas = new String[] { "100", "90", "70", "80" };
	}

	public void print() {
		System.out.println(Arrays.toString(this.datas));
	}

	public static void main(String[] args) {
		SetPublicArrayToPrivateArray innerData = new SetPublicArrayToPrivateArray();
		innerData.print();
		String[] outerData = new String[] { "10", "20", "30" };
		innerData.setDatas(outerData);
		innerData.print();
		System.out.println(Arrays.toString(outerData));
		outerData[1] = "xx";
		innerData.print();
		System.out.println(Arrays.toString(outerData));
	}
}
