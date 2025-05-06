package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] RGB = new int[N][3];
		int[][] dp = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0; j<3; j++) {
			dp[0][j] = RGB[0][j];
		}
		
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}
		
		int result = Integer.MAX_VALUE;
		for(int j=0; j<3; j++) {
			result = Math.min(result, dp[N-1][j]);
		}
		System.out.println(result);
	}
}
