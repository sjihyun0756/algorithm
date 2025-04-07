package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_1868_파핑파핑_지뢰찾기 {
	static int N;
	static char[][] field;
	static int[][] numField;
	static boolean[][] visit;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int cntLandMine;

	private static void setField(int i, int j) {
		int cnt = 0;
		for(int d=0; d<8; d++) {
			int nx=i+dx[d], ny=j+dy[d];
			if(0<=nx && nx<N && 0<=ny && ny<N && field[nx][ny]=='*') cnt++;
		}
		numField[i][j]=cnt;
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q=new ArrayDeque<>();
		q.offer(new int[] {i,j});
		visit[i][j]=true;
		int cnt = 1;

		while(!q.isEmpty()) {
			int[] points=q.poll();
			int x=points[0], y=points[1];

			if(numField[x][y]!=0) continue;

			for(int d=0; d<8; d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(0<=nx && nx<N && 0<=ny && ny<N && !visit[nx][ny] && field[nx][ny]=='.') {
					visit[nx][ny]=true;
					q.offer(new int[]{nx,ny});
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			field=new char[N][N];
			numField=new int[N][N];
			visit=new boolean[N][N];
			cntLandMine=0;

			for(int i=0; i<N; i++) {
				String input=br.readLine();
				for(int j=0; j<N; j++) {
					field[i][j]=input.charAt(j);
					if(field[i][j]=='*') cntLandMine++;
				}
			}

			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					if(field[i][j]=='.') setField(i,j);

			int totalEmpty = N*N - cntLandMine;
			int visitedEmpty = 0;
			int result=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(field[i][j]=='.' && numField[i][j]==0 && !visit[i][j]) {
						visitedEmpty += bfs(i,j);
						result++;
					}
				}
			}
			
			result += (totalEmpty - visitedEmpty);
			sb.append("#"+tc+" "+result+"\n");
		}
		System.out.println(sb);
	}
}
