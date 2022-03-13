package BAEKJOON.y21.m9.week3;

import java.util.Arrays;
import java.util.Scanner;

// prim
public class Main_4386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[][] stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            stars[i] = new double[]{sc.nextDouble(), sc.nextDouble()};
        }


        boolean[] v = new boolean[n];
        double[] vals = new double[n];
        Arrays.fill(vals, Double.MAX_VALUE);
        vals[0] = 0.0;

        double result = 0.0;
        for (int i = 0; i < n; i++) {
            int minIdx = -1;
            double minVal = Double.MAX_VALUE;
            for (int j = 0; j < vals.length; j++) {
                if (!v[j] && vals[j] < minVal) {
                    minIdx = j;
                    minVal = vals[j];
                }
            }

            v[minIdx] = true;
            result += minVal;

            for (int j = 0; j < n; j++) {
                if (!v[j]) {
                    double dx = stars[minIdx][0] - stars[j][0];
                    double dy = stars[minIdx][1] - stars[j][1];
                    double tval = Math.sqrt(dx * dx + dy * dy);
                    if (tval < vals[j]) vals[j] = tval;
                }
            }
        }

        System.out.printf("%.2f\n", result);
    }
}
