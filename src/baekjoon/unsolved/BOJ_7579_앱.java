package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_7579_앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        int[] memory = new int[N];
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) memory[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());

        int maxCost = 10000;
        int[] dp = new int[maxCost + 1]; 

        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int i = 0; i <= maxCost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}