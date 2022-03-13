package SWEA.m8.week2;

import java.util.Scanner;

public class Solution_1233 {
    static int cnt;
    static String operator = "+-*/";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int res = 1;
            sc.nextLine();
            // 입력값으로 풀이
            for (int i = 0; i < N; i++) {
                String[] str = sc.nextLine().split(" ");
                if (str.length == 2 && operator.contains(str[1])) {
                    res = 0;
                }
            }
            System.out.printf("#%d %d\n", tc, res);

            // dfs 풀이
//            String[] nodes = new String[N+1];
//            for (int i = 0; i < N; i++) {
//                String[] str = sc.nextLine().split(" ");
//                nodes[Integer.parseInt(str[0])] = str[1];
//            }
//            cnt = 0;
//            dfs(nodes, 1, N);
//            if (cnt != N) res = 0;
//            System.out.printf("#%d %d\n", tc, res);
        }
    }

    private static void dfs(String[] nodes, int idx, int lastIdx) {
        if (idx > lastIdx) {
            return;
        }
        if (operator.contains(nodes[idx])) {
            cnt++;
            dfs(nodes, idx*2, lastIdx);
            dfs(nodes, idx*2+1, lastIdx);
        } else if (!operator.contains(nodes[idx])){
            cnt++;
            return ;
        }
    }
}
