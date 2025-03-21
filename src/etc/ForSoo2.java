package etc;

import java.util.Scanner;

public class ForSoo2 {
    
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static int cntASC = 0;
    static int cntDESC = 0;

    private static void permutation(int depth, boolean[] visited) {
        
        if (depth == M) {
            // 오름차순 체크 
            boolean checkASC = true;
            for (int i = 0; i < M - 1; i++) {
                if (result[i] > result[i + 1]) { // 오름차순이 아니면 false
                    checkASC = false;
                    break;
                }
            }
            if (checkASC) cntASC++;

            // 내림차순 체크 
            boolean checkDESC = true;
            for (int i = 0; i < M - 1; i++) {
                if (result[i] < result[i + 1]) { // 내림차순이 아니면 false
                    checkDESC = false;
                    break;
                }
            }
            if (checkDESC) cntDESC++;

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문 체크
                visited[i] = true;
                result[depth] = arr[i];
                permutation(depth + 1, visited);
                visited[i] = false; 
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 배열 크기
        M = sc.nextInt(); // 뽑을 개수
        arr = new int[N];
        result = new int[M];
        boolean[] visited = new boolean[N]; // 방문 배열 추가

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        permutation(0, visited);
        
        System.out.println("오름차순 순열 : " + cntASC + "개");
        System.out.println("내림차순 순열 : " + cntDESC + "개");
    }
}
