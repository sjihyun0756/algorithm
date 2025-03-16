package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655_N과_M6 {
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	private static void combination(int depth, int last) {
		if(depth == result.length) {
			for(int n : result) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = last+1; i<arr.length; i++) {
			result[depth] = arr[i];
			combination(depth+1, i);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		combination(0,-1);
		System.out.println(sb);
	}
}
