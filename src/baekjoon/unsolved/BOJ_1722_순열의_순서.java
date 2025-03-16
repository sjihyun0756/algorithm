package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1722_순열의_순서 {
	static int[] arr;
	static boolean[] visit;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	private static int findPermutation(int depth, int num) {
		if(depth == result.length) {
			num--;
			if(num==0) {
				for(int n : result) {
					sb.append(n).append(" ");
				}
				return 0;
			}
			return num;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[depth] = arr[i];
			num = findPermutation(depth+1, num);
			visit[i] = false;
			if (num == 0) return 0;
		}
		return num;
	}
	
	private static int findNum(int depth, int cnt, int[] targetArr) {
		if(depth == result.length) {
			cnt++;
			if (Arrays.equals(result, targetArr)) {
				sb.append(cnt);
				return -1;
			}
			return cnt;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[depth] = arr[i];
			cnt = findNum(depth+1, cnt, targetArr);
			visit[i] = false;
			if (cnt == -1) return 0;
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		Arrays.setAll(arr, i -> i + 1);
		result = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int caseNum = Integer.parseInt(st.nextToken());
		switch (caseNum) {
		case 1: {
			findPermutation(0, Integer.parseInt(st.nextToken()));
			System.out.println(sb);
			return;
		}
		case 2: {
			int[] targetArr = new int[N];
			for(int i=0; i<N; i++) {
				targetArr[i] = Integer.parseInt(st.nextToken());
			}
			findNum(0, 0, targetArr);
			System.out.println(sb);
			return;
		}
		}
	}
}
