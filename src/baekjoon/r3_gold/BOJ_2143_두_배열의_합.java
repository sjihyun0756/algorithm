package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_2143_두_배열의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr1[i] = num;
			map1.put(num, map1.getOrDefault(num, 0) +1);
		}
		
		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr2[i] = num;
			map2.put(num, map2.getOrDefault(num, 0) +1);
		}
		
		int size = 2;
		while(size <= N) {
			int sum = 0;
			for(int i=0; i<size; i++) {
				sum+= arr1[i];
			}
			map1.put(sum, map1.getOrDefault(sum, 0) +1);
			
			for(int i=size; i<N; i++) {
				sum += arr1[i];
				sum -= arr1[i-size];
				map1.put(sum, map1.getOrDefault(sum, 0) +1);
			}
			size++;
		}
		
		size = 2;
		while(size <= M) {
			int sum = 0;
			for(int i=0; i<size; i++) {
				sum+= arr2[i];
			}
			map2.put(sum, map2.getOrDefault(sum, 0) +1);
			
			for(int i=size; i<M; i++) {
				sum += arr2[i];
				sum -= arr2[i-size];
				map2.put(sum, map2.getOrDefault(sum, 0) +1);
			}
			size++;
		}
		
		long cnt = 0;
		for(int num : map1.keySet()) {
			int target = T - num;
			if(map2.containsKey(target)) cnt += (long) map1.get(num) * map2.get(target);
		}
		System.out.println(cnt);
	}
}
