package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_1248_공통조상 {

	static List<Integer>[] graph;
	static Set<Integer> findCommon = new LinkedHashSet<>();
	static Deque<Integer> deque;
	static boolean[] visit;
	static StringBuilder sb;

	/*
	 * private static void bfs(int target1, int target2) { deque = new
	 * ArrayDeque<>(); visit[target1] = true; deque.offerLast(target1);
	 * findCommon.add(target1);
	 * 
	 * breakpoint1: while(!deque.isEmpty()) { int point = deque.pollFirst();
	 * 
	 * for(int v : graph[point]) { if(v==1) { //탑노드 findCommon.add(v); break
	 * breakpoint1; }
	 * 
	 * if(!visit[v]) { findCommon.add(v); System.out.println(v); deque.offerLast(v);
	 * visit[v] = true; } } }
	 * 
	 * deque.clear(); visit[target2] = true; deque.offerLast(target2);
	 * 
	 * 
	 * System.out.println("---------------------------");
	 * 
	 * int findPoint =0; if(findCommon.contains(target2)) { //target2가 애초에 target1의
	 * 조상일 경우 sb.append(target2); findPoint=target2; return; }else {
	 * findCommon.add(target2); }
	 * 
	 * 
	 * breakpoint2: while(!deque.isEmpty()) { int point = deque.pollFirst(); for(int
	 * v : graph[point]) {
	 * 
	 * 
	 * if(findCommon.contains(v)) { findPoint=v; sb.append(v); break breakpoint2;
	 * }else { if(!visit[v]) { findCommon.add(v); System.out.println(v);
	 * deque.offerLast(v); visit[v] = true; } } } }
	 */
	private static void bfs(int target1, int target2) {
		deque = new ArrayDeque<>();
		visit[target1] = true;
		deque.offerLast(target1);
		findCommon.add(target1);
		//contains 빼
		//한번에 탐색할 수 있는 방법 찾아보기
		breakpoint1: 
			while (!deque.isEmpty()) {
			int point = deque.pollFirst();

			for (int v : graph[point]) {
				if (v == 1) { // 탑노드
					findCommon.add(v);
					break breakpoint1;
				}

				if (!visit[v]) {
					findCommon.add(v);
					System.out.println(v);
					deque.offerLast(v);
					visit[v] = true;
				}
			}
		}

		deque.clear();
		visit[target2] = true;
		deque.offerLast(target2);

		System.out.println("---------------------------");

		int findPoint = 0;
		if (findCommon.contains(target2)) { // target2가 애초에 target1의 조상일 경우
			sb.append(target2);
			findPoint = target2;
			return;
		} else {
			findCommon.add(target2);
		}

		breakpoint2: while (!deque.isEmpty()) {
			int point = deque.pollFirst();
			for (int v : graph[point]) {

				if (findCommon.contains(v)) {
					findPoint = v;
					sb.append(v);
					break breakpoint2;
				} else {
					if (!visit[v]) {
						findCommon.add(v);
						System.out.println(v);
						deque.offerLast(v);
						visit[v] = true;
					}
				}
			}
		}

//		deque.clear();
//		visit = new boolean[visit.length];
//		visit[findPoint] = true;
//		deque.offerLast(findPoint);
//		
//		while(!deque.isEmpty()) {
//			int point = deque.pollFirst();
//			for(int v : graph[point]) {
//				if(findCommon.contains(v)) {
//					findPoint=v;
//					sb.append(v);
//					break breakpoint2;
//				}
//				
//				if(!visit[v]) {
//					System.out.println(v);
//					deque.offerLast(v);
//					visit[v] = true;
//				}
//			}
//		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// V E 정점1 정점2
			st = new StringTokenizer(br.readLine()); // 13 12 8 13
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());

			graph = new List[V + 1];
			visit = new boolean[V + 1];
			for (int i = 0; i < V + 1; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				// graph[v].add(u);
			}

			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			bfs(target1, target2);
			System.out.println(Arrays.toString(graph));
			System.out.println(findCommon);
			System.out.println(sb);
		}
	}
}
