package swea.d6;

import java.io.*;
import java.util.*;

public class SWEA_1267_작업의_순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[] inDegree = new int[V+1];
			List<Integer>[] graph = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				inDegree[b]++;
				graph[a].add(b);
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			for(int i=1; i<V+1; i++) {
				if(inDegree[i] == 0) q.offer(i);
			}
			
			while(!q.isEmpty()) {
				int node = q.poll();
				sb.append(node +" ");
				
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
