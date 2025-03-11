package jungol.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL_1205_조커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int cntZero = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) cntZero++; 
            arr[i] = num;
        }
        
        if(cntZero == N) {
        	System.out.println(cntZero);
        	return;
        }
        
        
        Arrays.sort(arr);
        int maxLen = 0; 

        for (int i = cntZero; i < N; i++) {
            int prev = arr[i]; 
            int idx = i;
            int cnt = 1; 
            int availableZero = cntZero;

            while (idx < N - 1) {
                int curr = arr[++idx];
                int gap = curr - prev;

                if (gap == 0) continue; 
                if (gap == 1) {
                    cnt++;
                } else { 
                    if (availableZero >= gap - 1) {
                        availableZero -= (gap - 1);
                        cnt += gap;
                    } else {
                        break; 
                    }
                }
                prev = curr;
            }
            maxLen = Math.max(maxLen, cnt + availableZero); 
        }
        System.out.println(maxLen);
    }
}
