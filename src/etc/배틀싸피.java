 package etc;

import java.util.*;

public class 배틀싸피 {
    static int N, heart;
    private static int startX, startY;
    private static Node[][][] parent;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static List<int[]> paths;

    static class Node {
        int x, y, h;
        Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    private static void bfs() {
        N = mapData.length;
        parent = new Node[N][N][heart + 1];
//        parent = new Node[N][N][3];

        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mapData[i][j].equals("A")) {
                    startX = i;
                    startY = j;
                    break outer;
                }
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startX, startY, heart));
        parent[startX][startY][heart] = new Node(-1, -1, -1); // 시작점 표시

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.x, y = curr.y, h = curr.h;

            if (mapData[x][y].equals("X")) {
                makePathList(x, y, h);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if ((mapData[nx][ny].equals("G") || mapData[nx][ny].equals("X")) && parent[nx][ny][h] == null) {
                    parent[nx][ny][h] = new Node(x, y, h);
                    q.offer(new Node(nx, ny, h));
                }
                else if (mapData[nx][ny].equals("T") && h >= 2 && parent[nx][ny][h - 1] == null) {
                    parent[nx][ny][h - 1] = new Node(x, y, h);
                    q.offer(new Node(nx, ny, h - 1));
                }
            }
        }
    }

    private static void makePathList(int endX, int endY, int endH) {
        paths = new ArrayList<>();
        int x = endX, y = endY, h = endH;
        while (true) {
            paths.add(new int[]{x, y});
            Node prev = parent[x][y][h];
            if (prev.x == -1 && prev.y == -1 && prev.h == -1) break;
            x = prev.x;
            y = prev.y;
            h = prev.h;
        }
        Collections.reverse(paths);
    }

    private static boolean isStraightLine(List<int[]> path) {
        int[] start = path.get(0);
        int[] end = path.get(path.size() - 1);
        return start[0] == end[0] || start[1] == end[1];
    }

    private static String getDirection() {
        int size = paths.size();
        int[] s = paths.get(0);  // 현재 A 위치
        int[] e = paths.get(1);  // 다음 이동할 칸

        String dir = "";

        if (s[0] == e[0]) {
            dir = s[1] > e[1] ? "L " : "R ";
        } else {
            dir = s[0] > e[0] ? "U " : "D ";
        }
        
        if (mapData[e[0]][e[1]].equals("T")) {
            dir += "F1";
            return dir;
        }

        if (size <= 4 && isStraightLine(paths)) {
            dir += "F2";
        } else {
            dir += "A";
        }
        return dir;
    }


    private static StringBuilder findPW(String[] codes) {
        StringBuilder sb = new StringBuilder();
        for (String code : codes) {
            System.out.println("암호문: " + code);
            for (int shift = 3; shift <= 26; shift++) {
                sb.append("G ").append(shift).append(": ");
                for (char ch : code.toCharArray()) {
                    char shifted = (char) ('A' + (ch - 'A' - shift + 26) % 26);
                    sb.append(shifted);
                }
                sb.append("\n");
            }
        }
        return sb;
    }

    // 기본 제공
    private static String[][] mapData;
    private static Map<String, String[]> allies = new HashMap<>();
    private static Map<String, String[]> enemies = new HashMap<>();
    private static String[] codes;

    private static void parseData(String gameData) {
        String[] rows = gameData.split("\n");
        int index = 0;

        String[] header = rows[index++].split(" ");
        int h = Integer.parseInt(header[0]);
        int w = Integer.parseInt(header[1]);
        int a = Integer.parseInt(header[2]);
        int e = Integer.parseInt(header[3]);
        int c = Integer.parseInt(header[4]);

        mapData = new String[h][w];
        for (int i = 0; i < h; i++) {
            mapData[i] = rows[index++].split(" ");
        }

        allies.clear();
        for (int i = 0; i < a; i++) {
            String[] parts = rows[index++].split(" ");
            allies.put(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
        }

        String[] aInfo = allies.get("A");
        heart = Integer.parseInt(aInfo[2]) + Integer.parseInt(aInfo[3]);

        enemies.clear();
        for (int i = 0; i < e; i++) {
            String[] parts = rows[index++].split(" ");
            enemies.put(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
        }

        codes = new String[c];
        for (int i = 0; i < c; i++) {
            codes[i] = rows[index++];
        }
    }

    public static void main(String[] args) {
        String data = """
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

        parseData(data);
        bfs();
        String dir = getDirection();

        boolean supplyFound = false;
        for (int d = 0; d < 4; d++) {
            int nx = startX + dx[d];
            int ny = startY + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && mapData[nx][ny].equals("F")) {
                supplyFound = true;
                break;
            }
        }

        if (supplyFound) {
        	System.out.println("G + 답~~~");
//            System.out.println(findPW(codes));
        } else {
            System.out.println(dir);
        }
        System.out.println("전체 경로:");
        for (int[] p : paths) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}