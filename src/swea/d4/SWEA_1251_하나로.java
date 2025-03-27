package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_1251_하나로 {
	
	static int[] node;
	
	static class Edge{
		int from, to;
		double cost;
		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	private static int findNode(int num) {
		if(node[num] == num) return num;
		return node[num] = findNode(node[num]);
	}
	
	private static boolean unionFind(int from, int to) {
		int rootFrom = findNode(from);
		int rootTo = findNode(to);
		
		if(rootFrom == rootTo) return false;
		if(rootFrom < rootTo) node[rootTo] = rootFrom;
		else node[rootFrom] = rootTo;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			int N = Integer.parseInt(br.readLine());
		
			int idx = 0;
			int[] x = new int[N];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				x[idx++] = Integer.parseInt(st.nextToken());
			}
			idx = 0;
			int[] y = new int[N];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				y[idx++] = Integer.parseInt(st.nextToken());
			}
			
			double eCost = Double.parseDouble(br.readLine());
			
			int len = idx;
			node = new int[len];
			Arrays.setAll(node, i->i);
			List<Edge> edges = new ArrayList<>();
			
			for (int i = 0; i < len - 1; i++) {
			    for (int j = i + 1; j < len; j++) {
			        long dx = (long) x[i] - x[j];
			        long dy = (long) y[i] - y[j];
			        long dist2 = dx * dx + dy * dy;
			        double cost = dist2 * eCost;
			        edges.add(new Edge(i, j, cost));
			    }
			}
			edges.sort((e1, e2) -> Double.compare(e1.cost, e2.cost));
			int cnt = 0;
			double totalCost = 0;
			for(Edge e : edges) {
				if(unionFind(e.from, e.to)) {
					totalCost += e.cost;
					cnt++;
					if(cnt == N-1) break;
				}
			}
			sb.append(Math.round(totalCost)).append("\n");
		}
		System.out.println(sb);
	}
}