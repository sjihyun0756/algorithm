package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2930_힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			int N = Integer.parseInt(br.readLine());
			int[] heap = new int[N+1];
			int idx = 1;
			
			for(int i=1; i<= N ; i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				if(op.equals("1")) {
					int p = idx;
					heap[idx++] = Integer.parseInt(st.nextToken());
					while(p>=2) {
						if(heap[p]>heap[p/2]) {
							int tmp = heap[p];
							heap[p] = heap[p/2];
							heap[p/2] = tmp;
							p /=2;
						}else break;
					}
					System.out.println(Arrays.toString(heap));
				}else {
					if(heap[1] == 0) sb.append(-1+" ");
					else {
						sb.append(heap[1]+" ");
						int p =1;		
						while(p<=N/2) {
							heap[p] = heap[p*2+1] >= heap[p*2] ? heap[p*2+1] : heap[p*2];
							p = heap[p*2+1] >= heap[p*2] ? p*2+1 : p*2;
						}
						heap[p] = 0;
					}
					System.out.println(Arrays.toString(heap));
					idx--;
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}//
	}
}
