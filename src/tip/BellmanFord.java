package tip;

/*
특징	                벨만포드	                        플로이드-워셜 (Floyd-Warshall)
적용 범위	        단일 출발지 최단 경로	                     모든 쌍의 최단 경로
시간 복잡도	           O(V * E)	                            O(V^3)
음의 가중치	    음의 가중치를 허용, 음의 사이클 탐지 가능	     음의 가중치를 허용, 음의 사이클 탐지 가능
작동 방식	  간선 갱신 방식, V-1번 반복 후 음의 사이클 체크	    동적 계획법, 3중 반복문을 사용
사용되는 상황	단일 출발지에서 음의 가중치가 있을 때	         모든 노드 쌍에 대해 최단 경로가 필요할 때
 */

import java.util.Arrays;

public class BellmanFord {
    // 간선 클래스 정의
    static class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // 벨만포드 알고리즘
    public static void bellmanFord(Edge[] edges, int V, int start) {
        // 최단 거리 배열 (시작 노드에서 각 노드까지의 거리)
        int[] dist = new int[V];
        
        // 시작 노드까지의 거리는 0, 나머지 노드는 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // V-1번 반복 (V는 노드의 개수)
        for (int i = 1; i < V; i++) {
            // 각 간선에 대해 최단 거리 갱신
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.v]> dist[edge.u] + edge.weight) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }

        // 음의 사이클 탐지 (V번째 반복에서 갱신되는 간선이 있다면 음의 사이클이 존재)
        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                System.out.println("그래프에 음의 사이클이 존재합니다.");
                return;
            }
        }

        // 최단 거리 출력
        System.out.println("최단 거리: ");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("노드 " + i + "까지의 경로는 존재하지 않습니다.");
            } else {
                System.out.println("노드 " + i + "까지의 최단 거리: " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        // 그래프의 노드 개수 (예: 5개 노드)
        int V = 5;
        
        // 간선 배열 생성 (u, v, weight)
        // 예시: (0, 1, -1), (0, 2, 4), (1, 2, 3), (1, 3, 2), (1, 4, 2), (3, 2, 5), (3, 1, 1), (4, 3, -3)
        Edge[] edges = {
            new Edge(0, 1, -1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 3),
            new Edge(1, 3, 2),
            new Edge(1, 4, 2),
            new Edge(3, 2, 5),
            new Edge(3, 1, 1),
            new Edge(4, 3, -3)
        };

        // 시작 노드 (예: 0번 노드)
        int start = 0;

        // 벨만포드 알고리즘 실행
        bellmanFord(edges, V, start);
    }
}
