//package swea.d3;
//
//import java.io.*;
//import java.util.*;
//
//public class SWEA_3282_01_Knapsack {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;
//		
//		int T = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc<=T; tc++) {
//			st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			int K = Integer.parseInt(st.nextToken());
//			
//			int[][] dp = new int[N+1][K+1];
//			for(int i = 1; i<N+1; i++) {
//				st = new StringTokenizer(br.readLine());
//				int V = Integer.parseInt(st.nextToken());
//				int C = Integer.parseInt(st.nextToken());
//				
//				for(int j=1; j<K+1; j++) {
//					if (j < V) dp[i][j] = dp[i-1][j];
//					else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - V] + C);
//				}
//			}
//			sb.append("#"+tc+" " + dp[N][K]).append("\n");
//		}
//		System.out.println(sb);
//	}
//}

package swea.d3;

import java.io.*;
import java.util.*;

public class SWEA_3282_01_Knapsack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] dp = new int[K + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int V = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				for (int j = K; j >= V; j--) {
					dp[j] = Math.max(dp[j], dp[j - V] + C);
				}
			}
			sb.append("#"+ tc + " " + dp[K]).append("\n");
		}
		System.out.print(sb);
	}
}