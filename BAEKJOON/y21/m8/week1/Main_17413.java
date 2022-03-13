package BAEKJOON.y21.m8.week1;

import java.util.Scanner;

public class Main_17413 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();

        String res = "";
        String word = "";

        boolean flag = false;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == ' ') {
                res += word + " ";
                word = "";
            } else if (c == '<') {
                flag = true;
                word += "<";
            } else if (c == '>') {
                flag = false;
                word += ">";
                res += word;
                word = "";
            } else if (flag == true) {
                word = word + c;
            } else {
                word = c + word;
            }

            if (i == ch.length - 1) res += word;
        }

        System.out.println(res);

    }
}
