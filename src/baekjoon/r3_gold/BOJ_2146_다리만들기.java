package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_2146_다리만들기 {

	static int[][] map;
	static boolean[][] visit;
	static int N;
	static Queue<int[]> bridgeQ;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	private static void setIsland(int i, int j, int islandNum) {
		Queue<int[]> islandQ = new ArrayDeque<>();
		islandQ.offer(new int[] { i, j });
		map[i][j] = islandNum;

		while (!islandQ.isEmpty()) {
			int[] points = islandQ.poll();
			int x = points[0], y = points[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 1) {
					map[nx][ny] = islandNum;
					islandQ.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static int findBridge(int maxIslandNum) {
        int minDist = Integer.MAX_VALUE;

        for (int islandNum = 2; islandNum < maxIslandNum; islandNum++) {
            visit = new boolean[N][N];
            bridgeQ = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == islandNum) {
                    	bridgeQ.offer(new int[]{i, j, 0});
                        visit[i][j] = true;
                    }
                }
            }

            while (!bridgeQ.isEmpty()) {
                int[] points = bridgeQ.poll();
                int x = points[0], y = points[1], dist = points[2];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;

                    if (map[nx][ny] != 0 && map[nx][ny] != islandNum) {
                        minDist = Math.min(minDist, dist);
                        bridgeQ.clear();
                        break;
                    }

                    if (map[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        bridgeQ.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return minDist;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int islandNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					setIsland(i, j, islandNum);
					islandNum++;
				}
			}
		}
		int maxIslandNum = islandNum;
		System.out.println(findBridge(maxIslandNum));
	}
}