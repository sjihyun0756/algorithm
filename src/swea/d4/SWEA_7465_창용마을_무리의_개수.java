package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_7465_창용마을_무리의_개수 {
	static int[] node;
	
	private static int findNode(int num) {
		if(node[num]==num) return num;
		return node[num]=findNode(node[num]);
	}
	
	private static void unionFind(int numA, int numB) {
		int rootA = findNode(numA);
		int rootB = findNode(numB);
		
		if(rootA<rootB) node[rootB] = rootA;
		else node[rootA] = rootB;
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
				int numA = Integer.parseInt(st.nextToken());
				int numB = Integer.parseInt(st.nextToken());
				unionFind(numA,numB);
			}
			
			boolean[] result = new boolean[N+1];
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
			    int root = findNode(i);
			    result[root] = true; 
			}

			for (int i = 1; i <= N; i++) {
			    if (result[i]) cnt++;
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
