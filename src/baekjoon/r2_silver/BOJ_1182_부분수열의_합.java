package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의_합 {

	static int S;
	static int[] arr;
	static int cnt = 0;

	private static void findCombination(int depth, int last, int sum) {
		if (sum == S && depth>0) cnt++; //공집합이 S=0에 걸리는 거 방지

		if (depth >= arr.length) return;

		for (int i = last + 1; i < arr.length; i++) {
			findCombination(depth + 1, i, sum + arr[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		findCombination(0, -1, 0);

		System.out.println(cnt);
	}

}
