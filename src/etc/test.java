package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {

    static int[] arr;
    static int[] num;
    static int K;
    
    // 동전 개수를 세는 함수
    private static boolean check(int depth, int last, int cnt) {
        int sum = 0; // sum을 메서드 내에서 처리하여 누적 방지
        
        if(depth == cnt) {
            // 동전 개수가 cnt에 도달하면
            for(int m : num) {
                sum += m;
            }
            if(sum == K) return true;
            else return false;
        }
        
        for(int i=last+1; i<arr.length; i++) {
            num[depth] = arr[i];
            if (check(depth+1, i, cnt)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전의 개수
        K = Integer.parseInt(st.nextToken()); // 목표 금액
        arr = new int[N]; // 동전 배열

        // 동전 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] == K) {
                System.out.println(1);
                return;
            }
        }
        
        Arrays.sort(arr);
        
        int cnt = 2;
        while (true) {
            num = new int[cnt++];
            if (check(0, -1, cnt)) {
                System.out.println(cnt); // 최소 동전 개수 출력
                return;
            }
        }
    }
}
