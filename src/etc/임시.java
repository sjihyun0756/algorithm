package etc;

import java.io.*;
import java.util.*;

public class 임시 {
	static int[] dayPick;
	static int[] day = {1,1,1,2,2,2,3,3,3}; 
	static int result;
	static int[][] field;
	static boolean[] visit;

	private static void findSet(int depth) {
		if(depth == 9) {
			int cal = 0;
			for(int i = 0; i < 9; i++) {
				int d = dayPick[i]; 
				cal += field[d - 1][i]; 
			}
			result = Math.max(result, cal);
			return;
		}

		for(int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dayPick[depth] = day[i]; 
				findSet(depth + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			field = new int[3][9]; 
			for(int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dayPick = new int[9]; 
			visit = new boolean[9];
			result = Integer.MIN_VALUE;

			findSet(0); 
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
