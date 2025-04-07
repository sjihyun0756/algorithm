package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_12891_DNA_비밀번호 {
	
	static int[] mustNeed;
	
	private static boolean isPassword(int[] check) {
		for(int i=0; i<check.length; i++) {
			if(mustNeed[i] > check[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());  //9
		int P = Integer.parseInt(st.nextToken())-1;  //8-1 = 7
		
		char[] input = br.readLine().toCharArray();
		
		mustNeed = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			mustNeed[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int[] check = new int[4];
		
		for(int i=0; i<=P; i++) {//first time
			char c = input[i];
			if(c == 'A') check[0]++;
			else if(c=='C') check[1]++;
			else if(c=='G') check[2]++;
			else check[3]++;
		}
		if(isPassword(check)) cnt++;
		
		
		for(int i=1; i<S-P; i++) {
			char c = input[i-1];
			if(c == 'A') check[0]--;
			else if(c=='C') check[1]--;
			else if(c=='G') check[2]--;
			else check[3]--;
			
			c = input[i+P];
			if(c == 'A') check[0]++;
			else if(c=='C') check[1]++;
			else if(c=='G') check[2]++;
			else check[3]++;
			if(isPassword(check)) cnt++;
		}
		System.out.println(cnt);
	}
}
