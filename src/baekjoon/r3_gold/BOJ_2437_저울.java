package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_2437_저울 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int possibleNum = 1;
		for(int i=0; i<N; i++) {
			if(arr[i] <= possibleNum) possibleNum += arr[i];
			else break;
		}
		System.out.println(possibleNum);
	}
}
