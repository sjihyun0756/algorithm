package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) s.pop();
			else s.push(num);
		}
		
		while(!s.isEmpty()) {
			sum += s.pop();
			
		}
		System.out.println(sum);
	}
}
