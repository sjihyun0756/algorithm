package baekjoon.r3_gold;

import java.io.*;
import java.util.*;;

public class BOJ_28706_럭키_세븐 {
	
	private static Queue<Integer> q;
	private static boolean[] visit;
	
	private static void isLucky(char oper1, int num1, char oper2, int num2) {
		visit = new boolean[7];
		
		int size = q.size();
		for(int s = 0; s<size; s++) {
			int out = q.poll();
			int cal = 0;
			
			if(oper1 == '+') {
				cal = (out + num1) % 7;
				if(!visit[cal]) q.offer(cal);
			} else {
				cal = (out * num1) % 7 ;
				if(!visit[cal]) q.offer(cal);
			}
			visit[cal] = true;
			
			if(oper2 == '+') {
				cal = (out + num2) % 7;
				if(!visit[cal]) q.offer(cal);
			} else {
				cal = (out * num2) % 7 ;
				if(!visit[cal]) q.offer(cal);
			}
			visit[cal] = true;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			q = new ArrayDeque<>();
			q.offer(1);
			
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				char oper1 = st.nextToken().charAt(0);
				int num1 = Integer.parseInt(st.nextToken());
				char oper2 = st.nextToken().charAt(0);
				int num2 = Integer.parseInt(st.nextToken());
				
				isLucky(oper1, num1, oper2, num2);
			}
			
			boolean result = false;
			while(!q.isEmpty()) {
				int out = q.poll();
				if(out == 0) {
					result = true;
					break;
				}
			}
			sb.append(result ? "LUCKY" : "UNLUCKY").append("\n");
		}
		System.out.println(sb);
	}
}
