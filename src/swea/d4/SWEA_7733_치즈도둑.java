package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_7733_치즈도둑 {
	
	static int N;
	static int[][] cheese;
	static boolean[][] visit;
	
	private static void bfs(int i, int j, int day) {
		Queue<int[]> q = new ArrayDeque<>();
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] points = q.poll();
			int x = points[0], y = points[1];
			
			for(int d = 0; d<4; d++) {
				int nx = x + dx[d], ny = y+ dy[d];
				if(0<=nx && nx < N && 0<=ny && ny < N && !visit[nx][ny]  && cheese[nx][ny] > day) {
					visit[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			
			int maxDay = Integer.MIN_VALUE;
			int minDay = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					maxDay=Math.max(maxDay, cheese[i][j]);
					minDay=Math.min(minDay, cheese[i][j]);
				}
			}
			
			int cnt = 0; 
			int maxCnt = 1; //day = maxDay일 경우엔 한 덩어리로 1
			for(int day=minDay; day<maxDay; day++) {
				cnt = 0;
				visit = new boolean[N][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(cheese[i][j] > day && !visit[i][j]) {
							bfs(i, j, day);
							cnt++;
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			sb.append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}
}
