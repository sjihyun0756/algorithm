package baekjoon.r2_silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2331_반복수열 {
	static List<Integer> result = new ArrayList<>();
	static int P;
	
	private static void dfs(int num) {
		int cal = 0;
		for(int i=0; i<String.valueOf(num).length(); i++) {
			cal += Math.pow(String.valueOf(num).charAt(i)-'0', P);
		}
		if(!result.contains(cal)) {
			result.add(cal);
			dfs(cal);
		}else {
			for(int i=0; i<result.size(); i++) {
				if(result.get(i) == cal) System.out.println(i);
			}
			return;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		P = sc.nextInt();
		result.add(A);
		dfs(A);
	}//
}
