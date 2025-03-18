package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816_숫자_카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<>();
		
		int N= Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(map.get(num) != null) sb.append(map.get(num)).append(" ");
			else sb.append(0).append(" ");
		}
		System.out.println(sb);
	}
}
