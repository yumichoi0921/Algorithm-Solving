package SWEA.m8.week2;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1288 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 1;
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            LinkedList<Integer> password = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                password.add(sc.nextInt());
            }

            int c = sc.nextInt();
            for (int i = 0; i < c; i++) {
                String command = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int j = 0; j < y; j++) {
                    int v = sc.nextInt();
                    password.add(x, v);
                    x++;
                }
            }
            System.out.printf("#%d ", tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(password.poll()+" ");
            }
            System.out.println();

       }
    }
}
