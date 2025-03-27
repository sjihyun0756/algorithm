package tip;

import java.util.*;

public class PrimMST {
	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		int V = 5; // 정점 개수
		int E = 7; // 간선 개수

		List<List<Edge>> edges = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			edges.add(new ArrayList<>());
		}

		edges.get(0).add(new Edge(1, 10));
		edges.get(1).add(new Edge(0, 10));
		edges.get(0).add(new Edge(2, 6));
		edges.get(2).add(new Edge(0, 6));
		edges.get(0).add(new Edge(3, 5));
		edges.get(3).add(new Edge(0, 5));
		edges.get(1).add(new Edge(3, 15));
		edges.get(3).add(new Edge(1, 15));
		edges.get(2).add(new Edge(3, 4));
		edges.get(3).add(new Edge(2, 4));
		edges.get(1).add(new Edge(2, 25));
		edges.get(2).add(new Edge(1, 25));
		edges.get(3).add(new Edge(4, 2));
		edges.get(4).add(new Edge(3, 2));

		boolean[] node = new boolean[V + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.cost, e2.cost));

		// 시작점: 0번 노드
		node[0] = true;
		pq.addAll(edges.get(0));

		int totalCost = 0;
		int cnt = 0;

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (node[edge.to]) continue;

			node[edge.to] = true;
			totalCost += edge.cost;
			cnt++;

			if (cnt == V - 1) break;

			for (Edge next : edges.get(edge.to)) {
				if (!node[next.to]) pq.add(next);
			}
		}

		System.out.println("MST 총 가중치: " + totalCost);
	}
}