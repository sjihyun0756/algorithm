package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 {

    static boolean[][] map;
    static boolean[][][] visit;
    static int N, M;

    private static int bfs(int i, int j) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j, 1}); 
        visit[i][j][1] = true;

        int level = 1; 
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] out = q.poll();
                int x = out[0], y = out[1], heart = out[2];

                if (x == N - 1 && y == M - 1) return level;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    if (map[nx][ny] && !visit[nx][ny][heart]) { //길임 
                        visit[nx][ny][heart] = true;
                        q.offer(new int[] {nx, ny, heart});
                    }

                    else if (!map[nx][ny] && heart == 1 && !visit[nx][ny][0]) { //벽임 
                        visit[nx][ny][0] = true;
                        q.offer(new int[] {nx, ny, 0});
                    }
                }
            }
            level++;
        }

        return -1; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visit = new boolean[N][M][2]; 

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) == '0'; 
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }
}