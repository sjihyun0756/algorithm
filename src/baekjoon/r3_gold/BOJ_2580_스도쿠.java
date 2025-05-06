package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_2580_스도쿠 {
	
	static List<int[]> blank;
	static int[][] map;
	static int[] missing;
	
	private static void fillSudoku(int depth) {
		if(depth == blank.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int[] out = blank.get(depth);
		int x = out[0], y=out[1];
		int block = 18 + (x / 3) * 3 + (y / 3);
		int nums =  missing[x] & missing[9 + y] & missing[block];
		
		for(int num=1; num<=9; num++) {
			if ((nums & (1 << num)) != 0) {
				map[x][y] = num;
				
				missing[x] &= ~(1 << num);
	        	missing[9 + y] &= ~(1 << num);
	        	missing[block] &= ~(1 << num);
	        	
	        	fillSudoku(depth+1);
	        	
	        	missing[x] |= (1 << num);
	        	missing[9 + y] |= (1 << num);
	        	missing[block] |= (1 << num);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[9][9];
		missing = new int[27];
		Arrays.fill(missing, (1<<10)-1);
		
		blank = new ArrayList<>();
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				int block = 18 + (i / 3) * 3 + (j / 3);
				missing[i] &= ~(1 << num);
	        	missing[9 +j] &= ~(1 << num);
	        	missing[block] &= ~(1 << num);
				if(num==0) blank.add(new int[] {i,j});
			}
		}
		fillSudoku(0);
	}
}
