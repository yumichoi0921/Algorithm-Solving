package BAEKJOON.y21.m8.week3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        LinkedList<Integer> dir = new LinkedList<>();
        LinkedList<Integer> len = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            int d = sc.nextInt();
            int l = sc.nextInt();
            dir.add(d);
            len.add(l);
        }

        int maxW = 0, maxH = 0;
        for (int i = 0; i < len.size(); i++) {
            if (dir.get(i) == 1 || dir.get(i) == 2) {
                maxW = Math.max(maxW, len.get(i));
            } else {
                maxH = Math.max(maxH, len.get(i));
            }
        }
        int bigSquare = maxW * maxH;

        int minW = 0, minH = 0;
        for (int i = 0; i < dir.size(); i++) {
            if (i + 1 < dir.size()) {
                if (dir.get(i) == 1 && dir.get(i + 1) == 3) {
                    minW = len.get(i);
                    minH = len.get(i + 1);
                } else if (dir.get(i) == 2 && dir.get(i + 1) == 4) {
                    minW = len.get(i);
                    minH = len.get(i + 1);
                } else if (dir.get(i) == 3 && dir.get(i + 1) == 2) {
                    minH = len.get(i);
                    minW = len.get(i + 1);
                } else if (dir.get(i) == 4 && dir.get(i + 1) == 1) {
                    minH = len.get(i);
                    minW = len.get(i + 1);
                }
            } else {
                if (dir.get(i) == 1 && dir.get(0) == 3) {
                    minW = len.get(i);
                    minH = len.get(0);
                } else if (dir.get(i) == 2 && dir.get(0) == 4) {
                    minW = len.get(i);
                    minH = len.get(0);
                } else if (dir.get(i) == 3 && dir.get(0) == 2) {
                    minH = len.get(i);
                    minW = len.get(0);
                } else if (dir.get(i) == 4 && dir.get(0) == 1) {
                    minH = len.get(i);
                    minW = len.get(0);
                }
            }
        }
        int smallSquare = minW * minH;
        int res = (bigSquare - smallSquare) * K;
        System.out.println(res);

    }
}
