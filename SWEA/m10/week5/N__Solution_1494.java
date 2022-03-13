package SWEA.m10.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N__Solution_1494 {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N;
    static ArrayList<Point> jirung;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            jirung = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                jirung.add(new Point(sc.nextInt(), sc.nextInt()));
            }

            int[][] matching = new int[N/2][2];
            combi(0, 0, 0, new boolean[N], matching);

            




        }
    }

    private static void combi(int r, int c, int start, boolean[] v, int[][] matching) {



        for (int i = start; i < N; i++) {
            matching[r][c] = i;
            combi(r, c+1, i+1, v, matching);
        }

    }
}
