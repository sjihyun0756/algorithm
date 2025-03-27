package swea.unsolved;

import java.io.*;
import java.util.*;

public class SWEA_1953_탈주범_검거 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int L;

	private static int bfs(int R, int C, int caseNum) {
	    int[] dx = { 0, 0, 1, -1 }; 
	    int[] dy = { 1, -1, 0, 0 };

	    int[][] direction = {{},{0,1,2,3},{2,3},{0,1},{0,3},{0,2},{1,2},{1,3}};

	    Queue<int[]> q = new ArrayDeque<>();
	    q.offer(new int[] { R, C, caseNum });
	    visit[R][C] = true;

	    int level = 1;
	    int cnt = 1;

	    while (!q.isEmpty()) {
	        if (level == L) break; 

	        int size = q.size();
	        for (int s = 0; s < size; s++) {
	            int[] points = q.poll();
	            int x = points[0], y = points[1], cNum = points[2];

	            for (int d : direction[cNum]) {
	                int nx = x + dx[d], ny = y + dy[d];

	                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || map[nx][ny] == 0)
	                    continue;

	                int nextCaseNum = map[nx][ny];
	                boolean connect = false;

	                if (d == 0 && (nextCaseNum == 1 || nextCaseNum == 3 || nextCaseNum == 6 || nextCaseNum == 7))
	                    connect = true;
	                else if (d == 1 && (nextCaseNum == 1 || nextCaseNum == 3 || nextCaseNum == 4 || nextCaseNum == 5))
	                    connect = true; 
	                else if (d == 2 && (nextCaseNum == 1 || nextCaseNum == 2 || nextCaseNum == 4 || nextCaseNum == 7))
	                    connect = true; 
	                else if (d == 3 && (nextCaseNum == 1 || nextCaseNum == 2 || nextCaseNum == 5 || nextCaseNum == 6))
	                    connect = true; 

	                if (connect) {
	                    visit[nx][ny] = true;
	                    q.offer(new int[] { nx, ny, nextCaseNum });
	                    cnt++;
	                }
	            }
	        }
	        level++;
	    }
	    return cnt;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			int R = Integer.parseInt(st.nextToken()); // 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 가로 위치
			L = Integer.parseInt(st.nextToken()); // 시간

			map = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0)
						visit[i][j] = true;
				}
			}

			int result = bfs(R, C, map[R][C]);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
