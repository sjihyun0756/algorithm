package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3015_오아시스_재결합 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(s.isEmpty()) s.push(num);
			else if(s.peek() < num) {
				cnt+= s.size();
				while(!s.isEmpty() && s.peek()<num) {
					s.pop();
				}
				s.push(num);
			}
			else if(s.peek() >= num) {
				cnt += s.size();
				s.push(num);
			}
		}
		System.out.println(cnt);
	}
}
