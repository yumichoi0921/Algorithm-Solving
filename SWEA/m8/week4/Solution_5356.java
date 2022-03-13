package SWEA.m8.week4;

import java.util.Scanner;

public class Solution_5356 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder[] str = new StringBuilder[5];
            for (int i = 0; i < 5; i++) {
                str[i] = new StringBuilder();
                str[i].append(sc.next());
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < str.length; j++) {
                    if (str[j].length() > i) {
                        res.append(str[j].charAt(i));
                    } else {
                        res.append("");
                    }
                }
            }
            System.out.printf("#%d %s\n", tc, res.toString());
        }
    }
}
