package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	
	static Deque<Integer> deque;
	static List<Integer>[] graph;
	static boolean[] visit;
	static int N;
	static int V;
	static int cnt;
	
	private static void bfs(int start) {
		
		deque = new ArrayDeque<>();
		visit[start] = true;
		deque.offerLast(start);
		
		cnt = 0;
		while(!deque.isEmpty()) {
			
			int point = deque.pollFirst();
			
			for(int v : graph[point]) {
				if(!visit[v]) {
					cnt++;
					visit[v] = true;
					deque.offerLast(v);
				}
			}
		}
	}
	
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<V; i++) {
			 st = new StringTokenizer(br.readLine());
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 
			 graph[u].add(v);
			 graph[v].add(u);
		}
			
		
		bfs(1);	
		System.out.println(cnt);
		
		
		
		
	}

}
