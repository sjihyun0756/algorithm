package baekjoon.r2_silver;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_조합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		m = m < n - m ? m : n - m;
		
		BigInteger result = BigInteger.ONE;
		
		for(int i=0; i<m; i++) {
			result = result.multiply(BigInteger.valueOf(n-i))
							.divide(BigInteger.valueOf(i+1));
		}
		
		System.out.println(result);
	}
}
