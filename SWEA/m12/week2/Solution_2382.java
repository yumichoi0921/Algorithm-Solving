package SWEA.m12.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 미생물 격리
// 시뮬레이션
public class Solution_2382 {
    static int N, M, K;
    static int[][] map;
    static ArrayList<Microbe> microbes;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();   // 시간
            K = sc.nextInt();   // 군집 수
            microbes = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                microbes.add(new Microbe(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() - 1));
            }

            map = new int[N][N];
            for (int i = 0; i < N; i++) {   // 약품처리된 곳 -1
                map[i][0] = -1;
                map[0][i] = -1;
                map[i][N - 1] = -1;
                map[N - 1][i] = -1;
            }

            int time = 0;
            while (true) {
                time++;
                ArrayList<Microbe>[][] tmpMap = new ArrayList[N][N];    // [r][c]에 위치한 미생물
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        tmpMap[i][j] = new ArrayList<>();
                    }
                }
                // 미생물 이동
                for (int i = 0; i < microbes.size(); i++) {
                    int nr = microbes.get(i).r + dr[microbes.get(i).dir];
                    int nc = microbes.get(i).c + dc[microbes.get(i).dir];
                    microbes.get(i).r = nr; // 미생물 위치 이동
                    microbes.get(i).c = nc;
                    if (map[nr][nc] == -1) {    // 약품처리된 곳이면
                        microbes.get(i).size = microbes.get(i).size / 2;    // 사이즈 감소
                        if (microbes.get(i).dir % 2 == 0) microbes.get(i).dir++;    // 방향변경
                        else microbes.get(i).dir--;
                    }
                    tmpMap[nr][nc].add(microbes.get(i));    // 배열에 추가
                }

                ArrayList<Microbe> newMicrobes = new ArrayList<>(); // 새로운 미생물
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tmpMap[i][j].size() == 1) { // 위치에 미생물이 하나면
                            newMicrobes.add(tmpMap[i][j].get(0));   // 새로운 미생물에 추가
                        } else if (tmpMap[i][j].size() > 1) {   // 위치에 미생물이 여러개면
                            int newSize = 0;
                            Collections.sort(tmpMap[i][j], new Comparator<Microbe>() {  // 사이즈 순으로 내림차순 정렬
                                @Override
                                public int compare(Microbe o1, Microbe o2) {
                                    return o2.size - o1.size;
                                }
                            });
                            for (int k = 0; k < tmpMap[i][j].size(); k++) { // 새로운 사이즈는 미생물의 모든 사이즈의 합
                                newSize += tmpMap[i][j].get(k).size;
                            }
                            tmpMap[i][j].get(0).size = newSize;     // 사이즈가 가장 큰 미생물의 사이즈를 새로운 사이즈로 변경
                            newMicrobes.add(tmpMap[i][j].get(0));   // 수정된 가장 큰 사이즈 미생물을 새로운 미생물에 추가
                        }
                    }
                }
                microbes = newMicrobes; // 기존 미생물리스트를 새로운 미생물리스트로 변경
                if (time == M) break;
            }
            int result = 0;
            for (int i = 0; i < microbes.size(); i++) {
                result += microbes.get(i).size;
            }
            System.out.println("#" + tc + " " + result);

        }
    }

    static class Microbe {
        int r, c, size, dir;

        public Microbe(int r, int c, int size, int dir) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.dir = dir;
        }
    }
}
