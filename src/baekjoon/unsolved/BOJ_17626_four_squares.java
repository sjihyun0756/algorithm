package baekjoon.unsolved;

import java.util.Scanner;

public class BOJ_17626_four_squares {
	static int[] square;
	static int n;
	static int sum = 0;
	static int minCnt = Integer.MAX_VALUE;
	
	private static void calSquare(int squareN) {
		for(int i=1; i<square.length; i++) {
			square[i] = i*i;
		}
	}
	
	private static void combination(int depth, int start,  int sum) {
		if(depth>3 || sum > n) return;
		
		if(sum==n) {
			minCnt = Math.min(minCnt, depth); 
			return;
		}
		
		for(int i = square.length-1; i>=start; i--) {
			combination(depth+1, i, sum+square[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double squareN = Math.sqrt(n);
		if(Math.ceil(squareN) == (int) squareN) {
			System.out.println(1);
			return;
		}
		
		square = new int[(int)squareN+1];
		calSquare((int)squareN);
		
		combination(0, 0, 0);
		if(minCnt<=3) System.out.println(minCnt);
		else System.out.println(4);
	}
}
