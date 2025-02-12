package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_1874_스택_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //8
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		List<String> result = new ArrayList<>();
		
		//4 3 6 8 7 5 2 1
		int num =1;
		boolean success = true;
		for(int i=0; i<n; i++) {
			if(num <= arr[i]) {
				while(num <= arr[i]) {
					stack.push(num++);
					result.add("+");
				}
				stack.pop();
				result.add("-");
			}else {
				int check = stack.pop();
				result.add("-");
				
				if(check>arr[i]) {
					System.out.println("NO");
					success = false;
					break;					
				}
			}
		}
		if(success) {
			for(String s : result) {
				System.out.println(s);
			}
		}
	}
}
