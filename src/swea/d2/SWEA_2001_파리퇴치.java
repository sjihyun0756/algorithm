package swea.d2;

import java.io.*;
import java.util.*;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); 
			int N = Integer.parseInt(st.nextToken()); 
			
			int[][] fly = new int[M+1][M+1];
			for(int i=1; i<=M; i++) { 
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=M; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			int[][] sumFly = new int[M+1][M+1];
			for(int i=1; i<=M; i++) { 
				for(int j=1; j<=M; j++) {
					sumFly[i][j] = sumFly[i][j-1] + sumFly[i-1][j] - sumFly[i-1][j-1] + fly[i][j];				
				}
			}
			
			int max = 0;
			for(int i = N; i<=M;i++) { 
				for(int j=N; j<=M; j++) {
					int sum = sumFly[i][j] - sumFly[i-N][j] - sumFly[i][j-N] + sumFly[i-N][j-N];
					max = Math.max(max, sum);
				}
			}
			sb.append("#"+tc+" "+max).append("\n");
		}
		System.out.println(sb);
	}
}