package tip;

import java.util.*;

/*
 * 다익스트라메서드!
 * 1. 우선순위 큐 정의
 * 2. 시작 노드의 cost = 0으로 초기화
 * 3. 큐에 넣기
 * 
 * 4. curr poll
 * 5. continue 조건 : curr.cost > costArr[cost.to]
 * 6. for문 if(costArr[next.to] > costArr[curr.to] + next.cost
 */

public class DijkstraShrotestPath {
    // 정렬 기준 없이 단순한 데이터 클래스
    static class Node {
        int vertex, distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int V = 5; // 정점 수 (0번부터 4번까지)

        // 인접 리스트 그래프
        List<Node>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 추가 (무방향 그래프)
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 2, 6);
        addEdge(graph, 0, 3, 5);
        addEdge(graph, 1, 3, 15);
        addEdge(graph, 2, 3, 4);
        addEdge(graph, 1, 2, 25);
        addEdge(graph, 3, 4, 2);

        int start = 0; // 시작 정점
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // Comparator 사용한 우선순위 큐 (distance 기준)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.vertex;

            // 현재 노드를 통해 갈 수 있는 이웃 탐색
            for (Node neighbor : graph[now]) {
                int next = neighbor.vertex;
                int cost = distance[now] + neighbor.distance;

                if (cost < distance[next]) {
                    distance[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("정점 " + i + ": 도달 불가");
            } else {
                System.out.println("정점 " + i + "까지의 최단 거리: " + distance[i]);
            }
        }
    }

    // 간선 추가 함수 (무방향 그래프)
    static void addEdge(List<Node>[] graph, int from, int to, int weight) {
        graph[from].add(new Node(to, weight));
        graph[to].add(new Node(from, weight)); // 무방향일 경우
    }
}
