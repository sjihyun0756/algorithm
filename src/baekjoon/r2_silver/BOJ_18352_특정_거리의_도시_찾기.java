package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/*
//public class BOJ_18352_특정_거리의_도시_찾기 {
//	
//	static List<Integer>[] list;
//	static boolean[] visited;
//	static StringBuilder sb = new StringBuilder();
//	
//	static int N;
//	static int M;
//	static int K;
//	static int X;
//	
//	private static void dfs(int i, int depth) {
//
//		//System.out.println("현재 i " + i + "현재 depth : " + depth);
//		if(depth == K) {
//			System.out.println("추가중");
//			if(!list[i].contains(X)) {
//				sb.append(i).append("\n");
//			}
//			return;
//		}
//		
//		visited[i] = true;
//		System.out.println(Arrays.toString(visited));
//		
//		for(int v : list[i]) {
//			System.out.println("for문 들어옴 " + list[i]);
//			System.out.println("지금 보는 노드 : "+v );
//			if(!visited[v]) {
//				System.out.println("다시 재귀 들어감 ---------------");
//				dfs(v,depth+1);
//			}
//		}
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken()); //도시 수(노드)
//		M = Integer.parseInt(st.nextToken()); //도로 수(간선)
//		K = Integer.parseInt(st.nextToken()); //거리정보(depth)
//		X = Integer.parseInt(st.nextToken()); //출발점
//		
//		System.out.println(" 도시 수 : " + N + " 도로 수 : " + M + " depth : " + K + " 출발점 : " +X);
//		
//		list = new List[N+1];
//		visited = new boolean[N+1];
//		
//		for(int i=0; i<N+1; i++) {
//			list[i] = new ArrayList<>();
//		}//
//		
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int u = Integer.parseInt(st.nextToken());
//			int v = Integer.parseInt(st.nextToken());
//			
//			list[u].add(v);
//		}
//		
//		System.out.println(Arrays.toString(list));
//		System.out.println(Arrays.toString(visited));
//		
////		for(int i=1; i<N+1; i++) {
////			if(list[i].size()==1) {
////				if(dfs(i,0)) {
////					sb.append(i).append("\n");	
////				}
////			}
////		}
//		
//		dfs(X,0);
////		
//		if(sb.isEmpty()) System.out.println(-1);
//		else System.out.println(sb);
//		
//	}
//}
*/

public class BOJ_18352_특정_거리의_도시_찾기 {
	
	static List<Integer>[] list;
	static Deque<Integer> deque = new ArrayDeque<>();
	static boolean[] visited;
	static int[] checkDepth;
	static List<Integer> result = new ArrayList<>();
	static int K;
	
	private static void bfs(int i) {
		deque.offerLast(i);
		visited[i] = true;
		
		while(!deque.isEmpty()) {
			int point = deque.pollFirst();
			for(int v : list[point]) {
				if(!visited[v]) {
					deque.offerLast(v);
					visited[v] = true;
					checkDepth[v] = checkDepth[point] +1;
					if(checkDepth[v] ==K) {
						result.add(v);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //도시 수(노드)
		int M = Integer.parseInt(st.nextToken()); //도로 수(간선)
		K = Integer.parseInt(st.nextToken()); //거리정보(depth)
		int X = Integer.parseInt(st.nextToken()); //출발점
		
		
		list = new List[N+1];
		checkDepth = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}//
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v); //단방향 추가
		}
		
		bfs(X);
		Collections.sort(result);
		if(result.size() != 0) {
			StringBuilder sb = new StringBuilder();
			for (int num : result) {
			    sb.append(num).append("\n");
			}
			System.out.print(sb);
		}
		else System.out.println(-1);
		
	}
}
