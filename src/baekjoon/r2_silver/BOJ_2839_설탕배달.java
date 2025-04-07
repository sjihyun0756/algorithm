package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		Arrays.fill(dp,-1);
		
		if(N>=3) dp[3] = 1;
		if(N>=5) dp[5] = 1;
		
		for(int i = 6; i<N+1; i++) {
			if(dp[i-3] != -1) dp[i] = dp[i-3] + 1;
			
			if(dp[i-5] != -1) {
				dp[i] = dp[i-5] + 1;
				dp[i] = Math.min(dp[i], dp[i-5] +1);
			}
		}
		System.out.println(dp[N]);
	}
}
