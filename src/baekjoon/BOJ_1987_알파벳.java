package baekjoon;
//



// 중복 알파벳 만나면 종료하고
// 방문 해제를 해줘야함

// 백트래킹이므로 dfs이용해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ_1987_알파벳 {
	//연습
	static int R;
	static int C;
	static char[][] arr; 
	static boolean[][] visit;
	static List<Character> list; //방문한 알파벳 넣는 리스트
	static Deque<int[]> deque;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int cnt=1;
	static List<Integer> cntList;
	
	static Stack<Integer> stack;

	
	//일단 알파벳 없이 구현
	private static void dfs(int x, int y) {
		if(visit[x][y]) {
			System.out.println(visit[x][y]+"  백!!");
			return;
		}
		
		visit[x][y] = true;
		
		for(int d = 0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0<=nx && nx < R && 0<= ny && ny < C && visit[nx][ny] ==false) {
				list.add(arr[nx][ny]);
				System.out.print(arr[nx][ny]+ " ");
				System.out.println(list);
				cnt++;
				dfs(nx,ny);
				//백
				cntList.add(cnt);
				System.out.println(cnt);
				visit[nx][ny] = false;
				list.remove(arr[nx][ny]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
				
		arr = new char[R][C];
		visit = new boolean[R][C];
		list = new ArrayList<>();
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j= 0; j<C; j++) {
				arr[i][j] = input.charAt(j);
			}
		} //배열 받고
		
		stack = new Stack<Integer>();
		stack.push(0,0);
		
		cntList = new ArrayList<>();
//		bfs();
		
		//System.out.println("A에서부터 시작");
		dfs(0,0);
	}//

}
