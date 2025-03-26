package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_7562_나이트의_이동 {
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] field;
	static int N;
	
	private static int bfs(int startX, int startY, int endX, int endY) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startX, startY});
		field[startX][startY] = true;
		
		int level = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int[] points = q.poll();
				int x = points[0], y = points[1];
				
				if(x == endX && y ==endY) return level;
				
				for(int d = 0; d<8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(0<= nx && nx < N && 0<= ny && ny < N && !field[nx][ny]) {
						q.offer(new int[] {nx, ny});
						field[nx][ny] = true;
					}
				}
			}
			level++;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			field = new boolean[N][N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			
			int result = bfs(startX, startY, endX, endY);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
