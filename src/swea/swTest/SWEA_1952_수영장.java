package swea.swTest;

import java.io.*;
import java.util.*;

public class SWEA_1952_수영장 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#"+tc+" ");
            int[] prices = new int[4]; 
            int[] plans = new int[13]; 
            int[] dp = new int[13];   

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plans[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= 12; i++) {
                int oneDay = dp[i - 1] + plans[i] * prices[0];
                int oneMonth = dp[i - 1] + prices[1];
                int threeMonth = i >= 3 ? dp[i - 3] + prices[2] : prices[2];

                dp[i] = Math.min(oneDay, Math.min(oneMonth, threeMonth));
                System.out.println(Arrays.toString(dp));
            }

            int result = Math.min(dp[12], prices[3]); 
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
