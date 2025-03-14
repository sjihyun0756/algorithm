package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10451_순열_사이클 {
	
	static List<Integer>[] graph;
	static boolean[] visit;
	
	
	private static void dfs(int node) {
		if(visit[node]) return;
		visit[node] = true;
		for(int n : graph[node]) {
			if(!visit[n]) {
				dfs(n);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			graph = new ArrayList[N+1];
			visit = new boolean[N+1];
			
			for(int i=0; i<N+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int u=1; u<=N; u++) {
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}//그래프 만듦
			
			//System.out.println(Arrays.toString(graph));
			
			int cnt =0;
			for(int i=1; i<N+1; i++) {
				if(!visit[i]) {
					dfs(i);
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}// tc
		System.out.println(sb);
	}
}
