package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1561_놀이_공원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int target = N-M;
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = Integer.MAX_VALUE;
		int mid = 0;
		while(left<=right) {
			mid = (left + right) /2;
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				cnt += arr[i] / mid;
			}
			
			if(mid == target) {
				break;
			}else if(mid > target) {
				right--;
				
			}else if(mid < target) {
				left++;
			}
		}
		
		int result = 0;
		for(int i=N-1; i>=0; i--) {
			if(arr[i]/mid - arr[i]/(mid-1) != 0) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
