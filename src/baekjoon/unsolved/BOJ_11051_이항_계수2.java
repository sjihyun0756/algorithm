package baekjoon.unsolved;

import java.util.Scanner;

public class BOJ_11051_이항_계수2 {
	static int N;
	static int K;
	
	private static int calCombination(int start, int end, int cal) {
		
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		K = Integer.parseInt(sc.nextLine());
		K = K>N-K? K:N-K;
		
		calCombination();
				
	}
}
