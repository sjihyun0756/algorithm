package baekjoon.r2_silver;

import java.util.*;

public class BOJ_2156_포도주_시식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] wine = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			wine[i] = sc.nextInt();
		}
		
		dp[1] = wine[1];
		if(N>=2) dp[2] = wine[1] + wine[2];
		
		for(int i=3; i<=N; i++) {
			int case1 = dp[i-1];
			int case2 = dp[i-2] + wine[i];
			int case3 = dp[i-3] + wine[i-1] + wine[i];
			dp[i] = Math.max(case1, Math.max(case2, case3));
		}
		System.out.println(dp[N]);
	}
}
