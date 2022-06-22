package BAEKJOON.y22.m4.w5;

import java.util.Scanner;

public class Main_13458 {
    static int N, B, C;
    static int[] place;
    static Viewer[] viewers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        place = new int[N];
        for (int i = 0; i < N; i++) {
            place[i] = sc.nextInt();
        }
        viewers = new Viewer[2];
        viewers[0] = new Viewer('M', sc.nextInt());
        viewers[1] = new Viewer('S', sc.nextInt());

        long total = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            int idx = 0;
            if (viewers[idx].role == 'M') {
                place[i] -= viewers[0].num;
                idx = 1;
            } else {
                place[i] -= viewers[1].num;
                idx = 0;
            }

            cnt++;
            if (place[i] > 0) {
                cnt += place[i] % viewers[idx].num == 0 ? place[i] / viewers[idx].num : (place[i] / viewers[idx].num) + 1;
            }

            place[i] = 0;
            total += cnt;
        }

        System.out.println(total);

    }

    static class Viewer implements Comparable<Viewer> {
        char role;
        int num;

        public Viewer(char role, int num) {
            this.role = role;
            this.num = num;
        }

        @Override
        public int compareTo(Viewer o) {
            return o.num - this.num;
        }
    }
}
