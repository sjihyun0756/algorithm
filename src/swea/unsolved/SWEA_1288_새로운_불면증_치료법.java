package swea.unsolved;

import java.util.*;
import java.io.*;

public class SWEA_1288_새로운_불면증_치료법 {
	static int base;
	static int check;
	
	private static void cntSheep(int N) {
		base = (1<<11) -1;
		check = 0;
		int cnt = 0;
		while(true) {
			
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			sb.append("#"+tc+" ");
			int N = Integer.parseInt(br.readLine());
			cntSheep(N);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}