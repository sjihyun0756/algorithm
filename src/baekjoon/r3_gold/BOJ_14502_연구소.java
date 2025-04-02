package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_14502_연구소 {
	static int N, M, cntZero;
	static int[] arr;
	static int[] result;
	static int[][] map;
	static boolean[][] visit;
	static List<int[]> zeroList;
	static List<int[]> twoList;
	static Queue<int[]> q;
	static int maxZone = 0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	
	private static void bfs(int[] idxArr) {
		visit = new boolean[N][M];
		int x1 = zeroList.get(idxArr[0])[0], y1 = zeroList.get(idxArr[0])[1];
		int x2 = zeroList.get(idxArr[1])[0], y2 = zeroList.get(idxArr[1])[1];
		int x3 = zeroList.get(idxArr[2])[0], y3 = zeroList.get(idxArr[2])[1];
		
		map[x1][y1] = map[x2][y2] = map[x3][y3] = 1;
		int cnt = cntZero -3;
		q = new ArrayDeque<>();
		for(int[] idx : twoList) {
			q.offer(new int[] {idx[0],idx[1]});
		}
		
		while(!q.isEmpty()) {
			int[] out = q.poll();
			int x = out[0], y = out[1];
			
			for(int d = 0; d<4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				
				if(0<= nx && nx < N && 0<= ny && ny <M && !visit[nx][ny] && map[nx][ny] ==0) {
					visit[nx][ny] = true;
					cnt--;
					q.offer(new int[] {nx,ny});
				}
			}
		}
		map[x1][y1] = map[x2][y2] = map[x3][y3] = 0; //되돌려놓기
		maxZone = Math.max(cnt, maxZone);
	}
	
	private static void findCombination(int depth, int last) {
		if(depth == 3) {
			bfs(result);
			return;
		}
		
		for(int i=last+1; i<arr.length; i++) {
			result[depth] = arr[i];
			findCombination(depth+1, i);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		zeroList = new ArrayList<>();
		twoList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zeroList.add(new int[] {i,j});
				if(map[i][j] == 2) twoList.add(new int[] {i,j});
			}
		}
		
		cntZero = zeroList.size();
		arr = new int[cntZero];
		Arrays.setAll(arr, i->i);
		result = new int[3];
		
		findCombination(0,-1);
		System.out.println(maxZone);
	}
}
