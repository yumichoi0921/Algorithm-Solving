package SWEA.m8.week1;
import java.util.Scanner;

public class Solution_1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            String original = sc.next();
            StringBuilder initial = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < original.length(); i++) {
                initial.append("0");
            }

//            for (int i = 0; i < original.length(); i++) {
//                if (initial.charAt(i) != original.charAt(i)) {
//                    cnt++;
//                    String c = String.valueOf(original.charAt(i));
//                    for (int j = i; j < initial.length(); j++) {
//                        initial.replace(j, j+1, c);
//                    }
//                }
//            }
//            System.out.printf("#%d %d\n", tc, cnt);

            char tmp = '0';
            int ans = 0;
            for (int i = 0; i < original.length(); i++) {
                if (i == 0 && original.charAt(i) != '0') {
                    ans++;
                } else if (i-1>=0 && original.charAt(i-1) != original.charAt(i)) {
                    ans++;
                }
//                if (original.charAt(i) != tmp) {
//                    tmp = original.charAt(i);
//                    ans++;
//                }
            }
            System.out.printf("#%d %s\n", tc, ans);
        }
    }
}
