package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_2468_안전_영역 {
	
	static int[][] area;
	static int N;
	static boolean[][] visit;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	private static void bfs(int i, int j, int h) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] points = q.poll();
			int x = points[0];
			int y = points[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(0<= nx && nx < N && 0<= ny && ny < N && !visit[nx][ny] && area[nx][ny] > h) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		
		int maxHeight = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, area[i][j]);
			}
		}//

		
		int maxCnt = 0;
		int cnt = 0;
		for(int h = 0; h<= maxHeight; h++) {
			cnt = 0;
			visit = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(area[i][j] > h && !visit[i][j]) {
						bfs(i, j, h);
						cnt++;
					}
					
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}//
}//
