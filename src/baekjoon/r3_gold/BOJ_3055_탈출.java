package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_3055_탈출 {
	
	static char[][] map;
	static int R;
	static int C;
	static int[] endP;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Set<int[]> waterIdx = new HashSet<>();
	
	private static int bfs(int i, int j){
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		map[i][j] = '#'; //지나감을 표시
		
		int cnt = 0;
		while(!q.isEmpty()) {
			
			//물 먼저 뻗기
			Set<int[]> tmpwaterIdx = new HashSet<>(waterIdx);
			for(int[] idx : tmpwaterIdx) {
				int waterX = idx[0];
				int waterY = idx[1];
				
				for(int d = 0; d<4; d++) {
					int nx = waterX + dx[d];
					int ny = waterY + dy[d];
					
					if(0<=nx && nx < R && 0<=ny && ny < C) {
						if(map[nx][ny] == '.' || map[nx][ny] == '#' || map[nx][ny] == 'S') {
							map[nx][ny] = '*'; // 물로 채움
							waterIdx.add(new int[] {nx, ny});
						}
					}
				}
			}
			
			int size = q.size();
			for(int s = 0; s<size; s++) {
				int[] points = q.poll();
				int x = points[0];
				int y = points[1];
				
				if(x == endP[0] && y == endP[1]) return cnt;
				
				for(int d = 0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(0<=nx && nx < R && 0<=ny && ny < C) {
						if(map[nx][ny] == '.' || map[nx][ny] == 'D') {
							q.offer(new int[] {nx,ny});
							map[nx][ny] = '#'; //지나감을 표시
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		int[] startP = new int[2];
		endP = new int[2];
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'S') {
					startP[0] = i;
					startP[1] = j;
				}
				
				if(map[i][j] == 'D') {
					endP[0] = i;
					endP[1] = j;
				}
				
				if(map[i][j] == '*') {
					waterIdx.add(new int[] {i,j});
				}
			}
		}//
		
		int result = bfs(startP[0], startP[1]);
		if(result != -1) System.out.println(result);
		else System.out.println("KAKTUS");
	}
}
