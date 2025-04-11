package etc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 배틀1 {
	
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
    
    
	public static void main(String[] args) {
		String gameData = """
10 10 3 3 1
G R R G T G G R G X
G R R G T R G G G G
G R R G R R R G R R
F A G G G G R G G G
G R T T R G R G E1 G
G G T T R G G G G G
R G G G G R E2 R G R
G G R W W W G G G G
G G R W W W R R R G
H G G G A1 G G G G G
A 100 R 1 1
A1 10
H 10
E1 10
E2 10
X 10
AKWNSDN
		""";
		parseData(gameData);
		System.out.println();
	}
}