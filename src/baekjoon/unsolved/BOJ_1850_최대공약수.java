package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1850_최대공약수 {
	
	static long result;
	private static void findNum(long A, long B) {
		long R = A%B;
		if(R==0) {
			result = R;
			return;
		}
		findNum(B,R);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = (1 << Long.parseLong(st.nextToken())) -1;
		long B = (1<< Long.parseLong(st.nextToken())) -1;
		
		System.out.println(A);
		System.out.println(B);
		
		result =0;
		if(A>B) {
			result = findNum(A,B);
		}else {
			result = findNum(B,A);
		}
		
		System.out.println(result);
	}
}
