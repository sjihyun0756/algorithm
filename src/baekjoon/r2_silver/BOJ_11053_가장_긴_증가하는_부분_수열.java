package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_11053_가장_긴_증가하는_부분_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int A = Integer.parseInt(br.readLine());
		int[] nums = new int[A+1];
		int[] dp = new int[A+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<A+1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for(int i=1; i<A+1; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
