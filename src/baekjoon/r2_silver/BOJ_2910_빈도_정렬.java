package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BOJ_2910_빈도_정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int keyNum = Integer.parseInt(st.nextToken());
			map.put(keyNum, map.getOrDefault(keyNum, 0)+1);
		}
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue() !=o2.getValue()) return Integer.compare(o2.getValue(), o1.getValue());
				return 0;
			}
		});
		
		for(Map.Entry<Integer, Integer> m : list) {
			int cnt = m.getValue();
			for(int i=0; i<cnt; i++) {
				sb.append(m.getKey()).append(" ");
			}
		}
		
		System.out.println(sb);
		
	}
}
