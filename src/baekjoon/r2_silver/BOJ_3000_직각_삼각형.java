package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_3000_직각_삼각형 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Long> xCnt = new HashMap<>();
        Map<Integer, Long> yCnt = new HashMap<>();

        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xCnt.put(x, xCnt.getOrDefault(x, 0L) + 1);
            yCnt.put(y, yCnt.getOrDefault(y, 0L) + 1);
            points.add(new int[]{x, y});
        }

        long sum = 0;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            sum += (xCnt.get(x) - 1) * (yCnt.get(y) - 1);
        }

        System.out.println(sum);
    }
}