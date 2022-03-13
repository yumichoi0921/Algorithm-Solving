package SWEA.m11.week1;

import java.util.Arrays;
import java.util.Scanner;
// K번째 접미어
public class Solution_1256 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int K = sc.nextInt();
            String str = sc.next();
            String[] prefix = new String[str.length()];
            for (int i = 0; i < str.length(); i++) {
                prefix[i] = str.substring(i, str.length());
            }
            Arrays.sort(prefix);
            System.out.println("#"+tc+" "+prefix[K-1]);

        }
    }
}
