package tip;

import java.util.*;

public class 위상정렬_모든경우 {
    static int N, M;
    static List<Integer>[] graph;
    static int[] inDegree;
    static boolean[] visited;
    static List<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        visited = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[A].add(B);
            inDegree[B]++;
        }

        allTopologicalSort();

        sc.close();
    }

    private static void allTopologicalSort() {
        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0 && !visited[i]) {
                // 선택
                for (int node : graph[i])
                    inDegree[node]--;

                result.add(i);
                visited[i] = true;
                allTopologicalSort();

                // 백트래킹
                visited[i] = false;
                result.remove(result.size() - 1);
                for (int node : graph[i])
                    inDegree[node]++;

                flag = true;
            }
        }

        // 종료 조건 (모든 노드를 사용한 경우 결과 출력)
        if (!flag && result.size() == N) {
            for (int n : result)
                System.out.print(n + " ");
            System.out.println();
        }
    }
}

/*입력:
3 2
1 3
2 3

출력:
1 2 3 
2 1 3
*/
