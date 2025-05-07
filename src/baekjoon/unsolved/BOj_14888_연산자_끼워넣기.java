package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOj_14888_연산자_끼워넣기 {
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int N;
	static int[] nums;
	static char[] operator;
	static char[] setOperator;
	static boolean[] visit;
	
	private static void calculate(char[] oper) {
		
		int sum = nums[0];
		for(int i=1; i<N; i++) {
			int num = nums[i];
			char op = oper[i-1];
			
			if(op=='+') {
				sum += num;
			}else if(op=='-') {
				sum -= num;
			}else if(op=='*') {
				sum *= num;
			}else {// op == '/'
				if(sum <0) {
					int tempSum = -sum;
					tempSum /= num;
					sum = -tempSum;
				}else { //sum>=0
					sum /= num;
				}
			}
		}
		min = Math.min(min, sum);
		max = Math.max(max, sum);
	}
	
	private static void findResult(int depth) {
		if(depth == N-1) {
			calculate(setOperator);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			setOperator[depth] = operator[i];
			findResult(depth+1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		char[] oper = {'+', '-', '*', '/'};
		operator = new char[N-1];
		setOperator = new char[N-1];
		visit = new boolean[N-1];
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			int t = Integer.parseInt(st.nextToken());
			for(int j=0; j<t; j++) {
				operator[idx++] = oper[i];
			}
		} // + - * /
		findResult(0);
		System.out.println(max);
		System.out.println(min);
	}
}
