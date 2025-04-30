package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_6118_숨바꼭질 {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visit;
	static int[] distArr;
	
	private static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visit[start] = true;
		
		int distance = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int node = q.poll();
				distArr[node] = distance;
				for(int n : graph[node]) {
					if(!visit[n]) {
						q.offer(n);
						visit[n] = true;
					}
				}
			}
			distance++;
		}
		return distance-1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		distArr = new int[N+1]; 
		int maxDistance = bfs(1);
		
		int minNode = Integer.MAX_VALUE;
		int minCnt = 0;
		for(int i=1; i<N+1; i++) {
			if(distArr[i] == maxDistance) {
				minNode = Math.min(minNode, i);
				minCnt++;
			}
			
		}
		System.out.print(minNode + " " + maxDistance + " " + minCnt);
	}
}
