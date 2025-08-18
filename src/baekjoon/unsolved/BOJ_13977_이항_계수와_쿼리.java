package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_13977_이항_계수와_쿼리 {
	
	private static StringBuilder sb = new StringBuilder();
	private static final int DIV = 1_000_000_007;

	private static long powMod(long a, long b) {
	    long res = 1;
	    a %= DIV;
	    while (b > 0) {
	        if ((b & 1) == 1) res = (res * a) % DIV;
	        a = (a * a) % DIV;
	        b >>= 1;
	    }
	    return res;
	}

	private static long modInv(long a) {
	    return powMod(a, DIV - 2);
	}

	private static void calculateRemain(int n, int k) {
	    if (k < 0 || k > n) { 
	        sb.append(0).append('\n');
	        return;
	    }
	    
	    int r = Math.min(k, n - k); 
	    
	    long result = 1;
	    for (int i = 0; i < r; i++) {
	        result = (result * (n - i)) % DIV;         
	        result = (result * modInv(i + 1)) % DIV;   
	    }
	    sb.append(result).append('\n');
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			calculateRemain(M,K);
		}
		System.out.println(sb);
	}
}
