package baekjoon.r2_silver;

import java.util.Scanner;

public class BOJ_1904_01타일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		arr[1] = 1;
		if(N > 1) arr[2] = 2;
		
		for(int i=3; i<=N; i++) {
			arr[i] = (arr[i-1] + arr[i-2] ) % 15746;
		}
		System.out.println(arr[N]);
	}
}