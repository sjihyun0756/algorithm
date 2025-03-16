package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원_순회2 {
	static int N;
	static int[][] priceMap;
	static boolean[] visit;
	static int minResult = Integer.MAX_VALUE;
	
	private static void findMinPrice(int start, int curr, int depth, int cost) {
		if(depth == N) {
			if(priceMap[curr][start] != 0) {
				minResult = Math.min(cost+priceMap[curr][start],minResult);
			}
			return;
		}
		
		for(int next = 0; next<N; next++) {
			if(visit[next] || priceMap[curr][next] == 0) continue;
			
			visit[next] = true;
			findMinPrice(start, next, depth+1, cost+priceMap[curr][next]);
			visit[next] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		priceMap = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				priceMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			visit[i] = true;
			findMinPrice(i,i,1,0);
			visit[i] = false;
		}
		System.out.println(minResult);
	}

}
