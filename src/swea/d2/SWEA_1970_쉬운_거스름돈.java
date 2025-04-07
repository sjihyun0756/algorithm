package swea.d2;

import java.util.Scanner;
import java.util.Arrays;

public class SWEA_1970_쉬운_거스름돈 {
    static final int INF = 1_000_000_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append("\n");

            int N = sc.nextInt();               // 실제 금액
            int size = N / 10 + 1;              // 10의 배수 단위 크기
            int[] dp = new int[size];
            int[][] map = new int[size][coins.length];

            Arrays.fill(dp, INF);
            dp[0] = 0;

            for (int i = 0; i < size; i++) {
                int currAmount = i * 10;
                if (dp[i] == INF) continue; // 경로가 없으면 생략

                for (int j = 0; j < coins.length; j++) {
                    int coin = coins[j];
                    int nextAmount = currAmount + coin;

                    if (nextAmount > N) continue;

                    int ni = nextAmount / 10;
                    if (dp[i] + 1 < dp[ni]) {
                        dp[ni] = dp[i] + 1;
                        for (int k = 0; k < coins.length; k++) {
                            map[ni][k] = map[i][k]; 
                        }
                        map[ni][j]++;
                    }
                }
            }

            int[] result = map[N / 10];
            for (int count : result) {
                sb.append(count).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}