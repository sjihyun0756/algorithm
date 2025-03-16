package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666_N과_M12 {
	
	static int[] arr;
	static int[] find;
	static StringBuilder sb = new StringBuilder();
	
	private static void permutation(int depth, int start) {
	    if (depth == find.length) {
	        for (int n : find) {
	            sb.append(n).append(" ");
	        }
	        sb.append("\n");
	        return;
	    }
	    int prev = -1;
	    for (int i = start; i < arr.length; i++) {
	    	if(prev == arr[i]) continue;
	        find[depth] = arr[i];
	        permutation(depth + 1, i);
	        prev = arr[i]; 
	    }
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		find = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		permutation(0,0);
		System.out.println(sb);
	}
}