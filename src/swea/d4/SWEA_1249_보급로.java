package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {
	
	static int N;
	static int[][] field;
	static int[][] cost;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1, 0,0};
	private static int findMinCost() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});
		cost[0][0] = 0;
		pq.offer(new int[] {0,0,0});
		
		while(!pq.isEmpty()) {
			int[] idxArr = pq.poll();
			int x = idxArr[0], y = idxArr[1], currCost = idxArr[2];
			
			if(x == N-1 && y == N-1) return currCost;
			
			for(int d = 0; d<4; d++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;
				
				if(0<= nx && nx < N && 0<= ny && ny < N) {
					int nextCost = currCost + field[nx][ny];
					if(nextCost < cost[nx][ny]) {
						cost[nx][ny] = nextCost;
						pq.offer(new int[] {nx, ny, nextCost});
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
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			
			N = Integer.parseInt(br.readLine());
			field = new int[N][N];
			cost = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j=0; j<N; j++) {
					field[i][j] = input.charAt(j)-'0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			sb.append(findMinCost()).append("\n");
		}
		System.out.println(sb);
	}
}