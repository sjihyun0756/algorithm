package etc;

import java.io.*;
import java.util.*;

public class 다시풀기용 {
	
	static int[] node;
	private static int findNode(int num) {
		if(node[num] == num) return num;
		return node[num] = findNode(node[num]);
	}
	
	private static void unionFind(int num1, int num2) {
		int root1 = findNode(num1);
		int root2 = findNode(num2);
		
		if(root1 < root2) node[root2] = root1;
		else node[root1] = root2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		node = new int[N+1];
		Arrays.setAll(node, i->i);

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int caseNum = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if(caseNum==0) unionFind(num1, num2);
			else sb.append(findNode(num1) == findNode(num2) ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}
}
