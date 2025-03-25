package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_1238_Contact {
	static List<Integer>[] graph;
	static boolean[] visit;
	static int maxNum;
	
	private static void bfs(int startNum) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(startNum);
		visit[startNum] = true;
		
		int findMax = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			findMax = 0;
			for(int i=0; i<size; i++) {
				int node = q.poll();
				for(int n : graph[node]) {
					if(!visit[n]) {
						q.offer(n);
						visit[n] = true;
						findMax = Math.max(findMax, n);
						maxNum =findMax;
					}
				}
			}//
		}
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		nextTC:
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int dataLen = Integer.parseInt(st.nextToken());
			int startNum = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[101];
			visit = new boolean[101];
			for(int i=0; i<=100; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}
			
			System.out.println(Arrays.toString(graph));
			maxNum = Integer.MIN_VALUE;
			
			bfs(startNum);
			sb.append(maxNum).append("\n");
			System.out.println(maxNum);
		}
		System.out.println(sb);
	}
}
