package baekjoon.r2_silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOj_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[3][N+1];
			int[][] dp = new int[3][N+1];
			
			for(int i=1; i<3; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[1][1] = sticker[1][1];
			dp[2][1] = sticker[2][1];
			
			for (int j = 2; j <= N; j++) {
				dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + sticker[1][j];
				dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sticker[2][j];
			}
			
			sb.append(Math.max(dp[1][N], dp[2][N])).append("\n");
		}
		System.out.println(sb);
	}
}
