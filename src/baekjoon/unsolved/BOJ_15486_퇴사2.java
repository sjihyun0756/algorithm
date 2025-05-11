package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_15486_퇴사2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] day = new int[N];
		int[] money = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			day[i] = d;
			money[i] = m;
		}
		
		int result = 0;
		
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			int d = day[i];
			dp[i] = 
		}
	}
}
