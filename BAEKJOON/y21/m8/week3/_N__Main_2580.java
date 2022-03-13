package BAEKJOON.y21.m8.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _N__Main_2580 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] game = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                game[i][j] = sc.nextInt();
            }
        }

        List<int[]> blank = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (game[i][j] == 0) {
                    blank.add(new int[]{i, j});
                }
            }
        }

        fill(game, blank);


    }

    private static void fill(int[][] game, List<int[]> blank) {

        for (int i = 0; i < blank.size(); i++) {
            int r = blank.get(i)[0];
            int c = blank.get(i)[1];
        }


//        if (idx == 9) {
//            return;
//        }
//        HashSet<Integer> R = new HashSet<>();
//        HashSet<Integer> C = new HashSet<>();
//        HashSet<Integer> S = new HashSet<>();
//        for (int k = 0; k < 9; k++) {
//            R.add(game[k][idx]);
////            C.add(game[idx][k]);
//        }
//        if (R.contains(0)) {
//
//        }
//
//
//
//
//
//        int r = (idx/3)*3, c = (idx%3)*3;
//        for (int i = r; i < r+3; i++) {
//            for (int j = c; j < c+3; j++) {
//                S.add(game[i][j]);
//            }
//        }
//        if (R.contains(0) || C.contains(0) || S.contains(0)) {
//            int r = R.
//            for (int i = 1; i <= 9; i++) {
//
//            }
//        }
    }
}
