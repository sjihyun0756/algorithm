package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_17472_다리만들기2 {
	
	static int[][] map;
	static int N;
	static int M;
	static Queue<int[]> bridgeQ;
	static List<Edge> edges;
	static int[] node;
	
	static class Edge{
		int from, to, distance;
		public Edge(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
	}
	
	private static int findNode(int num) {
		if(node[num] == num) return num;
		return node[num] = findNode(node[num]);
	}

	private static boolean unionFind(int numA, int numB) {
		int rootA = findNode(numA);
		int rootB = findNode(numB);
		
		if(rootA == rootB) return false;
		if(rootA<rootB) node[rootB] = rootA;
		else node[rootA] = rootB;
		return true;
	}
	
	private static void setIsland(int i, int j, int islandNum) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		Queue<int[]> islandQ = new ArrayDeque<>();
		islandQ.offer(new int[] {i, j});
		map[i][j] = islandNum;
		
		while(!islandQ.isEmpty()) {
			int[] points = islandQ.poll();
			int x = points[0], y = points[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if(0<=nx && nx <N && 0<= ny && ny < M && map[nx][ny] ==1) {
					map[nx][ny] = islandNum;
					islandQ.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	private static void findBridge(int islandNum) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!bridgeQ.isEmpty()) {
			int[] points = bridgeQ.poll();
			int x = points[0], y = points[1];
			
			for(int d = 0; d<4; d++) {
				for(int p=1; p<Math.max(N, M); p++) {
					int nx = x + dx[d]*p, ny = y + dy[d]*p;
					
					if(0>nx || nx >=N || 0>ny || ny >= M) break;
					
					if(map[nx][ny] == islandNum) break;
					
					if(map[nx][ny] != 0) { //찾았다!
						if(p-1>=2) {
							int from = islandNum, to = map[nx][ny], distance = p-1;
							if(from < to) {
								edges.add(new Edge(from, to, distance));
							}
						}
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int islandNum = 2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					setIsland(i,j,islandNum);
					islandNum++;
				}
			}
		}
		
		edges = new ArrayList<>();
		bridgeQ = new ArrayDeque<>();
		int maxislandNum = islandNum-1;
		for(int island = 2; island<=maxislandNum; island++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == island) {
						bridgeQ.add(new int[] {i,j});
						islandNum++;
					}
				}
			}
			findBridge(island);
		}
		edges.sort((e1,e2) -> Integer.compare(e1.distance, e2.distance));
		node = new int[maxislandNum+1];
		Arrays.setAll(node, i->i);
		
		int totalDist = 0;
		int cnt = 0;
		boolean isPossible = false;
		for(Edge e : edges) {
			if(unionFind(e.from, e.to)) {
				cnt++;
				totalDist += e.distance;
				if(cnt == (maxislandNum - 2)) {
					isPossible = true;
					break;
				}
			}
		}
		System.out.println(isPossible ? totalDist : -1);
	}
}
