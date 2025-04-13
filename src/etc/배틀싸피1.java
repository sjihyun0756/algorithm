package etc;

import java.util.*;

public class 배틀싸피1 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N, heart, startX, startY;
	static List<int[]> paths;
	static Node[][][] parents;
	
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
		parents = new Node[N][N][heart+1];
		
		outer:
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(mapData[i][j].equals("A")) {
					startX=i;
					startY=j;
					break outer;
				}
			}
		}
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(startX, startY, heart));
		parents[startX][startY][heart] = new Node(-1,-1,-1);
		
		while(!q.isEmpty()) {
			Node out = q.poll();
			int x = out.x, y = out.y, h = out.h;
			
			if(mapData[x][y].equals("X")) {
				makePathList(x,y,h);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if((mapData[nx][ny].equals("G") || mapData[nx][ny].equals("X")) && parents[nx][ny][h] == null) {
					parents[nx][ny][h] = new Node(x, y, h);
					q.offer(new Node(nx, ny, h));
				}else if(mapData[nx][ny].equals("T") && h >= 2 && parents[nx][ny][h-1]==null) {
					parents[nx][ny][h-1] = new Node(x, y, h);
					q.offer(new Node(nx, ny, h-1));
				}
			}
		}
	}
	
	private static void makePathList(int x, int y, int h) {
		paths = new ArrayList<>();
		while(true) {
			paths.add(new int[] {x,y});
			Node prev = parents[x][y][h];
			if(prev.x == -1 && prev.y == -1 && prev.h ==-1) break;
			x = prev.x;
			y = prev.y;
			h = prev.h;
		}
		Collections.reverse(paths);
	}
	
	private static String getDirection() {
		int size = paths.size();
		int[] s = paths.get(0);
		int[] e = paths.get(1);
		
		String dir = "";
		
		if(s[0] == e[0]) dir = s[1]>e[1] ? "L " : "R ";
		else dir = s[0]>e[0] ? "U " : "D ";
		
		
		if(mapData[e[0]][e[1]].equals("T")) {
			dir += "F1";
			return dir;
		}
		
		if(size <=4 && isStraight(paths)) dir+= "F2";
		else dir += "A";
		return dir;
	}
	
	private static boolean isStraight(List<int[]> path) {
		int[] start = path.get(0);
		int[] end = path.get(path.size()-1);
		return start[0] == end[0] || start[1] == end[1];
	}
	
	
	public static void main(String[] args) {
		String gameData = """
10 10 2 1 1
G G G G R G G G R X
G G R G R G R G G A
R G R G G G R G R G
G G R T T T T G G R
G R T T G R R G G G
G G T T G R G G G G
R G R G G R G R G R
G G R G G R G G G G
G G R G G W W W W G
G G G G G G G G G G
A 100 R 1 1
H 10
X 10
SRKKCVJJRWP
		""";
		parseData(gameData);
		bfs();
		String dir = getDirection();
		System.out.println(dir);
		
		System.out.println("전체 경로:");
        for (int[] p : paths) {
            System.out.println(p[0] + " " + p[1]);
        }
	}

	// 입력 데이터를 파싱하여 변수에 저장
    private static String[][] mapData; // 맵 정보
    private static Map<String, String[]> allies = new HashMap<>(); // 아군 정보
    private static Map<String, String[]> enemies = new HashMap<>(); // 적군 정보
    private static String[] codes; // 암호문 정보	
    private static void parseData(String gameData) {
        // 입력 데이터를 행으로 나누기
        String[] rows = gameData.split("\n");
//        System.out.println(Arrays.toString(rows));
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
        
        String[] aInfo = allies.get("A");
        heart = Integer.parseInt(aInfo[2]) + Integer.parseInt(aInfo[3]);
        
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
