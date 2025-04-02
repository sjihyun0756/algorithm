package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_14442_벽_부수고_이동하기2 {
	
	static int N, M, K;
	static boolean[][] map;
	
	private static int bfs() {
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0,K});
        
        boolean[][][] visit = new boolean[N][M][K+1];
		visit[0][0][K] = true;
		
		int level = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int[] out = q.poll();
				int x = out[0], y = out[1], heart = out[2];
				
				if(x == N-1 && y == M-1) return level;
				
				for(int d = 0; d<4; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					
					if(nx<0 || N<= nx || ny<0 || M<= ny) continue;
					
					if(map[nx][ny] && !visit[nx][ny][heart]) { //길임
						visit[nx][ny][heart] = true;
						q.offer(new int[] {nx, ny, heart});
					}else if(!map[nx][ny] && heart >= 1 && !visit[nx][ny][heart-1]) { //벽임
						visit[nx][ny][heart-1] = true;
						q.offer(new int[] {nx, ny, heart-1});
					}
				}
			}
			level++;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //heart
		map = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j) == '0'; //길(0) = true;
			}
		}
		System.out.println(bfs());
	}
}