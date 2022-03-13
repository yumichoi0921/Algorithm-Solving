package SWEA.m8.week1;

import java.io.FileNotFoundException;
import java.util.*;

public class Solution_1873 {
    static List<Character> direction = Arrays.asList('^', 'v', '<', '>');  // 방향 종류
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int r, c, dIdx;
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("src/SWEA/august/week1/input.txt");
//        Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            char[][] map = new char[H][W];
            r = 0;  // 현재 전차 위치
            c = 0;
            dIdx = 0;   // 현재 방향 인덱스

            for (int i = 0; i < H; i++) {
                String str = sc.next();
                for (int j = 0; j < W; j++) {
                    if (direction.contains(str.charAt(j))) {
                        dIdx = direction.indexOf(str.charAt(j));
                        r = i;
                        c = j;
                    }
                    map[i][j] = str.charAt(j);
                }
            }

            int N = sc.nextInt();
            String str = sc.next();
            for (int k = 0; k < N; k++) {
                char command = str.charAt(k);
                if (command == 'U') {
                    dIdx = 0;
                    move(map);
                } else if (command == 'D') {
                    dIdx = 1;
                    move(map);
                } else if (command == 'L') {
                    dIdx = 2;
                    move(map);
                } else if (command == 'R') {
                    dIdx = 3;
                    move(map);
                } else if (command == 'S') {
                    int i = r, j = c;
                    while (i>=0 && i<H && j>=0 && j<W) {
                        if (map[i][j] == '*') { // 벽
                            map[i][j] = '.';
                            break;
                        } else if (map[i][j] == '#') { // 강철
                            break;
                        }
                        i = i+dr[dIdx];
                        j = j+dc[dIdx];
                    }

                }
            }

            System.out.print("#"+tc+" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

    }

    private static void move(char[][] map) {
        map[r][c] = direction.get(dIdx);
        int tmpr = r+dr[dIdx];
        int tmpc = c+dc[dIdx];
        if (tmpr>=0 && tmpr<map.length && tmpc>=0 && tmpc<map[0].length && map[tmpr][tmpc]=='.') {
            map[r][c] = '.';
            r = tmpr;
            c = tmpc;
            map[r][c] = direction.get(dIdx);
        }
    }
}
