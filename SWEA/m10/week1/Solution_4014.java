package SWEA.m10.week1;

import java.util.Scanner;

// 경사로
// 시뮬레이션
public class Solution_4014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                boolean[] edge = new boolean[N];    // 경사로인지 확인
                int bH = map[i][0];                 // 기준 높이
                boolean possible = true;
                check:
                for (int j = 1; j < N; j++) {
                    if (map[i][j] == bH) {
                        continue;
                    } else if (map[i][j] == bH - 1) {  // 내리막길 검사
                        for (int l = 0; l < L; l++) {  // 경사로 길이가 L이 되는지 확인(현재 경사로의 첫번째 자리)
                            if (j + l < N && !edge[j + l] && map[i][j + l] == bH - 1) {  // 현재 자리가 범위내, 경사로 아니고, 높이가 경사로 높이(기준보다 작다면)라면
                                edge[j + l] = true; // 경사로에 포함
                                continue;
                            }
                            possible = false;
                            break check;
                        }
                        j += L-1;       // 현재 좌표가 경사로가 될 수 있다면 좌표를 경사로 마지막으로 옮김
                        bH = map[i][j]; // 기준 높이를 지금 좌표로 변경
                    } else if (map[i][j] == bH + 1) { // 오르막길 검사
                        for (int l = 1; l <= L; l++) {  // 경사로 길이가 L이 되는지 확인(현재는 경사로 시작 전 자리)
                            if (j - l >= 0 && !edge[j - l] && map[i][j - l] == bH) { // 다음 자리가 범위내, 경사로 아니고, 높이가 경사로 높이라면(기준보다 작음)
                                edge[j - l] = true; // 경사로에 포함
                                continue;
                            }
                            possible = false;
                            break check;
                        }
                        bH = map[i][j]; // 기준 높이를 지금 좌표로 변경
                    } else {
                        possible = false;
                        break check;
                    }
                }
                if (possible) {
                    result++;
                }
            }

            for (int j = 0; j < N; j++) {
                boolean[] edge = new boolean[N];
                int bH = map[0][j];
                boolean possible = true;
                check:
                for (int i = 1; i < N; i++) {
                    if (map[i][j] == bH) {
                        continue;
                    } else if (map[i][j] == bH - 1) {  // 내리막길 검사
                        for (int l = 0; l < L; l++) {
                            if (i + l < N && !edge[i + l] && map[i + l][j] == bH - 1) {
                                edge[i + l] = true;
                                continue;
                            }
                            possible = false;
                            break check;
                        }
//                    i += L-1;
                        bH = map[i][j];
                    } else if (map[i][j] == bH + 1) { // 오르막길 검사
                        for (int l = 1; l <= L; l++) {
                            if (i - l >= 0 && !edge[i - l] && map[i - l][j] == bH) {
                                edge[i - l] = true;
                                continue;
                            }
                            possible = false;
                            break check;
                        }
                        bH = map[i][j];
                    } else {
                        possible = false;
                        break check;
                    }
                }
                if (possible) {
                    result++;
                }
            }
            System.out.println("#"+tc+" "+result);
        }



    }
}
