package swea.unsolved;

import java.io.*;
import java.util.*;

public class SWEA_파핑파핑_지뢰찾기 {

	static int N;
	static char[][] field;
	static int[][] numField;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Set<int[]> zeroPoint;
	static int cntNotZero;
	
	private static void bfs(int i, int j) {
		
	}

	private static void setField(int i, int j) {
		int cntLandMine =0;
		
		for(int d = 0; d<8; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(0<= nx && nx < N && 0 <= ny && ny < N) {
				if(field[nx][ny] == '*') cntLandMine++;
			}
		}
		numField[i][j] = cntLandMine;
		if(numField[i][j] == 0) {
			zeroPoint.add(new int[] {i,j});
		}else cntNotZero++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		nextTC:
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			N = Integer.parseInt(br.readLine());
			field = new char[N][N];
			numField = new int[N][N];
			cntNotZero = 0;
			zeroPoint = new HashSet<>();
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					field[i][j] = input.charAt(j);

				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(field[i][j] == '.') setField(i,j);
				}
			}
			
			if(zeroPoint.size() == 0) {
				sb.append(cntNotZero);
				continue nextTC;
			}
			
			for(int[] zero : zeroPoint) {
				bfs(zero[0], zero[1]);
			}
			
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(field[i]));
//			}
//			System.out.println("_____________________________");
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(numField[i]));
//			}
//			System.out.println("_____________________________");
//			for(int[] n : zeroPoint) {
//				System.out.println(n[0] + ":::::" + n[1]);
//			}
		}
	}
}
