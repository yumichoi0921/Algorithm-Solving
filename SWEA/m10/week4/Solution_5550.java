package SWEA.m10.week4;

import java.util.ArrayList;
import java.util.Scanner;
// 나는 개구리로소이다
public class Solution_5550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int res = 0;
            String str = sc.next();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);
                boolean flag = false;
                if (now == 'c') {
                    flag = true;
                    boolean newFrog = true;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).endsWith("croak")) {
                            list.set(j, list.get(j)+"c");
                            newFrog = false;
                            break;
                        }
                    }
                    if (newFrog) {
                        list.add("c");
                    }
                } else if (now == 'r') {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).endsWith("c")) {
                            list.set(j, list.get(j)+"r");
                            flag = true;
                            break;
                        }
                    }

                } else if (now == 'o') {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).endsWith("r")) {
                            list.set(j, list.get(j)+"o");
                            flag = true;
                            break;
                        }
                    }

                } else if (now == 'a') {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).endsWith("o")) {
                            list.set(j, list.get(j)+"a");
                            flag = true;
                            break;
                        }
                    }
                } else if (now == 'k') {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).endsWith("a")) {
                            list.set(j, list.get(j)+"k");
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    res = -1;
                    break;
                }

            }

            if (res != -1) {
//            System.out.println(Arrays.toString(list.toArray()));
                res = list.size();
                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).endsWith("croak")) {
                        res = -1;
                        break;
                    }
                }

            }
            System.out.println("#"+tc+" "+res);



        }
    }
}
