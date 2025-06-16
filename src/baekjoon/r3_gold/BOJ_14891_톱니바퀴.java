package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_14891_톱니바퀴 {
	
	private static List<Integer>[] gears;
	
	private static int[] setDirection(int gearNum, int dir) {
		boolean[] pole = new boolean[3];
		if (gears[0].get(2) != gears[1].get(6)) pole[0] = true;
		if (gears[1].get(2) != gears[2].get(6)) pole[1] = true; 
		if (gears[2].get(2) != gears[3].get(6)) pole[2] = true;
		
		int[] direction = new int[4];
		direction[gearNum] = dir;
		
		for (int i = gearNum - 1; i >= 0; i--) {
			if (!pole[i]) break;
			direction[i] = - direction[i + 1];
		}
		
		for (int i = gearNum +1 ; i < 4; i++) {
			if (!pole[i-1]) break;
			direction[i] = - direction[i - 1];
		}
		return direction;
	}
	
	private static void moveGear(int gearNum, int dir) {
		int[] direction = setDirection(gearNum, dir);
		
		for (int i = 0; i < 4; i++) {
			if (direction[i] != 0) Collections.rotate(gears[i], direction[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gears = new ArrayList[4];
		for(int i=0; i<4; i++) {
			String input = br.readLine();
			gears[i] = new ArrayList<>();
			for(int j=0; j<8; j++) {
				gears[i].add(input.charAt(j)-'0');
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			
			moveGear(gearNum, dir);
		}
		
		int result = 0;
		for(int i=0; i<4; i++) {
			if(gears[i].get(0) == 1) result += Math.pow(2, i); 
		}
		System.out.println(result);
	}
}
