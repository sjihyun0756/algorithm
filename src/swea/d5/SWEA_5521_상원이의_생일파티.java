package swea.d5;

import java.io.*;
import java.util.*;

public class SWEA_5521_상원이의_생일파티 {
	static List<Integer>[] graph;
	static boolean[] visit;
	
	private static int bfs(int num) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(num);
		visit[num] = true;
		
		int depth = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			if(depth ==2) break;
			
			for(int i=0; i<size; i++) {
				int node = q.poll();
				
				for(int n : graph[node]) {
					if(!visit[n]) {
						q.offer(n);
						visit[n] = true;
						cnt++;
					}
				}
			}
			depth++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		nextTC:
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			visit = new boolean[N+1];
			for(int i=0; i<N+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st= new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			
			if(graph[1].size() == 0) {
				sb.append("0\n");
				continue nextTC;
			}
			
			int cnt = bfs(1);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
