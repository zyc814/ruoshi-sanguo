package main;

import java.util.ArrayList;
import java.util.Random;

public class Lottery {
	
	public static int getRandom (int min, int max) {
		Random rand = new Random();
		int num = rand.nextInt(max-min) + min;
		return num;
	}
	
	public static void markParties(String str) {
		if (str.contains("魏")) Container.parties[0] ++;
		else if (str.contains("蜀")) Container.parties[1] ++;
		else if (str.contains("吴")) Container.parties[2] ++;
		else if (str.contains("群")) Container.parties[3] ++;
		else if (str.contains("中立")) Container.parties[4] ++;
	}
	
	
	public static void rollGoldAndJade() {
		int rand = getRandom(0,8);
		int resultId;
		if (rand == 4) { // Jade
			int jadeIndex = getRandom(0,Container.jade.size());
			String[] str = (String[]) Container.jade.get(jadeIndex);
		    resultId = Integer.parseInt(str[0].substring(2, 5));
		} else { //gold
			int goldIndex = getRandom(0,Container.gold.size());
			String[] str = (String[]) Container.gold.get(goldIndex);
			resultId = Integer.parseInt(str[0].substring(2, 5));
		}
		
		String str[] = (String[]) Container.rawData.get(resultId-1);
		//System.out.println(str[0] + str[2] + str[3]);
		
		markParties(str[2]);
		Container.candidates[0] = resultId;
	}
	
	public static void rollSilver() {
		int[] silverId = {0,0,0};
		int silverIndex1 = getRandom(0,Container.silver.size());
		String[] str1 = (String[]) Container.silver.get(silverIndex1);
		markParties(str1[2]);
		silverId[0] = Integer.parseInt(str1[0].substring(2, 5));
		
		int silverIndex2;
		do {silverIndex2 = getRandom(0,Container.silver.size());} 
		while (silverIndex1 == silverIndex2);
		String[] str2 = (String[]) Container.silver.get(silverIndex2);
		markParties(str2[2]);
		silverId[1] = Integer.parseInt(str2[0].substring(2, 5));
		
		int silverIndex3;
		do {silverIndex3 = getRandom(0,Container.silver.size());} 
		while (silverIndex1 == silverIndex3 || silverIndex2 == silverIndex3);
		String[] str3 = (String[]) Container.silver.get(silverIndex3);
		markParties(str3[2]);
		silverId[2] = Integer.parseInt(str3[0].substring(2, 5));
		
//		String str[] = (String[]) Container.rawData.get(silverId[0]-1);
//		System.out.println(str[0] + str[2] + str[3]);
//		str = (String[]) Container.rawData.get(silverId[1]-1);
//		System.out.println(str[0] + str[2] + str[3]);
//		str = (String[]) Container.rawData.get(silverId[2]-1);
//		System.out.println(str[0] + str[2] + str[3]);
		
		Container.candidates[1] = silverId[0];
		Container.candidates[2] = silverId[1];
		Container.candidates[3] = silverId[2];
	}
	
