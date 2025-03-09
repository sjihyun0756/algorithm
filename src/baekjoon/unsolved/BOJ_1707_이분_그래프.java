package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1707_이분_그래프 {
	
	static List<Integer>[] graph;
	static List<Integer> group1;
	static List<Integer> group2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				graph[u].add(v);
				graph[v].add(u);
				
				
			}
			
			
			
			
		}
		
		
	}

}
