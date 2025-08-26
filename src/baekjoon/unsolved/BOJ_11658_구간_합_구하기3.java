package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_11658_구간_합_구하기3 {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static long[][] bit;
	private static long[][] map;

	public static void main(String[] args) throws IOException {
		init();
		solution();
		System.out.print(sb);
	}

	private static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new long[N + 1][N + 1];
		bit = new long[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				long v = Long.parseLong(st.nextToken());
				map[i][j] = v;
				add(i, j, v);
			}
		}
	}

	private static void solution() throws IOException {
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());

			if (oper == 0) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				long num = Long.parseLong(st.nextToken());
				long delta = num - map[x][y];
				map[x][y] = num;
				add(x, y, delta);
			} else {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());

				if (x1 > x2) {
					int t = x1;
					x1 = x2;
					x2 = t;
				}
				if (y1 > y2) {
					int t = y1;
					y1 = y2;
					y2 = t;
				}

				long result = sum(x2, y2) - sum(x1 - 1, y2) - sum(x2, y1 - 1) + sum(x1 - 1, y1 - 1);
				sb.append(result).append('\n');
			}
		}
	}

	private static void add(int x, int y, long delta) {
		for (int i = x; i <= N; i += (i & -i)) {
			for (int j = y; j <= N; j += (j & -j)) {
				bit[i][j] += delta;
			}
		}
	}

	private static long sum(int x, int y) {
		if (x <= 0 || y <= 0) return 0;
		long s = 0;
		for (int i = x; i > 0; i -= (i & -i)) {
			for (int j = y; j > 0; j -= (j & -j)) {
				s += bit[i][j];
			}
		}
		return s;
	}
}