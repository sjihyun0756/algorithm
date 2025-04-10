package baekjoon.r3_gold;

import java.util.*;
import java.io.*;

public class BOJ_16637_괄호_추가하기 {

    static int N, maxResult;
    static int[] select;
    static int[] numArr;
    static String[] expression;
    static boolean[] visit;

    private static int operate(int pre, char oper, int suf) {
        if (oper == '+') return pre + suf;
        else if (oper == '-') return pre - suf;
        else return pre * suf;
    }

    private static int calculate(int[] select) {
        String[] expressionCopy = expression.clone();

        for (int s : select) {
            int pre = Integer.parseInt(expressionCopy[s - 1]);
            char oper = expressionCopy[s].charAt(0);
            int suf = Integer.parseInt(expressionCopy[s + 1]);

            int res = operate(pre, oper, suf);

            expressionCopy[s - 1] = null; 
            expressionCopy[s] = String.valueOf(res);
            expressionCopy[s + 1] = null;
        }

        List<String> list = new ArrayList<>();
        for (String str : expressionCopy) {
            if (str != null) list.add(str);
        }

        int result = Integer.parseInt(list.get(0));
        for (int i = 1; i + 1 < list.size(); i += 2) {
            char op = list.get(i).charAt(0);
            int next = Integer.parseInt(list.get(i + 1));
            result = operate(result, op, next);
        }
        return result;
    }

    private static void findSet(int depth, int last) {
        if (depth == select.length) {
            maxResult = Math.max(calculate(select), maxResult);
            return;
        }

        for (int i = last + 1; i < numArr.length; i++) {
            if (visit[i]) continue;
            if (depth > 0 && numArr[i] - select[depth - 1] < 4) continue;

            visit[i] = true;
            select[depth] = numArr[i];
            findSet(depth + 1, i);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String input = sc.next();
        int operNum = (N - 1) / 2;
        expression = new String[N];
        numArr = new int[operNum];

        for (int i = 0; i < N; i++) {
            expression[i] = String.valueOf(input.charAt(i));
        }

        for (int i = 0, n = 1; i < operNum; i++, n += 2) {
            numArr[i] = n;
        }

        maxResult = calculate(new int[0]);

        for (int i = 1; i <= operNum; i++) {
            select = new int[i];
            visit = new boolean[N];
            findSet(0, -1);
        }

        System.out.println(maxResult);
    }
}
