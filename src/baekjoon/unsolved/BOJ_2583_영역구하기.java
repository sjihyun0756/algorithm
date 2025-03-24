package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_2583_영역구하기 {
	
	static int[][] field;
	static int M;
	static int N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int cnt;
	
	private static void dfs(int i, int j) {
		if(field[i][j] == 0) return;
		
		field[i][j] = 0;
		for(int d = 0; d<4; d++) {
			int nx = dx[d] + i;
			int ny = dy[d] + j;
			
			if(0<= nx && nx < M && 0<= ny && ny < N) {
				if(field[nx][ny] != 0) {
					dfs(nx, ny);
					cnt++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		field = new int[M][N];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for(int r = x1; r< x2; r++) {
				for(int c = y1; c< y2; c++) {
					field[r][c] = 1;
				}
			}
		}
		
		
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<M; i++) {
			for(int j= 0; j<N; j++) {
				if(field[i][j] ==1) {
					cnt=0;
					dfs(i, j);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		int size = result.size();
		System.out.println(size);
		for(int n : result) {
			System.out.print(n+" ");
		}
	}
}
