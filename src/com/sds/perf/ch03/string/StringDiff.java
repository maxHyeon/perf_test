package com.sds.perf.ch03.string;


////4 ms
//public class StringDiff {
//	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
//		String stra = "P"+ "erformace";
//		String strb = "Performanc" + "e";
//		for(int i=0; i<1000000; i++){
//		  stra.equals(strb);
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//	}
//}
//
//
//
//
////12 ms
//public class StringDiff {
//	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
//		String stra ="Performance";
//		String strb ="PerformancE";
//		for(int i=0;i<1000000;i++){
//		  stra.equals(strb);
//		}	
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//	}
//}


//
//
////15 ms 7ms
//public class StringDiff {
//	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
//		String stra ="Performance";
//		String strb="PerformanceA";
//		for(int i=0 ; i<1000000;i++){
//		  stra.equals(strb);
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//	}
//}
//
//
////48 ms
//public class StringDiff {
//	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
//		String stra = "Performance";
//		String strb = "PerformancE";
//		for(int i=0 ; i<1000000; i++){
//		  stra.equalsIgnoreCase(strb);
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//	}
//}




//55 ms  8ms
public class StringDiff {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String stra = "Performance";
		String strb = "PerformanceA";
		for(int i=0 ; i<1000000; i++){
		  stra.equalsIgnoreCase(strb);
		}	
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}

