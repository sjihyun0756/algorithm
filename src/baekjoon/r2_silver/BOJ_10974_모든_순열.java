package baekjoon.r2_silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10974_모든_순열 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		arr = new int[N];
		result = new int[N];
		visit = new boolean[N];
		
		Arrays.setAll(arr, i->i+1);
		
		permutation(0);
		System.out.println(sb);
	}

}
