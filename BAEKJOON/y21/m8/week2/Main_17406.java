package BAEKJOON.y21.m8.week2;

import java.util.Scanner;

public class Main_17406 {

    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] operation = new int[K][3];
        for (int k = 0; k < K; k++) {
            operation[k][0] = sc.nextInt();
            operation[k][1] = sc.nextInt();
            operation[k][2] = sc.nextInt();
        }

        res = Integer.MAX_VALUE;
        permutation(new int[K][3], operation, new boolean[K], 0, arr);
        System.out.println(res);
    }

    private static void permutation(int[][] ans, int[][] operation, boolean[] isVisited, int idx, int[][] arr) {
        if (idx == operation.length) {
            res = Math.min(res, calculation(arr, ans));
            return;
        }

        for (int i = 0; i < operation.length; i++) {
            if (!isVisited[i]) {
                ans[idx][0] = operation[i][0];
                ans[idx][1] = operation[i][1];
                ans[idx][2] = operation[i][2];
                isVisited[i] = true;
                permutation(ans, operation, isVisited, idx + 1, arr);
                isVisited[i] = false;
            }
        }
    }

    private static int calculation(int[][] arr, int[][] operation) {
        int[][] tmpArr = arr.clone();
        for (int i = 0; i < tmpArr.length; i++) {
            tmpArr[i] = arr[i].clone();
        }

        for (int k = 0; k < operation.length; k++) {
            int r = operation[k][0], c = operation[k][1], s = operation[k][2];

            int sN = r - s, sM = c - s;
            int eN = r + s, eM = c + s;
            while (sN < eN && sM < eM) {
                int tmp = tmpArr[sN][sM];
                for (int i = sN; i < eN; i++) {
                    tmpArr[i][sM] = tmpArr[i + 1][sM];
                }
                for (int i = sM; i < eM; i++) {
                    tmpArr[eN][i] = tmpArr[eN][i + 1];
                }
                for (int i = eN; i > sN; i--) {
                    tmpArr[i][eM] = tmpArr[i - 1][eM];
                }
                for (int i = eM; i > sM; i--) {
                    tmpArr[sN][i] = tmpArr[sN][i - 1];
                }
                tmpArr[sN][sM + 1] = tmp;
                sN++;
                sM++;
                eN--;
                eM--;
            }
        }
        int val = Integer.MAX_VALUE;
        for (int i = 1; i < tmpArr.length; i++) {
            int tmp = 0;
            for (int j = 1; j < tmpArr[0].length; j++) {
                tmp += tmpArr[i][j];
            }
            val = Math.min(val, tmp);
        }
        return val;
    }
}
