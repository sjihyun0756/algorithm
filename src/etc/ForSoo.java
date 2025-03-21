package etc;

import java.util.Scanner;

public class ForSoo {
    static int maxSum = Integer.MIN_VALUE;
    static int N, M;
    static int[] rowSums;
    static int[] comb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력받기 (N x N 행렬)
        N = sc.nextInt();
        int[][] matrix = new int[N][N];

        // 행렬 입력받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // M 입력받기 (선택할 행의 개수)
        M = sc.nextInt();
        comb = new int[M];
        
        // 행별 합 계산
        rowSums = new int[N];
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
            rowSums[i] = sum;
        }

        // 조합을 이용하여 최대합 찾기
        findMaxSum(0, -1);

        // 결과 출력
        System.out.println("result : " + maxSum);
    }

    // 조합을 이용한 최대 합 찾기
    static void findMaxSum(int depth, int last) {
        if (depth == M) { // M개를 선택했다면
        	int max = 0;
            for(int n : comb) {
            	max += n;
            }
            maxSum = Math.max(max, maxSum);
            return;
        }

        for(int i=last+1; i<N; i++) {
        	comb[depth] = rowSums[i];
        	findMaxSum(depth+1, i);
        }
    }
}
