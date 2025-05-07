package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1062_가르침 {
	
	static int N;
	static String[] input;
	static int num = 0;
	static char[] base = {'a','n','t','i','c'};
	
	private static int cntMax(int num) {
		int standard = 0;
		for(int i=0; i<5; i++) {
			standard |= (1<<base[i]);
		}
		standard |= num;
		
		int cnt = 0,vmissing = 0;
		for(int i=0; i<N; i++) {
			int check = standard;
			for(int j=0; j<input[i].length(); j++) {
				if(chck )
			}
		}
		return 0;
	}
	
	private static void pickAlphabet(int missing, int available, int depth){
		if(depth == available) {
			
			
			
			return;
		}
		
		for(int i=1; i<=26; i++) {
			if((missing & (1<<i)) == 0) continue;
			num |= (1<<i);
			pickAlphabet(missing,available, depth+1);
			num &= ~(1<<i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0, check = 0, missing = 0;
		input = new String[N];
		for(int i=0; i<N; i++) {
			check = 0;
			input[i] = br.readLine();
			for(int j=0; j<input[i].length(); j++) {
				int alphabet = input[i].charAt(j)-'a' + 1;
				check |= (1<<alphabet);
				missing |= (1<<alphabet);
			}
			if(Integer.bitCount(check) <= K) cnt++;
		}
		
		int result = 0;
		if(cnt <= K) result = cnt;
		else if(K<cnt) {
			int missCnt = Integer.bitCount(missing)-5; //n
			int available = K-5;  //m
			System.out.println(missCnt);
			System.out.println(available);
			pickAlphabet(missing, available, 0);
		}
		System.out.println(result);
	}
}
