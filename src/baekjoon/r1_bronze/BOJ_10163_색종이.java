package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] area = new int[N+1];
		int[][] field = new int[1001][1001];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int row = r; row<r+w; row++) {
				for(int col = c; col<c+h; col++) {
					field[row][col] = i;
				}
			}
		}
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				area[field[i][j]]++;
			}
		}
		for(int i=1; i<=N; i++) {
			System.out.println(area[i]);
		}
	}

}
