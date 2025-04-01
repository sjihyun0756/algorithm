package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_1865_웜홀 {
	
	static int N;
	static List<Edge> graph;
	
	private static class Edge{
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	//가상의 0번노드를 넣어, 전체를 탐색하도록 함
	private static String bellmanFord(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		for(int i=0; i<N; i++) {
			for(Edge edge : graph) {
				if(dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost) {
					dist[edge.to] = dist[edge.from] + edge.cost;
				}
			}
		}
		
		for(Edge edge : graph) {
			if(dist[edge.from]  != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost) {
				return "YES";
			}
		}
		return "NO";
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.add(new Edge(from, to, cost));
				graph.add(new Edge(to, from, cost));
			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.add(new Edge(from, to, -cost));
			}
			
			for (int i = 1; i <= N; i++) {
		        graph.add(new Edge(0, i, 0));
		    }
			
			String result = bellmanFord(0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
