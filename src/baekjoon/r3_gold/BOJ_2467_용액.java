package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		int[] result = new int[2];
		int dis = Integer.MAX_VALUE;
		
		while(left < right) {
//			System.out.println("left : " + left + " right : " + right);
			int sum = arr[left] + arr[right];
			
			if(dis > Math.abs(sum)) {
				dis = sum;
				result[0] = arr[left];
				result[1] = arr[right];
			}
			
			if(sum ==0) {
				break;
			}else if(sum < 0) {
				left++;
			}else { //sum >0
				right--;
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}
}
