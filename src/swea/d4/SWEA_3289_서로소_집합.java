package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_3289_서로소_집합 {
	static int[] node;
	
	private static int findNode(int num) {
		if(node[num] == num) return num;
		return node[num] = findNode(node[num]);
	}
	
	private static void union(int num1,int num2) {
		int root1 = findNode(num1);
		int root2 = findNode(num2);
		
		if(root1 < root2) node[root2]  = root1;
		else node[root1]  = root2;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			node = new int[N+1];
			Arrays.setAll(node, i->i);
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int checkCase = Integer.parseInt(st.nextToken());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				
				if(checkCase==0) {
					union(num1, num2);
				}else { //집합 확
					if(findNode(num1) == findNode(num2)) {
						sb.append("1");
					}else sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
