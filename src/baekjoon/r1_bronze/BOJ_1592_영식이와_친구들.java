package baekjoon.r1_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와_친구들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); // M번 받으면 끝 
        int L = Integer.parseInt(st.nextToken()); // L만큼

        for (int i = 1; i <= N; i++) {
            map.put(i, 0);
        }

        int p = 1; 
        int count = 0;

            map.put(p, map.get(p) + 1);

            if (map.get(p) == M) { 
                break;
            }

            if (map.get(p) % 2 == 1) { //오른
                p = p+L > N ? p+L-N : p+L;
            } else { // 왼쪽 
                p = p - L < 0 ? p - L + N : p - L;

            }
            count++;
        }

        System.out.println(count);
    }
}
