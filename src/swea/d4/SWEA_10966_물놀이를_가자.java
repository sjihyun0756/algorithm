package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_10966_물놀이를_가자 {
	static int N, M;
	static boolean[][] field; 
	static int[][] dist;
	static Queue<int[]> q;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] points = q.poll();
			int x = points[0];
			int y = points[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (0 <= nx && nx < N && 0 <= ny && ny < M && dist[nx][ny] == -1) {
					dist[nx][ny] = dist[x][y] + 1;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			field = new boolean[N][M];
			dist = new int[N][M];
			q = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					field[i][j] = input.charAt(j) == 'W';
					dist[i][j] = -1;
					if (field[i][j]) {
						q.offer(new int[] { i, j });
						dist[i][j] = 0;
					}
				}
			}

			bfs();
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					result += dist[i][j];
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
