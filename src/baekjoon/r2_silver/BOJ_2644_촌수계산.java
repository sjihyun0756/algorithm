package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_2644_촌수계산 {
	
	static List<Integer>[] graph;
	static boolean[] visit;
	static int result =0;
	static int target;
	static boolean findTarget = false;
	
	private static void dfs(int n, int depth) {
		
		if(visit[n]) return;
		
		visit[n] = true;
		for(int node : graph[n]) {
			if(findTarget) break;
			
			if(!visit[node]) {
				if(node==target) {
					result = depth+1;
					findTarget = true;
				}else dfs(node, depth+1);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		dfs(start, 0);
		
		if(!findTarget) System.out.println(-1);
		else System.out.println(result);
	}
}
