package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817_부분_수열의_합 {
	static int K, N, cnt;
	static int[] arr;
	private static void combination(int depth, int last, int sum) {
		if (sum == K) {
			cnt++;
		}
		if (sum > K || depth >= N) {
			return;
		}

		for (int i = last + 1; i < N; i++) {
			combination(depth + 1, i, sum + arr[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N];
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, -1, 0); 
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
