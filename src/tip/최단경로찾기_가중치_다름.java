package tip;

public class 최단경로찾기_가중치_다름 {
	
	/*
	 * package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용_구하기 {
	static List<int[]>[] graph;
	static int[] costArr;
	static int eNode;
	
	private static void findMinCost(int sNode) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		pq.add(new int[] {sNode, 0}); //노드, 비용
		costArr[sNode] = 0;
		
		while(!pq.isEmpty()) {
			int[] infoArr = pq.poll();
			int node = infoArr[0], currCost = infoArr[1];
			
			if(currCost > costArr[node]) continue;
			
			for(int[] n : graph[node]) {
				int nextNode = n[0];
				int nextCost = currCost + n[1];
				if(nextCost < costArr[nextNode]) { 
					costArr[nextNode] = nextCost;
					pq.offer(new int[] {nextNode,nextCost});
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 도시의 개수 
		int M = Integer.parseInt(br.readLine()); // 버스의 개수 
		
		graph = new ArrayList[N+1];
		costArr = new int[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
			costArr[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new int[] {v, cost});
		} //그래프 완
		
		st = new StringTokenizer(br.readLine());
		int sNode = Integer.parseInt(st.nextToken());
		eNode = Integer.parseInt(st.nextToken());
		
		if(sNode == eNode) {
			System.out.println(0);
			return;
		}
		
		findMinCost(sNode);
		System.out.println(costArr[eNode]);
	}
}

	 */
	/*
	 * package swea.d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int[][] map;
	static int[][] cost;
	
	private static int bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		q.offer(new int[] {0,0,0});
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int x = info[0], y = info[1], currCost = info[2];
			
			if(x == N-1 && y == N-1) return currCost;
			
			for(int d=0; d<4; d++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;
				
				if(0<= nx && nx < N && 0<= ny && ny < N) {
					int nextCost = currCost + map[nx][ny];
					
					if (nextCost < cost[nx][ny]) {
                        cost[nx][ny] = nextCost;
                        q.offer(new int[]{nx, ny, nextCost});
                    }
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc= 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cost = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = input.charAt(j)-'0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}//배열 받고
			
			cost[0][0] = 0;
			int currCost = bfs();
			sb.append(currCost).append("\n");
		}
		System.out.println(sb);
	}
}
	 */

}
