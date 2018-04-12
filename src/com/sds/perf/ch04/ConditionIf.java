package com.sds.perf.ch04;

import java.util.Random;

public class ConditionIf {
	int LOOP_COUNT=1000;
	
	public static void main(String[] args) {
		ConditionIf condition = new ConditionIf();
		condition.randomOnly();
		condition.if10();
		condition.if100();
	}

	public void randomOnly() {
		long startTime=System.nanoTime();
		Random random=new Random();
		int data=1000+random.nextInt();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			resultProcess("dummy");
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("randomOnly nano="+elapsedTime);
	}

	public void if10() {
		long startTime=System.nanoTime();
		Random random=new Random();
		String result=null;
		int data=1000+random.nextInt();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			if(data<50) { result="50";
			} else if(data<150) { result="150";
			} else if(data<250) { result="250";
			} else if(data<350) { result="350";
			} else if(data<450) { result="450";
			} else if(data<550) { result="550";
			} else if(data<650) { result="650";
			} else if(data<750) { result="750";
			} else if(data<850) { result="850";
			} else if(data<950) { result="950";
			} else { result="over";
			}
			resultProcess(result);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("if10 nano="+elapsedTime);
	}

	public void if100() {
		long startTime=System.nanoTime();
		Random random=new Random();
		String result=null;
		int data=10000+random.nextInt();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			if(data<50) { result="50";
			} else if(data<150) { result="150";
			} else if(data<250) { result="250";
			} else if(data<350) { result="350";
			} else if(data<450) { result="450";
			} else if(data<550) { result="550";
			} else if(data<650) { result="650";
			} else if(data<750) { result="750";
			} else if(data<850) { result="850";
			} else if(data<950) { result="950";
			} else if(data<1050) { result="1050";
			} else if(data<1150) { result="1150";
			} else if(data<1250) { result="1250";
			} else if(data<1350) { result="1350";
			} else if(data<1450) { result="1450";
			} else if(data<1550) { result="1550";
			} else if(data<1650) { result="1650";
			} else if(data<1750) { result="1750";
			} else if(data<1850) { result="1850";
			} else if(data<1950) { result="1950";
			} else if(data<2050) { result="2050";
			} else if(data<2150) { result="2150";
			} else if(data<2250) { result="2250";
			} else if(data<2350) { result="2350";
			} else if(data<2450) { result="2450";
			} else if(data<2550) { result="2550";
			} else if(data<2650) { result="2650";
			} else if(data<2750) { result="2750";
			} else if(data<2850) { result="2850";
			} else if(data<2950) { result="2950";
			} else if(data<3050) { result="3050";
			} else if(data<3150) { result="3150";
			} else if(data<3250) { result="3250";
			} else if(data<3350) { result="3350";
			} else if(data<3450) { result="3450";
			} else if(data<3550) { result="3550";
			} else if(data<3650) { result="3650";
			} else if(data<3750) { result="3750";
			} else if(data<3850) { result="3850";
			} else if(data<3950) { result="3950";
			} else if(data<4050) { result="4050";
			} else if(data<4150) { result="4150";
			} else if(data<4250) { result="4250";
			} else if(data<4350) { result="4350";
			} else if(data<4450) { result="4450";
			} else if(data<4550) { result="4550";
			} else if(data<4650) { result="4650";
			} else if(data<4750) { result="4750";
			} else if(data<4850) { result="4850";
			} else if(data<4950) { result="4950";
			} else if(data<5050) { result="5050";
			} else if(data<5150) { result="5150";
			} else if(data<5250) { result="5250";
			} else if(data<5350) { result="5350";
			} else if(data<5450) { result="5450";
			} else if(data<5550) { result="5550";
			} else if(data<5650) { result="5650";
			} else if(data<5750) { result="5750";
			} else if(data<5850) { result="5850";
			} else if(data<5950) { result="5950";
			} else if(data<6050) { result="6050";
			} else if(data<6150) { result="6150";
			} else if(data<6250) { result="6250";
			} else if(data<6350) { result="6350";
			} else if(data<6450) { result="6450";
			} else if(data<6550) { result="6550";
			} else if(data<6650) { result="6650";
			} else if(data<6750) { result="6750";
			} else if(data<6850) { result="6850";
			} else if(data<6950) { result="6950";
			} else if(data<7050) { result="7050";
			} else if(data<7150) { result="7150";
			} else if(data<7250) { result="7250";
			} else if(data<7350) { result="7350";
			} else if(data<7450) { result="7450";
			} else if(data<7550) { result="7550";
			} else if(data<7650) { result="7650";
			} else if(data<7750) { result="7750";
			} else if(data<7850) { result="7850";
			} else if(data<7950) { result="7950";
			} else if(data<8050) { result="8050";
			} else if(data<8150) { result="8150";
			} else if(data<8250) { result="8250";
			} else if(data<8350) { result="8350";
			} else if(data<8450) { result="8450";
			} else if(data<8550) { result="8550";
			} else if(data<8650) { result="8650";
			} else if(data<8750) { result="8750";
			} else if(data<8850) { result="8850";
			} else if(data<8950) { result="8950";
			} else if(data<9050) { result="9050";
			} else if(data<9150) { result="9150";
			} else if(data<9250) { result="9250";
			} else if(data<9350) { result="9350";
			} else if(data<9450) { result="9450";
			} else if(data<9550) { result="9550";
			} else if(data<9650) { result="9650";
			} else if(data<9750) { result="9750";
			} else if(data<9850) { result="9850";
			} else if(data<9950) { result="9950";
			} else { result="over";
			}
			resultProcess(result);
		}
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("if100 nano="+elapsedTime);
		
	}
	
	String current;
	
	public void resultProcess(String result) {
		current=result;
	}
	
}
