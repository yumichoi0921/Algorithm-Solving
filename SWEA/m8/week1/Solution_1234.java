package SWEA.m8.week1;

import java.util.Scanner;

//1234번
public class Solution_1234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {

            int N = sc.nextInt();
            String password = sc.next();

            int l = 0, r = l+1;
            while (l >= 0 && r < password.length()){
                if (password.substring(l, l+1).equals(password.substring(r, r+1))){
                    password = password.replace(password.substring(l, r+1), "");
                    l--;
                    if (l < 0) l = 0;
                    r = l+1;
                } else {
                    l++;
                    r++;
                }
            }

            System.out.printf("#%d %s\n", tc, password);

        }
    }
}
