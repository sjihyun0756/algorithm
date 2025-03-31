package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_11725_트리의_부모_찾기 {
	
	static List<Integer>[] graph;
	static boolean[] visit;
	static int[] parentNode;
	
	private static void bfs(int num) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(num);
		visit[num]=true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int n : graph[node]) {
				if(!visit[n]) {
					parentNode[n] = node;
					q.offer(n);
					visit[n] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		parentNode = new int[N+1];
		visit = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		bfs(1);
		for(int i=2; i<=N; i++) {
			sb.append(parentNode[i]).append("\n");
		}
		System.out.println(sb);
	}
}
