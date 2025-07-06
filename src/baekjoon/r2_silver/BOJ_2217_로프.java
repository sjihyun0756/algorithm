package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_2217_로프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		
		for(int i=0; i<N; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(weight);
		
		int maxWeight = 0;
		for(int i=0; i<N; i++) {
			int minWeight = weight[i];
			int rope = N-i;
			
			maxWeight = Math.max(minWeight * rope, maxWeight);
		}
		System.out.println(maxWeight);
	}
}
