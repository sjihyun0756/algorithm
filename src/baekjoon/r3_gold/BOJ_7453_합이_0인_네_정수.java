package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_7453_합이_0인_네_정수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] board = new int[4][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				board[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		int[] ab = new int[N * N];
		int[] cd = new int[N * N];
		int idx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ab[idx] = board[0][i] + board[1][j];
				cd[idx] = board[2][i] + board[3][j];
				idx++;
			}
		}

		Arrays.sort(ab);
		Arrays.sort(cd);

		int left = 0;
		int right = cd.length - 1;
		long cnt = 0;

		while (left < ab.length && right >= 0) {
			int sum = ab[left] + cd[right];

			if (sum == 0) {
				int abVal = ab[left];
				int cdVal = cd[right];
				long abCount = 0;
				while (left < ab.length && ab[left] == abVal) {
					left++;
					abCount++;
				}
				long cdCount = 0;
				while (right >= 0 && cd[right] == cdVal) {
					right--;
					cdCount++;
				}
				cnt += abCount * cdCount;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(cnt);
	}
}