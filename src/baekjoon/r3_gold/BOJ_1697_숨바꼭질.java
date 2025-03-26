package baekjoon.r3_gold;

import java.util.*;

public class BOJ_1697_숨바꼭질 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 100000;

		boolean[] visit = new boolean[max+1];

		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		visit[N] = true;

		int time = 0;
		
		Searching:
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int place = q.poll();

				if(place == M) break Searching;
				
				int case1 = place + 1;
				int case2 = place - 1;
				int case3 = place * 2;
				
				if(case1 == M || case2 == M || case3 == M) {
					time++;
					break Searching;
				}
				
				if(0<= case1 && case1 <= max && !visit[case1]) {
					q.offer(case1);
					visit[case1] = true;
				}
				
				if(0<= case2 && case2 <= max && !visit[case2]) {
					q.offer(case2);
					visit[case2] = true;
				}
				
				if(0<= case3 && case3 <= max && !visit[case3]) {
					q.offer(case3);
					visit[case3] = true;
				}
			}
			time++;
		}
		System.out.println(time);
	}
}
