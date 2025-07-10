package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_11505_구간_곱_구하기 {
	private static int leafStart;
	private static int[] tree;
	private static StringBuilder sb = new StringBuilder();
	
	private static void setTree() {
		for(int i=leafStart-1; i>0; i--) {
			tree[i] = tree[i*2] * tree[i*2 + 1];
		}
	}
	
	private static void changeNum(int from, int to) {
		int idx = from + leafStart;
		
		tree[idx] = to;
		while((idx/=2) != 0) {
			tree[idx] = tree[idx*2] * tree[idx*2 +1]; 
		}
	}
	
	private static void calMultiply(int from, int to) {
		int result = 1;
		int startIdx = from + leafStart;
		int endIdx = to + leafStart;
		
		while(startIdx <= endIdx) {
			if(startIdx %2 ==1) result *= tree[startIdx++] % 1000000007;
			else if(endIdx %2 ==0) result *= tree[endIdx--] % 1000000007;
			
			startIdx /= 2;
			endIdx /= 2;
		}
		sb.append(result).append("\n");
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int idx = N, treeHeight = 1;
		while((idx/=2) != 0) {
			treeHeight++;
		}		
		
		int treeSize =  1 << (treeHeight + 1);
		leafStart = 1 << treeHeight - 1;
		
		tree = new int[treeSize];
		Arrays.fill(tree, 1);
		for(int i=0; i<N; i++) {
			tree[i + leafStart] = Integer.parseInt(br.readLine());
		}
		
		setTree();
		for(int i=0; i<M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(oper==1) changeNum(from, to);
			else if(oper ==2) calMultiply(from, to);
		}
		System.out.println(sb);
	}
}
