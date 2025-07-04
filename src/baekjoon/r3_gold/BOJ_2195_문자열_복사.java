package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2195_문자열_복사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String P = br.readLine();

		int idx = 0, cnt = 0;
		while (idx < P.length()) {
			int maxLen = 0;
			for (int i = 0; i < S.length(); i++) {
				int len = 0;
				while (i + len < S.length() && idx + len < P.length() && S.charAt(i + len) == P.charAt(idx + len)) {
					len++;
				}

				maxLen = Math.max(maxLen, len);
			}
			idx += maxLen;
			cnt++;         
		}
		System.out.println(cnt);
	}
}
