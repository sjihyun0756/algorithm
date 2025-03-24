package baekjoon.r2_silver;

import java.util.*;
import java.io.*;

public class BOJ_1389_케빈_베이컨의_6단계_법칙 {
	
	static List<Integer>[] graph;
	static boolean[] visit;
	static int[] friend;
	
	private static int bfs(int startNode) {
		Queue<Integer> q = new ArrayDeque<>();
		int level = 0;
		q.offer(startNode);
		visit[startNode] = true;
		friend[startNode] = level;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int node = q.poll();
				cnt+=level;
				for(int n : graph[node]) {
					if(!visit[n]) {
						q.offer(n);
						visit[n] = true;
					}
				}
			}
			level++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		friend = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int minCnt = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			friend[i] = bfs(i);
			if(friend[i]<minCnt) {
				minCnt = friend[i];
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}
}
