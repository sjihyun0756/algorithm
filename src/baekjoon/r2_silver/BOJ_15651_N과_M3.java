package baekjoon.r2_silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15651_N과_M3 {
	
	static int[] arr;
	static int[] result;
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
			result[depth] = arr[i];
			permutation(depth+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N];
		Arrays.setAll(arr, i->i+1);
		result = new int[M];
		
		permutation(0);
		System.out.println(sb);
	}
}
