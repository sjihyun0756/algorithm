package baekjoon.unsolved;

import java.util.*;

public class BOJ_1629_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int mod = (int) (Math.pow((A % C) , B) % B);
		
		System.out.println(mod);
	}
}
