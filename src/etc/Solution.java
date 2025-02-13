 

import java.io.*;
import java.util.*;

/*
6 5
1 2
1 3
2 4
2 5
3 6

 */

public class Solution {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 노드 개수(n), 간선 개수(m) 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 방문 배열 및 그래프 초기화
        visited = new boolean[n + 1];  // 노드 번호가 1부터 시작하므로 n+1 크기 할당
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 각 노드의 리스트 초기화
        }

        // 2. 간선 정보 입력 받기 (m개의 줄)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
        }

        // 3. DFS 실행
        System.out.println("DFS 탐색 결과:");
        dfs(1); // 1번 노드부터 시작 (문제에 따라 시작점이 다를 수도 있음)
    }

    static void dfs(int node) {
        visited[node] = true; // 방문 체크
        System.out.print(node + " "); // 현재 노드 출력

        for (int next : graph.get(node)) { // 연결된 노드 순회
            if (!visited[next]) { // 방문하지 않은 노드만 탐색
                dfs(next); // 재귀 호출
            }
        }
    }

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u); // 무방향 그래프 (방향 그래프라면 이 줄 삭제)
    }
}