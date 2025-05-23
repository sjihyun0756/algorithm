package baekjoon.r3_gold;

import java.io.*;

public class BOJ_10026_적록색약 {
	
	private static char[][] map;
	
	private static void RGBlind() {
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		RGBlind();
	}
}
