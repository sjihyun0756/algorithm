package swea.unsolved;

import java.io.*;
import java.util.*;

public class SWEA_2105_디저트_카페 {
	
	static int N;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	static int[][] cafe;
	static boolean[][] visitNode;
	static boolean[] visitDessert;
	static int startI;
	static int startJ;
	static int maxLen;

	private static void dfs(int i, int j, int cnt, int dir) {
//		System.out.println(cafeNode);
		for(int d = dir; d<4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if (nx == startI && ny == startJ && cnt >= 4) {
				//System.out.println("걸렸다~~~~~~~~~~~~~~~~~~~~~~~~~~");
                maxLen = Math.max(maxLen, cnt);
                return;
            }

			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                int dessert = cafe[nx][ny];

                if (!visitNode[nx][ny] && !visitDessert[cafe[nx][ny]]) {
                	visitNode[nx][ny] = true;
                	visitDessert[cafe[nx][ny]] = true;
                    dfs(nx, ny, cnt + 1, d);
                    visitNode[nx][ny] = false;
                    visitDessert[cafe[nx][ny]] = false;
                }
            }
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			N = Integer.parseInt(br.readLine());
			maxLen= -1;
			cafe = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}//
			
			for(int i=0; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					//System.out.println("탐색 시작 ~~~~ " + i + " :::: " + j);
					
					visitNode = new boolean[N][N];
					visitDessert = new boolean[101];
					
					visitNode[i][j] = true;
					visitDessert[cafe[i][j]]= true;
					startI = i;
					startJ = j;
					
					dfs(i, j, 1, 0);
//					System.out.println(maxLen);
				}
			}
			if(maxLen != -1) sb.append(maxLen).append("\n");
			else sb.append(-1).append("\n");
		}
		System.out.println(sb);
	}
}
