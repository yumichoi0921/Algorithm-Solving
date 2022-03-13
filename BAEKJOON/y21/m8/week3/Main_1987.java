package BAEKJOON.y21.m8.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 알파벳 - 백트래킹
public class Main_1987 {
    static int R;
    static int C;
    static int[] dr;
    static int[] dc;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        char[][] alphabet = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                alphabet[i][j] = str.charAt(j);
            }
        }
        dr = new int[]{-1, 1, 0, 0};
        dc = new int[]{0, 0, -1, 1};
        res = 0;
        recursive(alphabet, new ArrayList<>(), 0, 0, 0);
        System.out.println(res);
    }

    private static void recursive(char[][] alphabet, List<Character> sel, int r, int c, int idx) {
        if (sel.contains(alphabet[r][c])) { // 만약 리스트에 현재 알파벳이 포함되어 있다면 탐색 중단하고 리턴
            return;
        } else {    // 만약 리스트에 현재 알파벳이 없다면 추가
            sel.add(idx, alphabet[r][c]);
            idx++;
            res = Math.max(res, idx);   // 결과에 리스트의 최대 크기 저장
        }
        System.out.println(Arrays.toString(sel.toArray()));
        int tr, tc;
        for (int i = 0; i < dr.length; i++) {   // 사방 탐색
            tr = r + dr[i];
            tc = c + dc[i];
            if (tr >= 0 && tr < R && tc >= 0 && tc < C) {  // 사방이 배열 크기 내에 있다면
                recursive(alphabet, sel, tr, tc, idx);  // 그 자리부터 다시 사방 탐색
                // 재귀가 리턴되어 돌아온다면 해당 방향에서 최대로 깊이 탐색하고 돌아온 것
                // 다음 사방탐색을 위해 현재 리스트의 인덱스부터 끝까지 삭제 후 다시 사방탐색
                for (int j = idx; j < sel.size(); j++) {
                    sel.remove(j);
                }
            }
        }
    }
}
