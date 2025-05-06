package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_2293_동전1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> coins = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			if (coin <= K) {
				coins.add(coin);
			}
		}

		int size = coins.size();
		int[][] dp = new int[size + 1][K + 1];

		for (int i = 1; i <= size; i++) {
			int coin = coins.get(i - 1);
			dp[i][coin] = 1;
		}

		for (int i = 1; i <= size; i++) {
			int coin = coins.get(i - 1);
			for (int j = coin + 1; j <= K; j++) {
				int idx = j - coin;
				int sum = 0;
				for (int row = 0; row <= i; row++) {
					sum += dp[row][idx];
				}
				dp[i][j] = sum;
			}
		}

		int result = 0;
		for (int i = 1; i <= size; i++) {
			result += dp[i][K];
		}
		System.out.println(result);
	}
}
