package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1167_트리의_지름 {
	
	private static class Node{kkkkkkkkkkkkk
		int from, to, cost;
		
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		
		List<Node> graph = new ArrayList<>();
//		for(int i=0; i<V+1; i++) {
//			graph[i] = new ArrayList<>();
//		}
		
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				if(v==-1) break;
				int cost = Integer.parseInt(st.nextToken());
				
				
				
			}
		}
		
	}
}
