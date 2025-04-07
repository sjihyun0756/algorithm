package baekjoon.r2_silver;

import java.util.*;

public class BOJ_14916_거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		Arrays.fill(dp, -1);

		if (N >= 2) dp[2] = 1;
		if (N >= 5) dp[5] = 1;
		
		for(int i = 3; i <= N; i++) {
			if (dp[i - 2] != -1) dp[i] = dp[i - 2] + 1;

			if (i >= 5 && dp[i - 5] != -1) {
				if (dp[i] == -1) dp[i] = dp[i - 5] + 1;
				else dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}
