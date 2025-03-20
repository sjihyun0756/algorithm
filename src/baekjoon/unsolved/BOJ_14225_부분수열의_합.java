package baekjoon.unsolved;

import java.io.*;
import java.util.*;

public class BOJ_14225_부분수열의_합 {
    static Integer[] numArr;
    static boolean[] visit;
    static int maxNum = 1;
    static boolean check = false;

    private static void subset(int index, int sum) {
        if (check) return;

        if (index == numArr.length) {
            if (sum > maxNum) {
                check = true;
                return;
            }
            if (sum == maxNum) {
                maxNum++;
            }
            return;
        }

        subset(index + 1, sum);
        subset(index + 1, sum + numArr[index]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numArr = new Integer[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr, Comparator.reverseOrder());

        subset(0, 0);

        System.out.println(maxNum);
    }
}