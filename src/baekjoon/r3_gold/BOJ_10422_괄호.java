package baekjoon.r3_gold;

import java.io.*;

public class BOJ_10422_괄호 {
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		init();
	}
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num %2 != 0) sb.append(0).append("\n");
		}
		
	}
}
