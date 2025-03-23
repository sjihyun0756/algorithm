package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_4195_친구_네트워크 {
	
	static int[] friend;
	static int[] size;
	
	private static int findNode(int num) {
		if(friend[num] == num) return num;
		return friend[num] = findNode(friend[num]);
	}

	private static void union(int num1, int num2) {
		int root1 = findNode(num1);
		int root2 = findNode(num2);
		
		if (root1 == root2) return;
		
		if(root1 < root2) {
			friend[root2] = root1;
			size[root1] += size[root2];
		}
		else {
			friend[root1] = root2;
			size[root2] += size[root1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			Map<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			String[][] input = new String[N][2];
			
			int idx = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				
				input[i][0] = str1;
				input[i][1] = str2;
				
				if(map.get(str1) == null) map.put(str1, idx++);
				if(map.get(str2) == null) map.put(str2, idx++);
			}
			
//			System.out.println(map);
//			System.out.println(Arrays.deepToString(input));
			friend = new int[idx];
			size = new int[idx];
			Arrays.setAll(friend, i -> i);
			Arrays.fill(size, 1);
			
//			System.out.println(Arrays.toString(friend));
			for (int i = 0; i < N; i++) {
				int num1 = map.get(input[i][0]);
				int num2 = map.get(input[i][1]);

				union(num1, num2);
				sb.append(size[findNode(num1)]).append("\n");
			}
		} // tc
		System.out.println(sb);
	}
}
