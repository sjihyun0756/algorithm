package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_9019_DSLR {
	
	static List<Character> list;
	static int end;
	
	private static int change(int num, int caseNum) {
		
		char[] numArr = new char[4];
		String strNum = String.valueOf(num);
		int len = strNum.length();
		int needZero = 4-len;
		
		for(int i=0; i<needZero; i++) {
			numArr[i] = '0';
		}
		
		for(int i=needZero; i<4; i++) {
			numArr[i] = strNum.charAt(i-needZero);
		}
		
		if(caseNum ==3) {
			char tmp = numArr[0];
			for(int i=0; i<3; i++) {
				numArr[i] = numArr[i+1];
			}
			numArr[3] = tmp;
			
			String result = "";
			for(int i=0; i<4; i++) {
				result += numArr[i];
			}
			return Integer.parseInt(result);
		}else {
			char tmp = numArr[3];
			for(int i=1; i<4; i++) {
				numArr[i] = numArr[i-1];
			}
			numArr[0] = tmp;
			
			String result = "";
			for(int i=0; i<4; i++) {
				result += numArr[i];
			}
			return Integer.parseInt(result);
		}
	}
	
	private static void bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		Set<Integer> set = new HashSet<>();
		q.offer(new int[] {start,0});
		set.add(start);
		
		while(!q.isEmpty()) {
			int[] out = q.poll();
			int num = out[0];
			
			int case1 = num*2;
			int case2 = num==0 ? 9999 : num-1;
			int case3 = change(num,3);
			int case4 = change(num,4);
			
			
			
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			//숫자 정리하는 거 나중에

			bfs(start);
		}
		System.out.println(sb);
	}
}
