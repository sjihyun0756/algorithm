package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타_레슨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()s);
		
		int max = 0;
		int min = 0;
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
		}
		
		min = max / M;
		
		int cnt = 0;
		int check = 0;
		while(true) {
			int mid = (min+max)/2;
			
			for(int i=0; i<N; i++) {
				
				if(check s)
				
			}
			
			
			
			
		}
		
		
		
		
		
	}

}
