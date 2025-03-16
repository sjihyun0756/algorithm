package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1722_순열의_순서 {
	static int[] result;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> numList;

	private static int findPermutation(int depth, long target) {
		if(depth == result.length) {
			target--;
			if(target==0) {
				for(int n : result) {
					sb.append(n).append(" ");
				}
				return 0;
			}
			return (int)target;
		}
		
		for(int i=0; i<numList.size(); i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[depth] = numList.get(i);
			target = findPermutation(depth+1, target);
			visit[i] = false;
			if(target == 0) return 0;
		}
		return (int) target;
	}



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numList = new ArrayList<>();
		
		long[] factorial = new long[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
            numList.add(i);
        }

		StringTokenizer st = new StringTokenizer(br.readLine());
		int caseNum = Integer.parseInt(st.nextToken());

		switch (caseNum) {
		case 1:
			long target = Long.parseLong(st.nextToken());
			int[] cntArr = new int[N];
			int stopPoint =0;
			
            breakPoint:
            for (int i = N - 1; i >= 0; i--) {
                int cnt = 0;
                while (target > factorial[i]) { 
                    target -= factorial[i];
                    cnt++;
                }
                cntArr[N - 1 - i] = cnt; 
                stopPoint = N - i;
            }

            for (int i = 0; i < stopPoint; i++) {
                int n = numList.get(cntArr[i]);
                sb.append(n).append(" ");
                numList.remove(cntArr[i]); 
            }

            result = new int[N - stopPoint];
            visit = new boolean[N - stopPoint];
            findPermutation(0, target);
            System.out.println(sb);
            break;
            
		case 2: {
			int[] result = new int[N];
            for (int i = 0; i < N; i++) {
            	result[i] = Integer.parseInt(st.nextToken());
            }

            long order = 1;
            for (int i = 0; i < N; i++) {
                int index = numList.indexOf(result[i]); 
                order += index * factorial[N - 1 - i];
                numList.remove(index); 
            }
            sb.append(order);
            System.out.println(sb);
            break;
		}
		}
	}
}
