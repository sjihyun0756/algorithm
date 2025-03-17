package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String,Integer> map = new HashMap<>();
		Set<String> set = new TreeSet<>();
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			if(map.get(input) != null) set.add(input);
		}
		
		System.out.println(set.size());
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			sb.append(iter.next()).append("\n");
		}
		System.out.println(sb);
	}
}
