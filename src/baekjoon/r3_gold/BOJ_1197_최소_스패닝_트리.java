package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_1197_최소_스패닝_트리 {

	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<List<Edge>> edges = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.get(from).add(new Edge(to, cost));
			edges.get(to).add(new Edge(from, cost));
		}

		boolean[] node = new boolean[V + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));

		int totalCost = 0, cnt = 0;
		node[1] = true;
		pq.addAll(edges.get(1));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (node[edge.to]) continue;
			
			node[edge.to] = true;
			totalCost += edge.cost;
			cnt++;

			if (cnt == V - 1) break;
			
			for(Edge next : edges.get(edge.to)) {
				if(!node[next.to]) pq.offer(next);
			}

		}
		System.out.println(totalCost);
	}
}
/*
 * package baekjoon.r3_gold;
 * 
 * import java.io.*; import java.util.*;
 * 
 * public class BOJ_1197_최소_스패닝_트리 {
 * 
 * static int[] node;
 * 
 * static class Edge{ int from, to, cost; public Edge(int from, int to, int
 * cost){ this.from = from; this.to = to; this.cost = cost; } }
 * 
 * private static int findNode(int num) { if(node[num] == num) return num;
 * return node[num] = findNode(node[num]); }
 * 
 * private static boolean unionFind(int numA, int numB) { int rootA =
 * findNode(numA); int rootB = findNode(numB);
 * 
 * if(rootA == rootB) return false; if(rootA < rootB) node[rootB] = rootA; else
 * node[rootA] = rootB; return true; }
 * 
 * public static void main(String[] args) throws IOException { BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in)); StringTokenizer st=
 * new StringTokenizer(br.readLine()); int V = Integer.parseInt(st.nextToken());
 * int E = Integer.parseInt(st.nextToken());
 * 
 * node = new int[V+1]; Arrays.setAll(node, i->i);
 * 
 * List<Edge> edges = new ArrayList<>(); for(int i=0; i<E; i++) { st= new
 * StringTokenizer(br.readLine()); int from = Integer.parseInt(st.nextToken());
 * int to = Integer.parseInt(st.nextToken()); int cost =
 * Integer.parseInt(st.nextToken()); edges.add(new Edge(from, to, cost)); }
 * 
 * edges.sort((e1,e2) -> e1.cost-e2.cost); int cnt = 0; int totalCost = 0;
 * 
 * for(Edge e : edges) { if(!unionFind(e.from, e.to)) { cnt++; totalCost +=
 * e.cost; if(cnt == V-1) break; } } System.out.println(totalCost); } }
 */