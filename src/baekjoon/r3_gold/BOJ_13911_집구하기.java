package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_13911_집구하기 {

    private static class Edge {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static int V, foodLimit, coffeeLimit;
    private static List<Edge>[] graph;
    private static boolean[] isFood, isCoffee, banned;
    private static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        isFood = new boolean[V + 1];
        isCoffee = new boolean[V + 1];
        banned = new boolean[V + 1];

        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        foodLimit = Integer.parseInt(st.nextToken());
        if (F > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < F; i++) {
                int n = Integer.parseInt(st.nextToken());
                isFood[n] = true;
                banned[n] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        coffeeLimit = Integer.parseInt(st.nextToken());
        if (C > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < C; i++) {
                int n = Integer.parseInt(st.nextToken());
                isCoffee[n] = true;
                banned[n] = true;
            }
        }
    }

    private static void solution() {
        long[] distFood = dijkstraMultiSource(isFood, foodLimit);
        long[] distCoffee = dijkstraMultiSource(isCoffee, coffeeLimit);

        long result = INF;
        for (int v = 1; v <= V; v++) {
            if (banned[v]) continue;
            long df = distFood[v];
            long ds = distCoffee[v];
            if (df <= foodLimit && ds <= coffeeLimit) {
                long sum = df + ds;
                if (sum < result) result = sum;
            }
        }
        System.out.println(result == INF ? -1 : result);
    }

    private static long[] dijkstraMultiSource(boolean[] starts, int limit) {
        long[] dist = new long[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        for (int i = 1; i <= V; i++) {
            if (starts[i]) {
                dist[i] = 0L;
                pq.offer(new long[]{i, 0L});
            }
        }

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];
            if (d != dist[u]) continue;
            if (d > limit) continue;
            for (Edge e : graph[u]) {
                long nd = d + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{e.to, nd});
                }
            }
        }
        return dist;
    }
}
