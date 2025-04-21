package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_15686_치킨_배달 {
    static int N, M;
    static int[][] map;
    static List<chickenJoint> chickenList = new ArrayList<>();
    static int[] select;
    static int result = Integer.MAX_VALUE;

    private static class chickenJoint {
        int x, y;

        public chickenJoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int calMinDistance(int[] select) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) { 
                    int minDist = Integer.MAX_VALUE;
                    for (int idx : select) {
                        chickenJoint cj = chickenList.get(idx);
                        int dist = Math.abs(cj.x - i) + Math.abs(cj.y - j);
                        minDist = Math.min(minDist, dist);
                    }
                    total += minDist;
                }
            }
        }
        return total;
    }

    private static void findSet(int depth, int last) {
        if (depth == M) {
            result = Math.min(result, calMinDistance(select));
            return;
        }

        for (int i = last + 1; i < chickenList.size(); i++) {
            select[depth] = i;
            findSet(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenList.add(new chickenJoint(i, j));
                }
            }
        }

        select = new int[M];
        findSet(0, -1);
        System.out.println(result);
    }
}
