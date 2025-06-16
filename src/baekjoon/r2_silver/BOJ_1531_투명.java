package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_1531_투명 {
	
	private static int[][] board;
	
	private static void coverImage(int x1, int y1, int x2, int y2) {
		for(int x = x1;  x<=x2; x++) {
			for(int y=y1; y<=y2; y++) {
				board[x][y]++;
			}
		}
	}
	
	private static int cntImage(int M) {
		int cnt = 0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(board[i][j] > M) cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[101][101];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			coverImage(x1,y1,x2,y2);
		}
		System.out.println(cntImage(M));
	}
}
