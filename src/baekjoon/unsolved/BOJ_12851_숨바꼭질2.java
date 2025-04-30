package baekjoon.unsolved;

import java.util.*;
import java.io.*;

public class BOJ_12851_숨바꼭질2 {
	
	private static int[] bfs(int N,int M) {
		Queue<Integer> q = new ArrayDeque<>();
		 boolean[] visit = new boolean[100001];
		 
		 int min = 0;
		 int max = 100000;
		 
		 q.offer(N);
		 visit[N] = true;
		 
		 int caseCnt = 0;
		 int minTime = 0;
		 while(!q.isEmpty()) {
			 int size = q.size();
			 for(int s = 0; s<size; s++) {
				 int num = q.poll();
				 
				 int num1 = num+1;
				 int num2 = num-1;
				 int num3 = num*2;
				 
				 if(num1 == M) caseCnt++;
				 if(num2 == M) caseCnt++;
				 if(num3 == M) caseCnt++;
				 
				 if(min<= num1 && num1 <=max && !visit[num1]) {
					 q.offer(num1);
					 visit[num1] = true;
				 }
				 
				 if(min<= num2 && num2 <=max && !visit[num2]) {
					 q.offer(num2);
					 visit[num2] = true;
				 }
				 
				 if(min<= num3 && num3 <=max && !visit[num3]) {
					 q.offer(num3);
					 visit[num3] = true;
				 }
			 }
			 minTime++;
			 if(caseCnt != 0) break;
		 }
		 
		 int[] result = new int[2];
		 result[0] = minTime;
		 result[1] = caseCnt;
		 return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if(N==M) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		int[] result = bfs(N,M);
		for(int r : result) System.out.println(r);
	}
}

/*
 * int[] time = new int[100001];
int minTime = Integer.MAX_VALUE;
int count = 0;

Queue<Integer> q = new ArrayDeque<>();
q.offer(N);
time[N] = 1; // 1초부터 시작 (0으로 두면 방문 안 한 것과 겹치기 때문에)

while(!q.isEmpty()) {
    int cur = q.poll();

    if(cur == M) {
        if(time[cur] - 1 < minTime) {
            minTime = time[cur] - 1;
            count = 1;
        } else if(time[cur] - 1 == minTime) {
            count++;
        }
        continue;
    }

    for(int next : new int[]{cur+1, cur-1, cur*2}) {
        if(0 <= next && next <= 100000) {
            if(time[next] == 0) {
                time[next] = time[cur] + 1;
                q.offer(next);
            } else if(time[next] == time[cur] + 1) {
                // 같은 시간에 도달할 수 있는 경로도 허용
                q.offer(next);
            }
        }
    }
}
*/
