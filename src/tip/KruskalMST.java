package tip;

import java.util.*;

public class KruskalMST {
	static int[] node;

	static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	// Find 연산 (경로 압축)
	static int findNode(int num) {
		if (node[num] == num)
			return num;
		return node[num] = findNode(node[num]);
	}

	// Union 연산 (사이클 방지)
	static boolean unionFind(int a, int b) {
		int rootA = findNode(a);
		int rootB = findNode(b);
		if (rootA == rootB)
			return false;

		if (rootA < rootB)
			node[rootB] = rootA;
		return true;
	}

	public static void main(String[] args) {
		int V = 5; // 정점 개수
		int E = 7; // 간선 개수

		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 10));
		edges.add(new Edge(0, 2, 6));
		edges.add(new Edge(0, 3, 5));
		edges.add(new Edge(1, 3, 15));
		edges.add(new Edge(2, 3, 4));
		edges.add(new Edge(1, 2, 25));
		edges.add(new Edge(3, 4, 2));

		edges.sort(Comparator.comparingInt(e -> e.cost));

		// Union-Find 초기화
		node = new int[V + 1];
		Arrays.setAll(node, i -> i);

		int totalCost = 0;
		int cnt = 0;

		// MST 만들기
		for (Edge edge : edges) {
			if (unionFind(edge.from, edge.to)) {
				totalCost += edge.cost;
				cnt++;
				if (cnt == V - 1)
					break;
			}
		}

		System.out.println("MST 총 가중치: " + totalCost);
	}
}
