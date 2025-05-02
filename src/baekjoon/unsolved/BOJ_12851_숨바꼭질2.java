package baekjoon.unsolved;

import java.util.*;
import java.io.*;

public class BOJ_12851_숨바꼭질2 {

	private static int[] bfs(int N, int M) {
		int[] visit = new int[100001]; // 시간 저장
		int[] count = new int[100001]; // 방법 수 저장
		Arrays.fill(visit, -1);

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);
		visit[N] = 0;
		count[N] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : new int[] {cur - 1, cur + 1, cur * 2}) {
				if (next < 0 || next > 100000) continue;

				if (visit[next] == -1) {
					visit[next] = visit[cur] + 1;
					count[next] = count[cur];
					q.offer(next);
				} else if (visit[next] == visit[cur] + 1) {
					count[next] += count[cur];
				}
			}
		}

		return new int[] {visit[M], count[M]};
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		if (N == M) {
			System.out.println("0\n1");
			return;
		}

		int[] result = bfs(N, M);
		for (int r : result)
			System.out.println(r);
	}
}