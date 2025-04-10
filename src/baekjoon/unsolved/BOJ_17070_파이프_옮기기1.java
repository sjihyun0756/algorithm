package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프_옮기기1 {
	
	private static int bfs() {
		
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] field = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken()) == 0;
			}
		}
		
		
	}

}
