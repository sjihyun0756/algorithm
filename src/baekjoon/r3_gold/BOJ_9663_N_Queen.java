package baekjoon.r3_gold;

import java.util.*;

public class BOJ_9663_N_Queen {
	
	static int N, cnt, usedCol, usedDiag1, usedDiag2;
	
	private static void setQueen(int row) {
		if (row == N) {
	        cnt++;
	        return;
	    }
		
		for(int col=0; col<N; col++) {
			int d1 = row - col + (N-1);
			int d2 = row + col;
			
			if((usedCol & (1<<col)) != 0) continue;
			if ((usedDiag1 & (1 << d1)) != 0) continue;
			if ((usedDiag2 & (1 << d2)) != 0) continue;
			
			usedCol |= (1<<col);
		    usedDiag1 |= (1 << d1);
		    usedDiag2 |= (1 << d2);
			
			setQueen(row+1);
			
			usedCol &= ~(1<<col);
			usedDiag1 &= ~(1 << d1);
		    usedDiag2 &= ~(1 << d2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
		
		setQueen(0);
		System.out.println(cnt);
	}
}
