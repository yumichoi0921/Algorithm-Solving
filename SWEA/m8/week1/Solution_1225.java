package SWEA.m8.week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int T = sc.nextInt();
        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            Queue<Integer> Q = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                Q.offer(sc.nextInt());
            }

            int n = 1;
            while (true) {
                if (n > 5) n = 1;
                int tn = Q.poll()-n;
                if (tn <= 0) {
                    Q.offer(0);
                    break;
                }
                Q.offer(tn);
                n++;

            }
            System.out.printf("#%d ", tc);
            for (int i = 0; i < 8; i++) {
                System.out.print(Q.poll()+" ");
            }
            System.out.println();


//            int num = 1;
//            while(true) {
//                int v = Q.poll()-num;
//                if (v <= 0) {
//                    Q.offer(0);
//                    break;
//                }
//                Q.offer(v);
//                num++;
//                if (num == 6) {
//                    num = 1;
//                }
//            }
//            System.out.printf("#%d %s\n", tc, Q.toString().replaceAll("[\\[\\,\\]]",""));
        }
    }
}
