package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {
	static int[][] field = new int[101][101];
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int line = 0;
	
	private static void dfs(int x, int y) {
        field[x][y] = -1; 

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 1 || nx > 100 || ny < 1 || ny > 100 || field[nx][ny] == 0) {
            	line++;
            } else if (field[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int col = c; col<c+10; col++) {
				for(int row = r; row<r+10; row++) {
					field[col][row] = 1;
				}
			}
		}
		
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(field[i][j] ==1) {
					dfs(i, j);
				}
			}
		}
		System.out.println(line);
	}
}
