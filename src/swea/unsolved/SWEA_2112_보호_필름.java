package swea.unsolved;

import java.io.*;
import java.util.*;

public class SWEA_2112_보호_필름 {

	static int W, D, K, minCnt = 0;
	static boolean[][] field;
	static int[] selectRow;
	static int[] selectTF;
	static boolean findAns;

	private static boolean isTestPassed() {
		for (int j = 0; j < W; j++) {
			boolean pass = false;
			for (int i = 0; i <= D - K; i++) {
				boolean same = true;
				for (int k = 1; k < K; k++) {
					if (field[i + k][j] != field[i][j]) {
						same = false;
						break;
					}
				}
				if (same) {
					pass = true;
					break;
				}
			}
			if (!pass) return false;
		}
		return true;
	}

//	private static boolean caseSet(int[] selectRow, boolean tf) {
//	    boolean[][] copy = new boolean[D][W];
//	    for (int i = 0; i < D; i++) copy[i] = field[i].clone();
//
//	    for (int i : selectRow) {
//	        for (int j = 0; j < W; j++) {
//	            field[i][j] = tf;
//	        }
//	    }
//
//	    boolean resultPass = isTestPassed();
//
//	    for (int i = 0; i < D; i++) field[i] = copy[i];
//	    return resultPass;
//	}
//	
	
	private static void caseSet(int depth, int[] rows, boolean[] tf) {
		if (depth == rows.length) {
			boolean[][] copy = new boolean[D][W];
			for (int i = 0; i < D; i++) copy[i] = field[i].clone();

			for (int i = 0; i < rows.length; i++) {
				int row = rows[i];
				boolean type = tf[i];
				for (int j = 0; j < W; j++) {
					field[row][j] = type;
				}
			}

			if (isTestPassed()) {
				minCnt = rows.length;
				findAns = true;
			}

			for (int i = 0; i < D; i++) field[i] = copy[i];
			return;
		}

		tf[depth] = false;
		caseSet(depth + 1, rows, tf);
		if (findAns) return;

		tf[depth] = true;
		caseSet(depth + 1, rows, tf);
	}


	private static void findSet(int depth, int last, int len) {
		if (depth == len) {
			caseSet(0, selectRow, new boolean[len]);
			return;
		}

		if (findAns) return;

		for (int i = last + 1; i < D; i++) {
			selectRow[depth] = i;
			findSet(depth + 1, i, len);
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			field = new boolean[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					field[i][j] = Integer.parseInt(st.nextToken()) == 0;
				}
			}

			if (isTestPassed() || K == 1) {
				sb.append("0\n");
				continue;
			}

			findAns = false;
			for (int i = 1; i <= K; i++) {
				selectRow = new int[i];
				findSet(0, -1, i);
				if (findAns) break;
			}
			
			sb.append(minCnt).append("\n");
		}
		System.out.println(sb);
	}
}
