package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_1010_다리놓기 {
	private static long calResult(int n, int c) {
		
		long result = 1;
		int r = n-c;
		for(int i=1; i<=c; i++) {
			result *= i + r;
			result /= i;
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			N = M-N < N ? M-N : N; 
			
			long result = calResult(M, N);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
