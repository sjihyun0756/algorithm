package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_1647_도시_분할_계획 {

	static int[] node;

	static class Edge {
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static int findNode(int num) {
		if(node[num] == num) return num;
		return node[num] = findNode(node[num]);
	}
	
	private static boolean unionFind(int from, int to) {
		int rootFrom = findNode(from);
		int rootTo = findNode(to);
		
		if(rootFrom == rootTo) return false;
		if(rootFrom < rootTo) node[rootTo] = rootFrom;
		else node[rootFrom] = rootTo;
		return true; //사이클이 아님. 연결 가능
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		node = new int[N + 1];
		Arrays.setAll(node, i -> i);

		List<Edge> edges = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(from, to, cost));
		}
		
		edges.sort((e1,e2) -> e1.cost-e2.cost);
		int cnt = 0;
		int maxCostEdge = 0;
		int totalMinCost = 0;
		for(Edge e : edges) {
			if(unionFind(e.from, e.to)) {
				maxCostEdge = Math.max(maxCostEdge, e.cost);
				totalMinCost += e.cost;
				cnt++;
				if(cnt == N-1) break;
			}
		}
		System.out.println(totalMinCost-maxCostEdge);
	}
}
