package baekjoon.unsolved;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10971_외판원_순회2 {
	
	static List<Integer>[] graph;
	static int[][] priceMap;
	static boolean[] visit;
	
	private static void dfs(int n) {
		
		if(visit[n]) return;
		visit[n] = true;
		
		for(int node : graph[n]) {
			if(!visit[n]) {
				dfs(node);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		priceMap = new int[N+1][N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			int idx = 1;
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int price = Integer.parseInt(st.nextToken());
				if(price!=0) {
					graph[i].add(idx++);
				}else idx++;
				priceMap[i][j] = price;
			}
		}
		System.out.println(Arrays.toString(graph));
		System.out.println(Arrays.deepToString(priceMap));
		
		for(int i=1; i<=N; i++) {
			if(!visit[i]) dfs(i);
		}
	}

}
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원_순회2 {

    static int N;
    static int[][] priceMap;
    static boolean[] visit;
    static int minCost = Integer.MAX_VALUE;

    private static void findMin(int start, int cur, int count, int cost) {
        if (count == N) { 
            if (priceMap[cur][start] != 0) {
                minCost = Math.min(minCost, cost + priceMap[cur][start]);
            }
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visit[next] && priceMap[cur][next] != 0) {
                visit[next] = true;
                findMin(start, next, count + 1, cost + priceMap[cur][next]);
                visit[next] = false; 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        priceMap = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                priceMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) { 
            visit[i] = true;
            findMin(i, i, 1, 0);
            visit[i] = false;
        }
        System.out.println(minCost);
    }
}