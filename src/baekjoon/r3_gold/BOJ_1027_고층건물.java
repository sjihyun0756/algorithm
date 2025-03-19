package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027_고층건물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] building = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}

		int maxCnt = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
//			System.out.println(i + " 보는 중 ");
			int cnt  =0;
			
			// 오른쪽
			double rightSlope = Double.NEGATIVE_INFINITY;
			for (int j = i+1; j < N; j++) {
                double s = (double) (building[j] - building[i]) / (j-i);
//                System.out.println("오른쪽] " + j + "번째 기울기 : " + s );
                if (s > rightSlope) {
                    cnt++;
                    rightSlope = s;
//                    System.out.println("max : " + rightSlope);
                }
            }

			//왼쪽
			double leftSlope = Double.POSITIVE_INFINITY;
			for (int j = i - 1; j >= 0; j--) {
                double s = (double) (building[i] - building[j]) / (i - j);
//                System.out.println("왼쪽] " + j + "번째 기울기 : " + s );
                if (s < leftSlope) {
                    cnt++;
                    leftSlope = s;
                }
            }
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}
}