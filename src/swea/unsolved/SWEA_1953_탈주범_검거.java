package swea.unsolved;

import java.io.*;
import java.util.*;

public class SWEA_1953_탈주범_검거 {
	
	static int[][] map;
	static int L;
	
	private static int bfs(int R, int C, int caseNum) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {R,C, caseNum});
		map[R][C] = 0;
		
		int level = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] points = q.poll();
			int x = points[0], y = points[1], cNum = points[2];
			
			switch(cNum) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}
			
			
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //세로 
			int M = Integer.parseInt(st.nextToken()); //가로 
			int R = Integer.parseInt(st.nextToken()); //세로 위치
			int C = Integer.parseInt(st.nextToken()); //가로 위치
			int L = Integer.parseInt(st.nextToken()); //시간 
			
			
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int caseNum = map[R][C];
			int result = bfs(R, C, caseNum);
			
			
			

		}
		System.out.println(sb);
	}
}
