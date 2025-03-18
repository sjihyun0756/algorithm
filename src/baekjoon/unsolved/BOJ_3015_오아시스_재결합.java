package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3015_오아시스_재결합 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> s = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		long cnt = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			int hCnt = 1;
			
			while(!s.isEmpty() && s.peek()[0] < num) {
				cnt += s.peek()[1];
				s.pop();
			}
			
			if(!s.isEmpty()&&s.peek()[0] == num) {
				hCnt = s.peek()[1] +1;
				cnt += s.peek()[1];
				s.pop();
			}
			
			if(!s.isEmpty()) cnt++;
			
			s.push(new int[] {num, hCnt});
		}
		System.out.println(cnt);
	}
}
