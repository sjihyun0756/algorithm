package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1736_쓰레기_치우기 {
	
	private static int N, M;
	private static boolean[][] map;
	private static boolean[][] visit;
	private static int[] dx = {0,1};
	private static int[] dy = {1,0};
	
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] out = q.poll();
			int x = out[0], y = out[1];
			
			for(int d = 0; d<2; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(0<= nx && nx < N && 0<= ny && ny < M) {
					q.offer(new int[] {nx, ny});
					if(map[nx][ny]) map[nx][ny] = false;
				}
			}
		}
		
	}
	
	private static void dfs(int x, int y) {
		if(map[x][y]) map[x][y] = false;
		
		for(int d = 0; d<2; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0<= nx && nx < N && 0<= ny && ny < M && map[nx][ny]) {
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
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		
		int robotCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]) {
					dfs(i, j);
					robotCnt++;
				}
			}
		}
		System.out.println(robotCnt);
	}
}
