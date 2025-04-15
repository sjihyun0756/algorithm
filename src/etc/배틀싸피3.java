package etc;

import java.util.*;
import java.io.*;


public class 배틀싸피3 {
	
	private static int N, heart, startX, startY;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	private static Node[][][] parent;
	private static List<int[]> path;
	
	private static class Node{
		int x, y, h;
		public Node(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	
	private static void bfs() {
		N = mapData.length;
		parent = new Node[N][N][heart+1];
		
		outer:
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(mapData[i][j].equals("A"));{
					startX = i;
					startY = j;
					break outer;
				}
			}
		}
		
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(startX, startY, heart));
		parent[startX][startY][heart] = new Node(-1,-1,-1);
		
		while(!q.isEmpty()) {
			
			
			
			
			
		}
	}
	
	
	public static void main(String[] args) {
		String gameData = """
10 10 2 1 1
G G G G R G G G R X
G G R G R G R G G G
R G R G G G R G R G
G G R T T T T G G R
G R T T G R R G G G
G G T T G R G G G G
R G R G G R G R G R
A G R G G R G G G G
F G R G G W W W W G
G G G G G G G G G G
A 100 R 1 1
H 10
X 10
SRKKCVJJRWP
		""";
		parseData(gameData);
		System.out.println();
	}

	// 입력 데이터를 파싱하여 변수에 저장
    private static String[][] mapData; // 맵 정보
    private static Map<String, String[]> allies = new HashMap<>(); // 아군 정보
    private static Map<String, String[]> enemies = new HashMap<>(); // 적군 정보
    private static String[] codes; // 암호문 정보	
    private static void parseData(String gameData) {
        // 입력 데이터를 행으로 나누기
        String[] rows = gameData.split("\n");
        System.out.println(Arrays.toString(rows));
        int index = 0;

        String[] header = rows[index++].split(" ");
        int h = Integer.parseInt(header[0]); // 맵의 세로 크기
        int w = Integer.parseInt(header[1]); // 맵의 가로 크기
        int a = Integer.parseInt(header[2]); // 아군의 수
        int e = Integer.parseInt(header[3]); // 적군의 수
        int c = Integer.parseInt(header[4]); // 암호문의 수

        // 기존의 맵 정보를 초기화하고 다시 읽어오기
        mapData = new String[h][w];
        for (int i = 0; i < h; i++) {
            mapData[i] = rows[index++].split(" ");
        }

        // 기존의 아군 정보를 초기화하고 다시 읽어오기
        allies.clear();
        for (int i = 0; i < a; i++) {
            String[] parts = rows[index++].split(" ");
            allies.put(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
        }
        
        String[] AInfo = allies.get("A");
        heart = Integer.parseInt(AInfo[2]) + Integer.parseInt(AInfo[3]);

        // 기존의 적군 정보를 초기화하고 다시 읽어오기
        enemies.clear();
        for (int i = 0; i < e; i++) {
            String[] parts = rows[index++].split(" ");
            enemies.put(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
        }

        // 기존의 암호문 정보를 초기화하고 다시 읽어오기
        codes = new String[c];
        for (int i = 0; i < c; i++) {
            codes[i] = rows[index++];
        }
        
        
    }
}