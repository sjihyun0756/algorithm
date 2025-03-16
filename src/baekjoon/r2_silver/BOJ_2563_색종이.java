package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] field = new boolean[101][101];
		int area =0;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int col = c; col<c+10; col++) {
				for(int row = r; row<r+10; row++) {
					field[col][row] = true;
				}
			}
		}
		
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(field[i][j]) area++;
			}
		}
		System.out.println(area);
	}

}
