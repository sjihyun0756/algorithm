package swea.swTest;

import java.io.*;
import java.util.*;

public class SWEA_1949_등산로_조성 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N, K, maxLength;
	static int[][] map;
	static boolean[][][] visit;
	
	private static void dfs(int x, int y, int heart, int cnt) {
		maxLength = Math.max(maxLength, cnt);
		
		for(int d = 0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visit[nx][ny][heart]) continue;
			
			if(map[x][y] > map[nx][ny]) {
				visit[nx][ny][heart] = true;
				dfs(nx,ny,heart,cnt+1);
				visit[nx][ny][heart] = false;
			}else if(map[x][y] > (map[nx][ny]-K) && heart==1 && !visit[nx][ny][0]) {
				int height = map[nx][ny];
	            map[nx][ny] = map[x][y] - 1;
	            visit[nx][ny][0] = true;
	            dfs(nx, ny, 0, cnt + 1);
	            visit[nx][ny][0] = false;
	            map[nx][ny] = height;
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
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			maxLength = 0;
			map = new int[N][N];
			visit = new boolean[N][N][2];
			int maxHeight = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == maxHeight) {
						visit[i][j][1] = true;
						dfs(i,j,1,1);
						visit[i][j][1] = false;
					}
				}
			}
			sb.append(maxLength).append("\n");
		}
		System.out.println(sb);
	}
}
