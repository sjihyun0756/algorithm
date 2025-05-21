package baekjoon.unsolved;

import java.util.*;

public class BOJ_2011_암호코드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int len = N.length();

        int[] dp = new int[len + 1];
        int mod = 1000000;

        if (N.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            int oneDigit = N.charAt(i - 1) - '0';
            int twoDigit = Integer.parseInt(N.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= mod;
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= mod;
            }
        }
        System.out.println(dp[len]);
    }
}