	public static int[] rollIron() {
		int ironId[] = {-1,-1,-1,-1,-1,-1};
		int wei =1000, shu = 1000, wu = 1000, qun = 1000, zl1 = 1000, zl2 = 1000, zl3 = 1000;
		
		if (Container.parties[0] < 1) { //no Wei of iron
			String str[];
			do {
				wei = getRandom(0,70);
				str = (String[]) Container.iron.get(wei);
			} while(!str[2].contains("魏"));
			markParties(str[2]);
			wei = Integer.parseInt(str[0].substring(2, 5));
		}
		
		if (Container.parties[1] < 1) { //no Shu of iron
			String str[];
			do {
				shu = getRandom(0,70);
				str = (String[]) Container.iron.get(shu);
			} while(!str[2].contains("蜀"));
			markParties(str[2]);
			shu = Integer.parseInt(str[0].substring(2, 5));
		}
		
		if (Container.parties[2] < 1) { //no Wu of iron
			String str[];
			do {
				wu = getRandom(0,70);
				str = (String[]) Container.iron.get(wu);
			} while(!str[2].contains("吴"));
			markParties(str[2]);
			wu = Integer.parseInt(str[0].substring(2, 5));
		}
		
		if (Container.parties[3] < 1) { //no Qun of iron
			String str[];
			do {
				qun = getRandom(0,70);
				str = (String[]) Container.iron.get(qun);
			} while(!str[2].contains("群"));
			markParties(str[2]);
			qun = Integer.parseInt(str[0].substring(2, 5));
		}
		
		if (Container.parties[4] < 3) { //no ZhongLi of iron;
			if (Container.parties[4] == 2) {
				zl1 = getRandom(0, Container.ironNeutral.size());
				String str[] = (String[]) Container.ironNeutral.get(zl1);
				markParties(str[2]);
				zl1 = Integer.parseInt(str[0].substring(2, 5));
			}
			if (Container.parties[4] == 1) {
				do {
					zl1 = getRandom(0, Container.ironNeutral.size());
					zl2 = getRandom(0, Container.ironNeutral.size());
				} while (zl1 == zl2);	
				String str1[] = (String[]) Container.ironNeutral.get(zl1);
				markParties(str1[2]);
				zl1 = Integer.parseInt(str1[0].substring(2, 5));
				String str2[] = (String[]) Container.ironNeutral.get(zl2);
				markParties(str2[2]);
				zl2 = Integer.parseInt(str2[0].substring(2, 5));
			}
			if (Container.parties[4] == 0) {
				do {
					zl1 = getRandom(0, Container.ironNeutral.size());
					zl2 = getRandom(0, Container.ironNeutral.size());
					zl3 = getRandom(0, Container.ironNeutral.size());
				} while (zl1 == zl2 || zl1 == zl3 || zl2 == zl3);
				String str1[] = (String[]) Container.ironNeutral.get(zl1);
				markParties(str1[2]);
				zl1 = Integer.parseInt(str1[0].substring(2, 5));
				String str2[] = (String[]) Container.ironNeutral.get(zl2);
				markParties(str2[2]);
				zl2 = Integer.parseInt(str2[0].substring(2, 5));
				String str3[] = (String[]) Container.ironNeutral.get(zl3);
				markParties(str3[2]);
				zl3 = Integer.parseInt(str3[0].substring(2, 5));
			}
		}
		
//		System.out.println(wei);
//		System.out.println(shu);
//		System.out.println(wu);
//		System.out.println(qun);
//		System.out.println(zl1);
//		System.out.println(zl2);
//		System.out.println(zl3);
		
		int temp[] = {wei, shu, wu, qun, zl1, zl2, zl3}; 
		int sum = 0;
		for (int i=0; i<7; i++) {
			if (temp[i] != 1000) {
				sum ++;
				ironId[sum-1] = temp[i];
				Container.candidates[3+sum] = temp[i];
			}
		}
		
//		for (int i=0; i<10; i++) {
//			System.out.println(Container.candidates[i]);
//		}
//		
//		for (int i=0; i<10; i++) {
//			String str[] = (String[]) Container.rawData.get(Container.candidates[i]-1);
//			System.out.println(str[0] +" "+ str[2] +" "+ str[3]);
//		}
		
//		System.out.println(Container.parties[0]);
//		System.out.println(Container.parties[1]);
//		System.out.println(Container.parties[2]);
//		System.out.println(Container.parties[3]);
//		System.out.println(Container.parties[4]);

		
		int diff = 6 - sum;
		for (int i=0; i< diff; i++) {
			int id;
			do { 
				id = getRandom(0, Container.iron.size()); 
			} while (dumplication(id, 3 + sum + 1));
			String str[] = (String[]) Container.iron.get(id);
			markParties(str[2]);
			Container.candidates[4 + sum + i] = Integer.parseInt(str[0].substring(2, 5));;
		}
		
		return ironId;
	}
	
	public static boolean dumplication(int id, int index) {
		for (int i=0; i<index; i++) {
			if (Container.candidates[i] == id) {
				return true;
			}
		}
		return false;
	}
	

}
