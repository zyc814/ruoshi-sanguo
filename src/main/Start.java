package main;

import java.io.IOException;

public class Start {

	public static void main(String[] args) {
		
		Loader.loadRawData();
	
		Lottery.rollGoldAndJade();
		Lottery.rollSilver();
		Lottery.rollIron();
		
		for (int i=0; i<Container.candidates.length; i++) {
		String[] str = (String[]) Container.rawData.get(Container.candidates[i] - 1); 
		System.out.println(str[0] + " " + str[2] + " " + str[3]);
		}
		
		System.out.println("魏：" + Container.parties[0]);
		System.out.println("蜀：" + Container.parties[1]);
		System.out.println("吴：" + Container.parties[2]);
		System.out.println("群：" + Container.parties[3]);
		System.out.println("中立：" + Container.parties[4]);
		
	}
}