package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1486_장훈이의_높은_선반 {
	static int B;
	static int[] height;
	static int minResult;
	
	
	private static void findCombination(int depth, int last, int cal) {
		
		if(cal >= B) {
			minResult = Math.min(cal-B, minResult);
		}
		
		if(depth>= height.length) return;
		
		for(int i = height.length-1; i>=last+1; i--) {
			findCombination(depth+1, i, cal+height[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			minResult= Integer.MAX_VALUE;
			findCombination(0,-1,0);
			sb.append(minResult).append("\n");
		}
		System.out.println(sb);
	}
}
