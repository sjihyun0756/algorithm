package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_1738_골목길 {

    static int N;
    static List<Edge> graph;
    static final int INF = Integer.MAX_VALUE;

    private static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static void bellmanFord(int start) {
        StringBuilder sb = new StringBuilder();
        int[] dist = new int[N + 1];
        int[] prev = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        // 벨만포드 N-1회 수행
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : graph) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    prev[edge.to] = edge.from;
                }
            }
        }

        // 사이클 여부 + 도착점까지 도달 가능한지 확인
        boolean[] cycleNode = new boolean[N + 1];
        for (Edge edge : graph) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                cycleNode[edge.to] = true;
            }
        }

        // cycleNode 중에서 도착점까지 도달 가능한 노드가 있는지 BFS 탐색 
        // -> 양의 사이클을 지나서 도착점(N)에 도달하는 경우 -> -1 출력 
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (cycleNode[i]) {
                q.add(i);
                visited[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == N) {
                System.out.println("-1");
                return;
            }
            for (Edge edge : graph) {
                if (edge.from == curr && !visited[edge.to]) {
                    visited[edge.to] = true;
                    q.add(edge.to);
                }
            }
        }

        // 경로 없을 경우
        if (dist[N] == INF) {
            System.out.println("-1");
            return;
        }

        // 경로 추적
        List<Integer> path = new ArrayList<>();
        int curr = N;
        while (curr != -1) {
            path.add(curr);
            curr = prev[curr];
        }
        Collections.reverse(path);
        for (int n : path) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge(from, to, -cost)); // 최대 경로 → 음수로 바꿔서 최소 거리로 계산
        }

        bellmanFord(1);
    }
}
