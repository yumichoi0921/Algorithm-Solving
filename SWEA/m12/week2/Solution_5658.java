package SWEA.m12.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 보물상자 비밀번호
// 배열돌리기
// 내림차순 정렬
public class Solution_5658 {
    static int N, K;
    static char[] numbers;
    static ArrayList<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            String str = sc.next();
            numbers = new char[str.length()];
            numbers = str.toCharArray();

            boolean flag = true;
            list = new ArrayList<>();
            while (flag) {
                for (int i = 0; i < numbers.length; i += numbers.length / 4) {
                    String tmp = "";
                    for (int j = i; j < i + numbers.length / 4; j++) {
                        tmp += numbers[j];
                    }
                    if (list.contains(tmp)) {
                        flag = false;
                    } else {
                        flag = true;
                        list.add(tmp);
                    }
                }
                if (!flag) break;

                char last = numbers[N - 1];
                for (int i = N - 1; i > 0; i--) {
                    numbers[i] = numbers[i - 1];
                }
                numbers[0] = last;
            }

            Integer[] results = new Integer[list.size()];
            for (int i = 0; i < list.size(); i++) {
                results[i] = Integer.parseInt(list.get(i), 16);
            }
            Arrays.sort(results, Collections.reverseOrder());
            System.out.println("#" + tc + " " + results[K - 1]);
        }
    }
}
