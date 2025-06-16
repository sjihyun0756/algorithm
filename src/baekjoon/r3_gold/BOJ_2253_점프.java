package baekjoon.r3_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2253_점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] jump = new int[N+1][2]; //점프 수, 크기 
		for(int i=0; i<M; i++) {
			int smallRock = Integer.parseInt(br.readLine());
			jump[smallRock][0] = -1;
		}
		
		jump[2][0] = jump[2][1] = 1;
		for(int i=2; i<N+1; i++) {
			int jumpCnt = jump[i][0];
			int jumpSize = jump[i][1];
			
			for(int j=-1; j<2; j++) {
				jumpSize += j;
				int idx = i + jumpSize;
				if(1<= jumpSize && idx < N+1) {
					jump[idx][0] = jump[i][0];
					jump[idx][1] = jumpSize;
				}
			}
		}
		System.out.println(jump[N][0] != 0 ? jump[N] : -1);
	}
}
