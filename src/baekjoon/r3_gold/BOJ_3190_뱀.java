package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_3190_뱀 {
	
	private static int N, currentDir;
	private static boolean[][] board;
	private static boolean[][] visit;
	private static int endTime = 0;
	private static Deque<int[]> snake;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	
	
	private static boolean moveSnake(int time, char dir) {
		int t = 0;
		while(t++ < time) {
			int[] head = snake.peekFirst();
			int nx = dx[currentDir] + head[0];
			int ny = dy[currentDir] + head[1];
			
			if(0<= nx && nx < N && 0<= ny && ny < N && !visit[nx][ny]) {
				if(board[nx][ny]) board[nx][ny] = false; //사과 
				else {
					int[] tail = snake.pollLast(); // 꼬리 제거
					visit[tail[0]][tail[1]] = false;
				}
				snake.offerFirst(new int[] {nx, ny});
				visit[nx][ny] = true;
				
			}else {
				endTime += t;
				return false;
			}
		}
		
		currentDir = (dir == 'L') ? (currentDir + 3) % 4 : (currentDir + 1) % 4;
		endTime += (--t);
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		board = new boolean[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int appleX = Integer.parseInt(st.nextToken()) -1;
			int appleY = Integer.parseInt(st.nextToken()) -1;
			
			board[appleX][appleY] = true;
		}
		
		snake = new ArrayDeque<>(); 
		snake.add(new int[] {0,0}); // 0 : → | 1 : ↓ | 2 : ← | 3 : ↑
		visit[0][0] = true;
		currentDir = 0;
		
		int L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			
			if(!moveSnake(time - endTime, dir)) {
				System.out.println(endTime);
				return;
			}
		}
		
		moveSnake(Integer.MAX_VALUE, 'D');
		System.out.println(endTime);
	}
}
