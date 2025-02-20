package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1248_공통조상 {
	
	static List<Integer>[] graph;
	static List<Integer> forTarget1;
	static List<Integer> forTarget2;
	
	
	private static void 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			//V E 정점1 정점2 
			st = new StringTokenizer(br.readLine()); // 13 12 8 13
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			graph = new List[V+1];
			for(int i=0; i<V+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				graph[u].add(v); //반대로 넣어줌
			}
			
			System.out.println(Arrays.toString(graph));
		} 
	}
}
