package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14235_크리스마스_선물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=N; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if(a==0) {
				if(pq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				while(st.hasMoreTokens()) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}//
}
