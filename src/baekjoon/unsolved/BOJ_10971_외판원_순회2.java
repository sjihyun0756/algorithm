package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10971_외판원_순회2 {
	
	static List<Integer>[] graph;
	static int[][] priceMap;
	static boolean[] visit;
	
	private static void dfs(int n) {
		
		if(visit[n]) return;
		visit[n] = true;
		
		for(int node : graph[n]) {
			if(!visit[n]) {
				dfs(node);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		priceMap = new int[N+1][N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			int idx = 1;
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int price = Integer.parseInt(st.nextToken());
				if(price!=0) {
					graph[i].add(idx++);
				}else idx++;
				priceMap[i][j] = price;
			}
		}
		System.out.println(Arrays.toString(graph));
		System.out.println(Arrays.deepToString(priceMap));
		
		for(int i=1; i<=N; i++) {
			if(!visit[i]) dfs(i);
		}
	}

}
