package baekjoon.r2_silver;

import java.util.*;

public class BOJ_2579_계단_오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stair = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1; i<N+1; i++) {
			stair[i] = sc.nextInt();
		}
		
		dp[1] = stair[1];
		if(N>=2) dp[2] = stair[1] + stair[2];
		
		for(int i=3; i<N+1; i++) {
			int cal1 = dp[i-2] + stair[i];
			int cal2 = dp[i-3] + stair[i-1] + stair[i];
			
			dp[i] = Math.max(cal1, cal2);
		}
		System.out.println(dp[N]);
	}
}
