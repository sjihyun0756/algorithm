package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1736_쓰레기_치우기 {
	
	private static int N, M;
	private static boolean[][] map;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	
	private static void dfs(int x, int y) {
		map[x][y] = false;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		
		int robotCnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]) {
					dfs(i, j);
					robotCnt++;
				}
			}
		}
		System.out.println(robotCnt);
	}
}
