package tip;

import java.util.*;

public class PrimMST {
    static class Node {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    
    // 간선 추가 함수 (양방향 그래프)
    static void addEdge(List<Node>[] graph, int from, int to, int weight) {
        graph[from].add(new Node(to, weight));
        graph[to].add(new Node(from, weight));
    }

    public static void main(String[] args) {
        int V = 5; // 정점 수 (0번부터 4번까지)

        // 인접 리스트 생성
        List<Node>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 (무방향 그래프이므로 양방향 추가)
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 2, 6);
        addEdge(graph, 0, 3, 5);
        addEdge(graph, 1, 3, 15);
        addEdge(graph, 2, 3, 4);
        addEdge(graph, 1, 2, 25);
        addEdge(graph, 3, 4, 2);

        // 프림 알고리즘 수행
        boolean[] visited = new boolean[V];
        
        // Comparator를 이용한 우선순위 큐 (가중치 기준 오름차순)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        int totalCost = 0;
        int count = 0;

        pq.offer(new Node(0, 0)); // 시작 정점

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.vertex]) continue;

            visited[current.vertex] = true;
            totalCost += current.cost;
            count++;

            if (count == V) break;

            for (Node neighbor : graph[current.vertex]) {
                if (!visited[neighbor.vertex]) {
                    pq.offer(neighbor);
                }
            }
        }

        System.out.println("MST 총 가중치: " + totalCost);
    }
}
