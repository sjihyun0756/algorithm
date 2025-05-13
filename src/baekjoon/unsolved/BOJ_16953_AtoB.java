package baekjoon.unsolved;

import java.util.*;

public class BOJ_16953_AtoB {
	
	private static int bfs(int A, int B) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[B+1];
		q.offer(A);
		visit[A] = true;
		
		int depth = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s<size; s++) {
				long num = q.poll();
				if(num == B) return depth;
				
				long case1 = num *2;
				long case2 = num * 10 + 1;
				
				if(case1 <=B && !visit[(int)case1]) {
					q.offer((int)case1);
					visit[(int)case1] = true;
				}
				
				if(case2 <=B && !visit[(int)case2]) {
					q.offer((int)case2);
					visit[(int)case2] = true;
				}
			}
			depth++;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int result = bfs(A,B);
		System.out.println(result);
	}
}
