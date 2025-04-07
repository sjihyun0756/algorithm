package swea.unsolved;

import java.util.*;
import java.io.*;

public class SWEA_5656_벽돌깨기 {
    static int W, H, N;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] select;
    static int minBrick;

    private static void breakBrick(int[][] copyMap, int col) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < H; r++) {
            if (copyMap[r][col] != 0) {
                q.offer(new int[]{r, col, copyMap[r][col]});
                copyMap[r][col] = 0; 
                break;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], power = cur[2];

            for (int d = 0; d < 4; d++) {
                for (int p = 1; p < power; p++) {
                    int nx = x + dx[d] * p;
                    int ny = y + dy[d] * p;

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if (copyMap[nx][ny] == 0) continue;

                    q.offer(new int[]{nx, ny, copyMap[nx][ny]});
                    copyMap[nx][ny] = 0; 
                }
            }
        }

        removeApply(copyMap);
    }

    private static void removeApply(int[][] map) {
        for (int col = 0; col < W; col++) {
            Stack<Integer> stack = new Stack<>();
            for (int row = H - 1; row >= 0; row--) {
                if (map[row][col] != 0) {
                    stack.push(map[row][col]);
                    map[row][col] = 0;
                }
            }
            int row = H - 1;
            while (!stack.isEmpty()) {
                map[row--][col] = stack.pop();
            }
        }
    }

    private static int countBrick(int[][] map) {
        int count = 0;
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (map[i][j] != 0) count++;
        return count;
    }

    private static void permutation(int depth) {
        if (minBrick == 0) return; 

        if (depth == N) {
            int[][] copyMap = new int[H][W];
            for (int i = 0; i < H; i++) copyMap[i] = map[i].clone();

            for (int i = 0; i < N; i++) {
                breakBrick(copyMap, select[i]);
            }

            int remain = countBrick(copyMap);
            minBrick = Math.min(minBrick, remain);
            return;
        }

        for (int i = 0; i < W; i++) {
            select[depth] = i;
            permutation(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            minBrick = Integer.MAX_VALUE;
            select = new int[N];

            permutation(0);

            sb.append(minBrick).append("\n");
        }
        System.out.print(sb);
    }
}