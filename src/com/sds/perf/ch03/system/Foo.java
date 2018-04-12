package com.sds.perf.ch03.system;
//totalMemory, freeMemory: 자바 메모리 총 용량, 남은 용량 보기 예제


public class Foo {
  public static void main (String[] args) {

    double[] n1 = new double[1000000];
    double[] n2 = new double[1000000];


    long free  = Runtime.getRuntime().freeMemory();
    long total = Runtime.getRuntime().totalMemory();
    long max   = Runtime.getRuntime().maxMemory();


    System.out.format("Total Memory : %6.2f MB%n", (double) total / (1024 * 1024));
    System.out.format("Free  Memory : %6.2f MB%n", (double) free  / (1024 * 1024));
    System.out.format("Max   Memory : %6.2f MB%n", (double) max   / (1024 * 1024));


  }
}

