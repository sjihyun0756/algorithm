package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
	static int[] card;
	static int[] result = new int[3];
	static int minSum = Integer.MIN_VALUE;
	static int M;
	
	private static void findCombination(int depth, int last) {
		if(depth==3) {
			int sum = 0;
			for(int n: result) {
				sum+=n;
			}
			if(sum<=M) minSum = Math.max(minSum, sum);
			return;
		}
		
		for(int i = last+1; i<card.length; i++) {
			result[depth] = card[i];
			findCombination(depth+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		findCombination(0,-1);
		System.out.println(minSum);
	}
}