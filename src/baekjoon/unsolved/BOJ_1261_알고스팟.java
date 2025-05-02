package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1261_알고스팟 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N, M;
	static int[][] map;
	static boolean[][][] visit;
	
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0,0});
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s<size; s++) {
				int[] out = q.poll();
				int x = out[0], y = out[1], broke = out[2];
				
				if(x == N-1 && y == M-1) return broke;
				
				for(int d = 0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || N <=nx || ny < 0 || M <=ny) continue;
					
					if(map[nx][ny] == 0 && !visit[nx][ny][broke]) {
						visit[nx][ny][broke] = true;
						q.offer(new int[] {nx, ny, broke});
					}else if(map[nx][ny] ==1 && !visit[nx][ny][broke+1]) { //벽임
						visit[nx][ny][broke+1] = true;
						q.offer(new int[] {nx, ny, broke+1});
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M][N*M+1];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j) -'0';
			}
		}
		System.out.println(bfs());
	}
}
