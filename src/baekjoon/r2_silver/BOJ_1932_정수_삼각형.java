package baekjoon.r2_silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_정수_삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][N];
		int[][] dp = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = triangle[0][0];
		for(int i=1; i<N; i++) {
			for(int j=0; j<i+1; j++) {
				int case1 = 0, case2 = 0;
				if (j < i) case1 = dp[i-1][j] + triangle[i][j];
				if(0< j) case2 = dp[i-1][j-1] + triangle[i][j];
				dp[i][j] = Math.max(case1, case2);
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int j=0; j<N; j++) {
			result = Math.max(result, dp[N-1][j]);
		}
		System.out.println(result);
	}
}
