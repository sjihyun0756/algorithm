package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1717_집합의_표현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> setClass = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			setClass.put(i, i); 
		} // 본인집합
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int caseNum = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); //a가 작고, b가 큼
			if(a>b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			
			if(caseNum==0) {
				setClass.put(setClass.get(a), b); 
				for(int node : setClass.keySet()) {
					if(setClass.get(node) == a) {
						setClass.put(node, b);
					}
				}
			}else { //1일 경우
				System.out.println(setClass);
				if(a==b) sb.append("YES").append("\n"); 
				else {
					if(setClass.get(a) == b) {
						sb.append("YES").append("\n"); 
					}else sb.append("NO").append("\n"); 
				}
			}
		}
		System.out.println(sb);
	}//
}
