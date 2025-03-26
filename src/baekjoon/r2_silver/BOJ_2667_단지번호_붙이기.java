/*
package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_2667_단지번호_붙이기 {
	
	static int N;
    static boolean[][] field;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static int dfs(int x, int y) {
        field[x][y] = false; 
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && field[nx][ny]) {
                count += dfs(nx, ny);
            }
        }
        return count;
    }
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        field = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                field[i][j] = (line.charAt(j) == '1');
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j]) {
                    result.add(dfs(i, j));
                }
            }
        }

        sb.append(result.size()).append("\n");
		Collections.sort(result);
		for(int a : result) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
    }
}

*/

package baekjoon.r2_silver;

import java.io.*;
import java.util.*;

public class BOJ_2667_단지번호_붙이기 {
	
	static int N;
    static boolean[][] field;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static int dfs(int x, int y) {
        field[x][y] = false; 
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && field[nx][ny]) {
                count += dfs(nx, ny);
            }
        }
        return count;
    }
	
    private static int bfs(int i, int j) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {i,j});
        field[i][j] = false; 
        int count = 1;
        
        while(!q.isEmpty()) {
        	int[] points = q.poll();
        	int x = points[0], y = points[1];
        	
        	for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && field[nx][ny]) {
                	q.offer(new int[] {nx,ny});
                	field[nx][ny] = false;
                    count++;
                }
            }
        }
        return count;
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        field = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                field[i][j] = (line.charAt(j) == '1');
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        sb.append(result.size()).append("\n");
		Collections.sort(result);
		for(int a : result) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
    }
}