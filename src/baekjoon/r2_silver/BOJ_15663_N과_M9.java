package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15663_N과_M9 {
	
	static int[] arr;
	static boolean[] visit;
	static Set<String> result = new LinkedHashSet<>();
	static int[] find;
	static StringBuilder sb = new StringBuilder();
	
	private static void permutation(int depth) {
		if(depth == find.length) {
			sb.setLength(0);
			for(int n : find) {
				sb.append(n).append(" ");
			}
			result.add(sb.toString().trim());
			return;
		}
		
		for(int i = 0; i<arr.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			find[depth]=arr[i];
			permutation(depth+1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		find = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		permutation(0);
		for (String s : result) {
            System.out.println(s);
        }
	}
}
