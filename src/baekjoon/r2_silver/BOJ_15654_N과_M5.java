package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_15654_N과_M5 {
	
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	private static void permutation(int depth) {
		if(depth == result.length) {
			for(int n : result) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[depth] = arr[i];
			permutation(depth+1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = (Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		permutation(0);
		System.out.println(sb);
	}
}
