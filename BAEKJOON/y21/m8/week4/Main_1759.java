package BAEKJOON.y21.m8.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 조합 - 조건 여러개, 삼항연산자
public class Main_1759 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();   // 암호 길이
        int C = sc.nextInt();   // 문자 종류
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            chars.add(sc.next().charAt(0));
        }
        Collections.sort(chars);
        combination(chars, new char[L], 0, 0, 0, 0);
    }

    // 최소 한개 모음
    // 최소 두개 자음
    private static void combination(List<Character> chars, char[] password, int idx, int start, int vs, int cs) {
        if (idx == password.length) {
            if (vs >= 1 && cs >= 2) {
                for (int i = 0; i < password.length; i++) {
                    System.out.print(password[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < chars.size(); i++) {
            password[idx] = chars.get(i);
            combination(chars, password, idx + 1, i + 1, ("aeiou".contains(chars.get(i).toString())) ? vs + 1 : vs, (!"aeiou".contains(chars.get(i).toString())) ? cs + 1 : cs);
        }
    }
}
