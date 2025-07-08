package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_2042_구간_합_구하기 {

	private static int[] tree;
	private static int treeHeight, treeSize;
	private static StringBuilder sb = new StringBuilder();

	private static void setTree() {
		int cnt = (treeSize + 1 ) /2;
		
		

	}
	
	private static void calSum(int from, int to) {
		int sum = 0;
		
		
		
		
		sb.append(sum).append("\n");
	}

	private static void changeNum(int from, int to) {

		int idx = from + (int) Math.pow(2, treeHeight) - 1;
		tree[idx] = to;

		setTree();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// k를 구하는 로직
		treeHeight = 1;
		int length = N;
		while ((length /= 2) != 0) {
			treeHeight++;
		}

		treeSize = (int) Math.pow(2, treeHeight) - 1;
		tree = new int[treeSize];
		int startIdx = (int) Math.pow(2, treeHeight);
		for (int i = startIdx; i < startIdx + N; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int caseNum = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			if (caseNum == 1)
				changeNum(from, to);
			else if (caseNum == 2)
				calSum(from, to);
		}
		System.out.println(sb);
	}
}
