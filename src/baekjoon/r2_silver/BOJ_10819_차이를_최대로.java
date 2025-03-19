package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_차이를_최대로 {
	
	static int[] numArr;
	static int[] result;
	static boolean[] visit;
	static int maxSum = 0;
	
	
	private static void findMax(int[] result) {
		int sum = 0;
		for(int i=0; i<result.length-1; i++) {
			sum += Math.abs(result[i] - result[i+1]);
		}
		maxSum = Math.max(sum, maxSum);
	}
	
	private static void permutation(int depth) {
		if(depth == result.length) {
			findMax(result);
			return;
		}
		
		for(int i=0; i<numArr.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[depth] = numArr[i];
			permutation(depth+1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		result = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0);
		System.out.println(maxSum);
	}
}
