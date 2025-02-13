package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IM대비5_봉사활동 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			System.out.println();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			
			
			st = new StringTokenizer(br.readLine());
			int[] score = new int[N];
			for(int i=0; i<N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(score);
			int maxScore = score[N-1];
			
			int[] cnt = new int[maxScore+1];
			for(int v : score) cnt[v]++;
			
			int d = 0; //서로 다른 점수 개수
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i] != 0) d++;
			}
			
			
			
			int result = 0;
			if(d==3) {
				if(min<cnt[0] && cnt[0]<max && min<cnt[cnt.length-1] && cnt[cnt.length-1]<max) {
					result = cnt[cnt.length-1]-cnt[0];
				}else {
					result = -1;
				}
			}else {
				System.out.println("다른 케이스");
			}
			
//			//일단 누적합 배열 따로 안 만듦
//			for(int i=1; i<cnt.length; i++) cnt[i] += cnt[i-1];

			System.out.println(result);
			
			
			
			
			
			
			
			
			
			
		} //tc for문
		
	}

}
