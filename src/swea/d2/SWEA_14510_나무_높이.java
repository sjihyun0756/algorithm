package swea.d2;

import java.io.*;
import java.util.*;

public class SWEA_14510_나무_높이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            int N = Integer.parseInt(br.readLine());
            int[] tree = new int[N];
            st = new StringTokenizer(br.readLine());

            int max = 0;
            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, tree[i]);
            }

            int oddCount = 0, totalDiff = 0;

            for (int i = 0; i < N; i++) {
                int diff = max - tree[i];
                if (diff % 2 != 0) oddCount++; 
                totalDiff += diff;
            }

            int greedyDays = (totalDiff / 3) * 2 + (totalDiff % 3);
            int oneDays = (greedyDays + 1) / 2;

            int result = (oneDays >= oddCount) ? greedyDays : (2 * oddCount - 1);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
