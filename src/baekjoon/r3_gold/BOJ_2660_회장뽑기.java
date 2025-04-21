package baekjoon.r3_gold;

import java.util.*;
import java.io.*;

public class BOJ_2660_회장뽑기 {
	
	static List<Integer>[] graph;
	static int[] cntDepth;
	static boolean[] visit;
	
	private static void bfs(int node) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(node);
		visit[node] = true;
		
		int depth = 0;
		int maxCnt = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				
				int out = q.poll();
				maxCnt = Math.max(depth, maxCnt);
				for(int n : graph[out]) {
					if(!visit[n]) {
						visit[n]= true;
						q.offer(n);
					}
				}
			}
			depth++;
		}
		cntDepth[node] = maxCnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		cntDepth = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		while(true) {
			st= new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(u==-1 && v==-1) break;
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			bfs(i);
		}
		
		int minResult = Integer.MAX_VALUE;
		for(int i=1; i<N+1; i++) {
			minResult = Math.min(cntDepth[i], minResult);
		}
		
		List<Integer> resultList = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
			if(cntDepth[i] == minResult) {
				resultList.add(i);
			}
		}
		Collections.sort(resultList);
		
		System.out.println(minResult +" " + resultList.size());
		for(int n : resultList) {
			System.out.print(n+" ");
		}
	}
}
