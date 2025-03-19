package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13251_조약돌_꺼내기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine()); 
        int[] color = new int[M];
        int denominator = 0; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            denominator += color[i]; 
        }
        int K = Integer.parseInt(br.readLine()); 
        if (M == 1 || K == 1) {
            System.out.println(1.0);
            return;
        }

        double p = 0.0; 
        for (int i = 0; i < M; i++) {
            int n = color[i]; 
            int d = denominator; 
            int cnt = K;
            double cal = 1.0;
            
            for (int j = 0; j < K; j++) {
                cal *= (double)(n - j) / (d - j);
            }
            p += cal; 
        }
        System.out.println(p); 
    }
}