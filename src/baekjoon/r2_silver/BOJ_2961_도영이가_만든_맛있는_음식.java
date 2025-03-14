package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가_만든_맛있는_음식 {
	static int[] sour;
	static int[] bitter;
	static int[] sourResult;
	static int[] bitterResult;
	static int min;
	
	private static void findCombination(int depth, int last) {
		if(depth == sourResult.length) {
			int calSour = 1;
			int calBitter=0;
			for(int i=0; i<sourResult.length; i++) {
				calSour *= sourResult[i];
				calBitter += bitterResult[i];
			}
			
			int r = Math.abs(calSour-calBitter);
			min= Math.min(min, r);
			return;
		}
		
		for(int i=last+1; i<sour.length; i++) {
			sourResult[depth] = sour[i];
			bitterResult[depth] = bitter[i];
			findCombination(depth+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		sour = new int[N];   //곱 
		bitter = new int[N]; //합 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			sourResult = new int[i];
			bitterResult = new int[i];
			findCombination(0,-1);
		}
		System.out.println(min);
	}
 }