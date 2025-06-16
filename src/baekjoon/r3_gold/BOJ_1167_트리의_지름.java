package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_1167_트리의_지름 {
    private static class Node {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    static void dfs(int now, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = now;
        }

        for (Node next : graph[now]) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                dfs(next.to, dist + next.cost);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                graph[u].add(new Node(v, cost));
            }
        }

        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[V + 1];
        visited[farthestNode] = true;
        maxDist = 0;
        dfs(farthestNode, 0);
        System.out.println(maxDist);
    }
}