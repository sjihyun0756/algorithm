package etc;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class battleSSAFY {
    static int N, M;
    static boolean[][][] visit; // [행][열][chance]
    static String[][] map;
    static int[] dx = {0, 0, 1, -1}; // R, L, D, U
    static int[] dy = {1, -1, 0, 0};
    static int targetX, targetY;

    private static class Node {
        int r, c, heart;
        List<Integer> path;

        Node(int r, int c, int heart, List<Integer> path) {
            this.r = r;
            this.c = c;
            this.heart = heart;
            this.path = path;
        }
    }

    private static String bfs(int startX, int startY, int heart) {
        Queue<Node> q = new ArrayDeque<>();
        List<Integer> initPath = new ArrayList<>();
        initPath.add(startX);
        initPath.add(startY);
        q.offer(new Node(startX, startY, heart, initPath));
        visit[startX][startY][heart] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.r == targetX && node.c == targetY) {
                return node.path.stream().map(String::valueOf).collect(Collectors.joining(" "));
            }

            for (int d = 0; d < 4; d++) {
                int nx = node.r + dx[d];
                int ny = node.c + dy[d];
                int nextHeart = node.heart;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                String cell = map[nx][ny];

                if ((cell.equals("G") || cell.equals("A") || cell.equals("X")) && !visit[nx][ny][nextHeart]) {
                    List<Integer> newPath = new ArrayList<>(node.path);
                    newPath.add(nx);
                    newPath.add(ny);
                    visit[nx][ny][nextHeart] = true;
                    q.offer(new Node(nx, ny, nextHeart, newPath));
                }

                else if (cell.equals("T") && nextHeart >= 1 && !visit[nx][ny][nextHeart - 1]) {
                    List<Integer> newPath = new ArrayList<>(node.path);
                    newPath.add(nx);
                    newPath.add(ny);
                    visit[nx][ny][nextHeart - 1] = true;
                    q.offer(new Node(nx, ny, nextHeart - 1, newPath));
                }
            }
        }

        return "도달 불가";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int 아군수 = Integer.parseInt(st.nextToken());
        int 적군수 = Integer.parseInt(st.nextToken());
        int 암호문수 = Integer.parseInt(st.nextToken());

        int startX = -1, startY = -1;
        targetX = -1;
        targetY = -1;
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("A")) {
                    startX = i;
                    startY = j;
                }
                if (map[i][j].equals("X")) {
                    targetX = i;
                    targetY = j;
                }
            }
        }

        String[] info2 = new String[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            info2[i] = st.nextToken();
        }

        int chance = Integer.parseInt(info2[3]) + Integer.parseInt(info2[4]);
        visit = new boolean[N][M][chance + 1];

        String result = bfs(startX, startY, chance);
        System.out.println("최단 경로: " + result);
    }
}