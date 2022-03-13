package BAEKJOON.y21.m8.week2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        LinkedList<Integer> res = new LinkedList<>();
        int idx = -1;
        while (!list.isEmpty()) {
            idx += K;
            if (idx >= list.size()) {
                idx = idx % list.size();
            }
            res.offer(list.get(idx));
            list.remove(idx);
            idx--;
        }
        System.out.println(res.toString().replace('[', '<').replace(']', '>'));
    }
}
