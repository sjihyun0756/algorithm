package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

class Node {
	int num;
	String path;
	
	Node(int num, String path){
		this.num = num;
		this.path = path;
	}
}

public class BOJ_9019_DSLR {
	private static String bfs(int start, int end) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[] visit = new boolean[100001];
		q.offer(new Node(start,""));
		visit[start] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();

			if(node.num==end) return node.path; //숫자 + 경로 return
			
			int D = (node.num * 2) % 10000;
	        int S = node.num == 0 ? 9999 : node.num - 1;
	        int L = (node.num % 1000) * 10 + node.num / 1000;
	        int R = (node.num % 10) * 1000 + node.num / 10;
			
			if(!visit[D]) {
				visit[D] = true;
				q.offer(new Node(D, node.path+"D"));
			}
			if(!visit[S]) {
				visit[S] = true;
				q.offer(new Node(S, node.path+"S"));
			}
			if(!visit[L]) {
				visit[L] = true;
				q.offer(new Node(L, node.path+"L"));
			}
			if(!visit[R]) {
				visit[R] = true;
				q.offer(new Node(R, node.path+"R"));
			}
		}
		return "-1";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
		
			String result = bfs(start,end);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
