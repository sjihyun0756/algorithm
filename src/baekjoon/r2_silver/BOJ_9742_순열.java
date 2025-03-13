package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9742_순열 {
	static char[] arr;
	static char[] num;
	static boolean[] visit;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	
	private static void permutation(int depth) {
		if(depth==num.length) {
			cnt--;
			if(cnt==0) {
				for(int i=0; i<num.length; i++) {
					sb.append(num[i]);
				}
			}
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visit[i]) continue;
			num[depth] = arr[i];
			visit[i] = true; 
			permutation(depth+1);
			visit[i] = false; 
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			
			st = new StringTokenizer(line);
			String input = st.nextToken();
			arr = new char[input.length()];
			num = new char[input.length()];
			visit = new boolean[input.length()];
			for(int i=0; i<arr.length; i++) {
				arr[i] = input.charAt(i);
			}
			cnt = Integer.parseInt(st.nextToken());
			sb.append(input+" "+cnt+" "+"="+" ");
			
			int factorial = 1;
			for(int i=1; i<=input.length(); i++) {
				factorial *= i;
			}
			
			if(factorial<cnt) {
				System.out.println(sb.append("No permutation"));
				sb.setLength(0);
				continue;
			}
			permutation(0);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
