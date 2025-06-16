/* 시간초과 뜸 
package baekjoon.r4_platinum;

import java.io.*;
import java.util.*;

public class BOJ_11003_최솟값_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			    (e1, e2) -> {
			        if (e1[0] != e2[0]) return Integer.compare(e1[0], e2[0]);
			        return Integer.compare(e1[1], e2[1]);
			    }
			);
		
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<N; idx++) {
			int num = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {num, idx});
			
			int left = idx-L+1 >= 0 ? idx-L+1 : 0;
			int minIdx = pq.peek()[1];
			
			if(left <= minIdx) sb.append(pq.peek()[0] + " ");
			else {
				while(!pq.isEmpty()) {
					pq.poll();
					
					if(pq.isEmpty()) break;
					
					minIdx = pq.peek()[1];
					if(left <= minIdx) break;
				}
				if (!pq.isEmpty()) sb.append(pq.peek()[0] + " ");
			}
		}
		System.out.println(sb);
	}
}

*/


package baekjoon.r4_platinum;

import java.io.*;
import java.util.*;

public class BOJ_11003_최솟값_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Deque<int[]> dq = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<N; idx++) {
			int num = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && dq.peekLast()[1] > num) {
				dq.pollLast();
			}
			dq.offerLast(new int[] {idx, num});
			
			int left = idx-L+1;
			if(dq.peek()[0] < left ) dq.pollFirst();
			
			sb.append(dq.peekFirst()[1] + " ");
		}
		System.out.println(sb);
	}
}
