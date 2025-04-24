package baekjoon.r2_silver;

import java.util.*;
import java.io.*;

public class BOJ_11723_집합 {
	
	private static StringBuilder sb = new StringBuilder();
	private static int standardNum = 0;
	
	private static void operate(String action, int num) {
		int actionNum = (1<<num);
		if(action.equals("add")) {
			standardNum |= actionNum;
		}else if(action.equals("remove")) {
			standardNum &= ~actionNum;
		}else if(action.equals("check")) {
			if ((standardNum & actionNum) != 0) sb.append("1").append("\n");
			else sb.append("0").append("\n");
		}else if(action.equals("toggle")) {
			if ((standardNum & actionNum) != 0) standardNum &= ~actionNum;
			else standardNum |= actionNum;
		}else if(action.equals("all")) {
			standardNum = (1<<21) -1;
		}else { //action -> empty
			standardNum = 0; 
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			if(action.equals("all") || action.equals("empty")) operate(action, 0);
			else {
				int num = Integer.parseInt(st.nextToken());
				operate(action, num);
			}
		}
		System.out.println(sb.toString());
	}
}
