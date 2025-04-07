package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_1189_컴백홈 {
	
	static boolean[][] map;
	static int R, C, K;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int cnt = 0;
	
	private static void dfs(int x, int y, int distance) {
		
		if(x==0 && y == C-1 && distance == K) cnt++;
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d], ny = y + dy[d];
			if(0<= nx && nx < R && 0<= ny && ny < C && map[nx][ny]) {
				map[nx][ny] = false;
				dfs(nx, ny, distance+1);
				map[nx][ny] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j) == '.';
			}
		}
		
		map[R-1][0] = false;
		dfs(R-1,0,1);
		System.out.println(cnt);
	}
}
