package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_2146_다리만들기 {
	
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static Queue<int[]> bridgeQ;
	static int[] node;

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
				if(0<=nx && nx <N && 0<= ny && ny < N && map[nx][ny] ==1) {
					map[nx][ny] = islandNum;
					islandQ.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	private static int findBridge() {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		int distance =0;
		while(!bridgeQ.isEmpty()) {
			int size = bridgeQ.size();
			for(int s= 0; s<size; s++) {
				int[] points = bridgeQ.poll();
				int x = points[0], y = points[1], currIslandNum = points[2];
				
				for(int d = 0; d<4; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					
					if(0<= nx && nx <N && 0<= ny && ny <N && !visit[nx][ny]) {
						int nextIslandNum = map[nx][ny];
						if(currIslandNum != nextIslandNum) {
							return distance;
						}
					}
				}
			}
			distance++;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==1) visit[i][j] = true;
			}
		}
		
		int islandNum = 2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					setIsland(i,j,islandNum);
					islandNum++;
				}
			}
		}
		
		bridgeQ = new ArrayDeque<>();
		int maxislandNum = islandNum-1;
		for(int island = 2; island<=maxislandNum; island++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == island) {
						bridgeQ.add(new int[] {i,j, island});
						islandNum++;
					}
				}
			}
		}
		System.out.println(findBridge());
	}
}