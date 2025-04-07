package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_14889_스타트와링크 {
	static int N;
	static int[][] map;
	static int[] result;
	
	private static void findSet(int depth, int last) {
		if(depth == N/2 && result[0] == 1) {
			int cal1 = 0, cal2 = 0;
			
			
			return;
		}
		
		for(int i=last+1; i<N; i++) {
			result[depth] = i+1;
			findSet(depth+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		result = new int[N/2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findSet(0, -1);
	}
}
