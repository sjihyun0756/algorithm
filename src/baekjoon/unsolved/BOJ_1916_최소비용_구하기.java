package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
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


public class BOJ_1916_최소비용_구하기 {
	static List<int[]>[] graph;
	static int[] costArr;
	
	private static void findMinCost(int sNode) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int currNode = sNode, currCost = 0;
		pq.add(new int[] {currNode, currCost});
		
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			currNode = info[0]; currCost = info[1];
			
			if(currCost > costArr[currNode]) continue;
			
			for(int[] n : graph[currNode]) {
				int nextNode = n[0], nextCost = n[1] + currCost;
				
				if(nextCost < costArr[nextNode]) {
					costArr[nextNode] = nextCost;
					pq.offer(new int[] {nextNode, nextCost});
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
//		
//		
//		for (int i = 1; i <= N; i++) {
//		    System.out.print("노드 " + i + " : ");
//		    for (int[] edge : graph[i]) { 
//		        System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
//		    }
//		    System.out.println();
//		}

		
		st = new StringTokenizer(br.readLine());
		int sNode = Integer.parseInt(st.nextToken());
		int eNode = Integer.parseInt(st.nextToken());
		
		if(sNode == eNode) {
			System.out.println(0);
			return;
		}
		
		findMinCost(sNode);
		System.out.println(costArr[eNode]);
	}
}
