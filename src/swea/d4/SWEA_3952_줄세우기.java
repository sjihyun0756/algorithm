package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_3952_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] inDegree = new int[N+1];
			List<Integer>[] graph = new ArrayList[N+1];
			for(int i=0; i<N+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				inDegree[b]++;
				graph[a].add(b);
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			for(int i=1; i<N+1; i++) {
				if(inDegree[i]==0) q.offer(i);
			}
			
			while(!q.isEmpty()) {
				int node = q.poll();
				sb.append(node+" ");
				for(int n : graph[node]) {
					inDegree[n]--;
					if(inDegree[n] ==0) q.offer(n);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
