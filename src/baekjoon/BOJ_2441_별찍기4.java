package baekjoon;

import java.util.Scanner;

public class BOJ_2441_별찍기4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=5; i>0; i--) {
			System.out.print(" ".repeat(n-i));
			System.out.println("*".repeat(i));
		}
	}
}


/*
*****
 ****
  ***
   **
    *
*/