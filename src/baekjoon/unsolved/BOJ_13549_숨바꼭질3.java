package baekjoon.unsolved;

import java.util.*;

public class BOJ_13549_숨바꼭질3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0; 

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now * 2 <= 100000 && dp[now * 2] > dp[now]) {
                dp[now * 2] = dp[now];
                deque.offerFirst(now * 2);
            }

            if (now + 1 <= 100000 && dp[now + 1] > dp[now] + 1) {
                dp[now + 1] = dp[now] + 1;
                deque.offerLast(now + 1);
            }
            if (now - 1 >= 0 && dp[now - 1] > dp[now] + 1) {
                dp[now - 1] = dp[now] + 1;
                deque.offerLast(now - 1);
            }
        }
        System.out.println(dp[M]);
    }
}