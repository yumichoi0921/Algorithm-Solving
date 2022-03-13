package JungOl.m8.week2;

import java.util.Arrays;
import java.util.Scanner;

class Chemy implements Comparable<Chemy>{
    int low, hi;
    Chemy(int low, int hi) {
        this.low = low;
        this.hi = hi;
    }

    @Override
    public String toString() {
        return "Chemy{" +
                "low=" + low +
                ", hi=" + hi +
                '}';
    }

    @Override
    public int compareTo(Chemy o) {
        return Integer.compare(this.hi, o.hi);
    }
}
public class Main_1828 {
    static Chemy[] chem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 객체 풀이
//        chem = new Chemy[N];
//        for (int i = 0; i < N; i++) {
//            chem[i] = new Chemy(sc.nextInt(), sc.nextInt());
//        }
//        Arrays.sort(chem);
//
//        int cnt = 1;
//        int tmp = chem[0].hi;
//        for (int i = 1; i < N; i++) {
//            if (tmp < chem[i].low) {
//                cnt++;
//                tmp = chem[i].hi;
//            }
//        }
//        System.out.println(cnt);


        // 배열 풀이
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, ((o1, o2) -> {return o1[1]-o2[1];}));

        int res= 1;
        int tmp = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (tmp < arr[i][0]) {
                res++;
                tmp = arr[i][1];
            }
        }
        System.out.println(res);
    }
}
