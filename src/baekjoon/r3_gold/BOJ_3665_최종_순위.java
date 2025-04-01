package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_3665_최종_순위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            List<Integer>[] graph = new ArrayList[N + 1];
            int[] inDegree = new int[N + 1];
            int[] rank = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    graph[rank[i]].add(rank[j]);
                    inDegree[rank[j]]++;
                }
            }

            int M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a].contains(b)) {
                    graph[a].remove(Integer.valueOf(b));
                    inDegree[b]--;
                    graph[b].add(a);
                    inDegree[a]++;
                } else {
                    graph[b].remove(Integer.valueOf(a));
                    inDegree[a]--;
                    graph[a].add(b);
                    inDegree[b]++;
                }
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) q.offer(i);
            }

            StringBuilder result = new StringBuilder();
            boolean uncertain = false;
            int cnt = 0;

            while (!q.isEmpty()) {
                if (q.size() > 1) {
                    uncertain = true;
                    break;
                }

                int node = q.poll();
                result.append(node).append(" ");
                cnt++;

                for (int next : graph[node]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) q.offer(next);
                }
            }

            if (uncertain) sb.append("?").append("\n");
            else if (cnt == N) sb.append(result).append("\n");
            else sb.append("IMPOSSIBLE").append("\n");
        }

        System.out.print(sb);
    }
}