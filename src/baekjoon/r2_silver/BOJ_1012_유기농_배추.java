package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_1012_유기농_배추 {
	
	static int N, M;
	static boolean[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	private static void dfs(int x, int y) {
		map[x][y] = false;
		
		for(int d = 0; d<4; d++) {
			int nx = x + dx[d], ny = y + dy[d];
			if(0<=nx && nx < N && 0<= ny && ny<M && map[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new boolean[N][M];
			visit = new boolean[N][M];
			for(int i=0; i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = true;
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
