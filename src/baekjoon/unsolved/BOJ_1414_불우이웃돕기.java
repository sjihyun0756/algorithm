package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1414_불우이웃돕기 {
	
	private static class Edge{
		int to, cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.cost,e2.cost));
		List<Edge>[] graph  = new ArrayList[N+1];
		boolean[] visit  = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int totalLen = 0;
		for(int i=1; i<=N; i++){
			String input = br.readLine();
			for(int j=1; j<=N; j++) {
				char alphabet = input.charAt(j-1);
				int len = alphabet <= 'Z' ? alphabet - 38 : alphabet - 'a'+ 1;
				graph[i].add(new Edge(j, len));
				totalLen += len;
				if(i==1) pq.add(new Edge())
			}
		}
		
		visit[1] = true;
	}
}
