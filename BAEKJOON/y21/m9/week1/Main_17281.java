package BAEKJOON.y21.m9.week1;

import java.util.Scanner;

public class Main_17281 {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 이닝 수

        // 안타: 1 2루타: 2 3루타: 3 홈런: 4 아웃: 0
        int[][] player_score = new int[N][9];   // 각 선수가 각 이닝에서 얻는 결과
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 9; j++) {
                player_score[i][j] = sc.nextInt();
            }
        }

        res = 0;
        int[] sequence = new int[9];    // sequence[x번타자] = y번 선수
        sequence[3] = 0;    // 4번타자는 항상 1번 선수
        boolean[] selected = new boolean[9];
        selected[0] = true; // 1번 선수는 항상 4번타자로 고정
        permutation(player_score, sequence, selected, 0);
        System.out.println(res);
    }

    private static void permutation(int[][] player_score, int[] sequence, boolean[] selected, int idx) {
        if (idx == 3) {
            idx++;
        }
        if (idx == selected.length) {
//            System.out.println(Arrays.toString(sequence));
            calculate(player_score, sequence);
            return;
        }

        for (int i = 0; i < selected.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                sequence[idx] = i;
                permutation(player_score, sequence, selected, idx + 1);
                selected[i] = false;
            }
        }
    }

    private static void calculate(int[][] player_score, int[] sequence) {

        int s = 0;
        int tmpRes = 0;
        for (int i = 0; i < player_score.length; i++) {
            int[] base = new int[4];
            int out = 0;
            while (true) {
                if (out == 3) {
                    break;
                }
                if (s >= 9) {   // 한바퀴 돌았으면 다시 처음으로
                    s = 0;
                }
                base[0] = 1;    // 타자 홈
                if (player_score[i][sequence[s]] == 0) {    // i번째 이닝에 s번째 타자가 아웃
                    out++;
                } else {
                    for (int r = 3; r >= 0; r--) {
                        int nr = r + player_score[i][sequence[s]];    // 다음루는 현재루 + 안타
                        if (base[r] == 1) { // 현재 루에 사람이 있을 때
                            if (nr >= 4) {  // 그 사람이 가야하는 다음 루가 4가 넘으면 홈으로 돌아옴
                                base[r] = 0;    // 현재 루 비움
                                tmpRes++;   // 점수 증가
                            } else {
                                base[nr] = 1;   // 4가 넘지 않으면 다음루로 이동
                                base[r] = 0;    // 현재 루 비움
                            }
                        }
                    }
                }
                s++;    // 다음 타자
            }
        }
        res = Math.max(res, tmpRes);
    }
}

