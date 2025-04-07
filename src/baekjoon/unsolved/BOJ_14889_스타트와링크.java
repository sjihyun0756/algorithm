package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_14889_스타트와링크 {
	static int N, minSynergy;
	static int[][] map;
	static int[] result;
	
	private static void findSet(int depth, int last) {
		if(depth == N/2) {
			calculate();
			return;
		}
		
		for(int i=last+1; i<N; i++) {
			result[depth] = i;
			findSet(depth+1, i);
		}
	}
	
	private static void calculate() {
		boolean[] isSelected = new boolean[N];
		for(int n : result) {
			isSelected[n] = true;
		}
		
		int synergy1 = 0, synergy2 = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (isSelected[i] && isSelected[j]) {
					synergy1 += map[i][j] + map[j][i]; 
				} else if (!isSelected[i] && !isSelected[j]) {
					synergy2 += map[i][j] + map[j][i];
				}
			}
		}
		minSynergy = Math.min(Math.abs(synergy1 - synergy2), minSynergy);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		result = new int[N/2];
		minSynergy = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findSet(0, -1);
		System.out.println(minSynergy);
	}
}
