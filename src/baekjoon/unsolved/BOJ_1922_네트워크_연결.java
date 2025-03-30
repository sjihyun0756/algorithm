package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1922_네트워크_연결 {
	
	static int[] node;
	static List<Edge> edges;
	
	private static class Edge{
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
	
	private static boolean unionFind(int numA, int numB) {
		int rootA = findNode(numA);
		int rootB = findNode(numB);
		
		if(rootA == rootB) return false;
		if(rootA < rootB) node[rootB] = rootA;
		else node[rootA] = rootB;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		edges = new ArrayList<>();
		node = new int[N+1];
		Arrays.setAll(node, i->i);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to, cost));
		}
		
		edges.sort((e1,e2) -> Integer.compare(e1.cost, e2.cost));
		
		int totalCost = 0;
		int cnt = 0;
		for(Edge e : edges) {
			if(unionFind(e.from, e.to)) {
				cnt++;
				totalCost += e.cost;
				if(cnt == N-1) break;
			}
		}
		System.out.println(totalCost);
	}
}
