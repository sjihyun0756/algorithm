package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1738_골목길 {
	
	static int N;
	static List<Edge> graph;
	static final int INF = Integer.MAX_VALUE;
	
	private static class Edge{
		int from, to, cost;
		public Edge(int from,int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static void bellmanFord(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		
		for(int i=0; i<N+1; i++) {
			for(Edge edge : graph) {
				if(dist[edge.from] != INF && dist[edge.to]>dist[edge.from] + edge.cost ) {
					dist[edge.to] = dist[edge.from] + edge.cost;
				}
			}
			System.out.println(Arrays.toString(dist));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.add(new Edge(from, to, cost));
		}
		bellmanFord(1);
	}
}
