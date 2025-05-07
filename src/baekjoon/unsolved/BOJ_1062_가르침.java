package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1062_가르침 {
	
    static int N, K, max = 0;
    static String[] input;
    static char[] base = {'a', 'n', 't', 'i', 'c'};

    private static int cntReadable(int learned) {
        int count = 0;
        for (String word : input) {
            boolean readable = true;
            for (char c : word.toCharArray()) {
                if ((learned & (1 << (c - 'a'))) == 0) {
                    readable = false;
                    break;
                }
            }
            if (readable) count++;
        }
        return count;
    }

    
    private static void pickAlphabet(int start, int learned, int depth) {
        if (depth == K) {
            max = Math.max(max, cntReadable(learned));
            return;
        }
        for (int i = start; i < 26; i++) {
            if ((learned & (1 << i)) != 0) continue; // 이미 배운 글자면 skip
            pickAlphabet(i + 1, learned | (1 << i), depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        int learned = 0;
        for (char c : base) {
            learned |= (1 << (c - 'a'));
        }

        pickAlphabet(0, learned, 5); 
        System.out.println(max);
    }
}
