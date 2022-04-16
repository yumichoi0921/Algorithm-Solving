package BAEKJOON.y22.m4.w3;

import java.util.Scanner;

public class Main_17609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String str = sc.next();
            int flag = 0;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) == str.charAt(str.length() - 1 - i)) continue;
                String newStr = str.substring(0, i) + str.substring(i + 1, str.length());
                if (checkPseudoPalindrome(i, newStr)) {
                    flag = 1;
                    break;
                }
                newStr = str.substring(0, str.length() - 1 - i) + str.substring(str.length() - i, str.length());
                if (checkPseudoPalindrome(i, newStr)) {
                    flag = 1;
                    break;
                }
                flag = 2;
                break;
            }
            System.out.println(flag);
        }

    }

    private static boolean checkPseudoPalindrome(int now, String str) {
        for (int i = now; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) continue;
            else {
                return false;
            }
        }
        return true;
    }
}
