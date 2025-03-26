package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_2583_영역구하기 {
	
	static int[][] field;
	static int M;
	static int N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		field[i][j] = 1;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] points = q.poll();
			int x = points[0];
			int y = points[1];
			
			for(int d = 0; d<4; d++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;
				
				if(0<= nx && nx < M && 0<= ny && ny < N) {
					if(field[nx][ny] == 0) {
						q.offer(new int[] {nx,ny});
						field[nx][ny] = 1;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
		
//		for(int i=0; i<M; i++) {
//			System.out.println(Arrays.toString(field[i]));
//		}
		
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<M; i++) {
			for(int j= 0; j<N; j++) {
				if(field[i][j] ==0) {
					int cnt = bfs(i, j);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		int size = result.size();
		sb.append(size).append("\n");
		for(int n : result) {
			sb.append(n+" ");
		}
		
		System.out.println(sb);
	}
}
