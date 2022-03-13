package JungOl.m10.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// 회전초밥
// 슬라이딩 윈도우?
public class N__Main_2577 {
    static int N,d, k, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 접시 수
        d = sc.nextInt();   // 초밥의 가짓수
        k = sc.nextInt();   // 연속해서 먹는 접시 수
        c = sc.nextInt();   // 쿠폰 번호
        int[] map = new int[N];
//        ArrayList<Integer> map = new ArrayList<>();
        ArrayList<Integer> chobaps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextInt();
//            map.add(sc.nextInt());
            if (!chobaps.contains(map[i])) chobaps.add(map[i]);
        }

        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < N; i++) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int j = 0; j < k; j++) {
//                int idx = (i+j)%N;
//                if (!list.contains(map.get(idx))) list.add(map.get(idx));
//            }
//            if (list.size() >= result) {
//                if (!list.contains(c)) result = list.size()+1;
//                else result = list.size();
//            }
//
//            System.out.println(Arrays.toString(list.toArray()));
//        }


        ArrayList<Integer> list = new ArrayList<>();
        for (int end = 0; end < N; end++) {
            if (!list.contains(map[end])) list.add(map[end]);
            if (end >= k) {
                if (list.size() >= result) {
                    if (!list.contains(c)) result = list.size()+1;
                    else result = list.size();
                }
                list.remove(0);
            }
        }

        System.out.println(result);
    }
}
//1 29 1 3 1 2 1 1 2 29
// 7 9 7 30 2 7 9 25