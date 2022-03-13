package BAEKJOON.y21.m8.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15686 {
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<int[]> chicken = new ArrayList<>();   // 치킨집 위치
        List<int[]> house = new ArrayList<>(); // 집 위치
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int val = sc.nextInt();
                if (val == 1) house.add(new int[]{i, j});
                else if (val == 2) chicken.add(new int[]{i, j});
            }
        }

        res = Integer.MAX_VALUE;
        combination(house, chicken, new int[M][2], 0, 0);    // 치킨집 조합
        System.out.println(res);
    }

    private static void combination(List<int[]> house, List<int[]> chicken, int[][] select, int start, int idx) {
        if (idx == select.length) { // 치킨집 M개 뽑히면 치킨거리 확인
            res = Math.min(res, cal(house, select)); // 치킨집 조합마다 도시의 치킨거리 계산
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            select[idx] = chicken.get(i);
            combination(house, chicken, select, i + 1, idx + 1);
        }
    }

    private static int cal(List<int[]> house, int[][] select) {
        int tmpRes = 0;
        for (int i = 0; i < house.size(); i++) {
            int tmpD = Integer.MAX_VALUE;
            for (int s = 0; s < select.length; s++) {   // 각 치킨집마다 치킨거리 확인
                // 치킨거리가 최소인 치킨집을 찾고 치킨거리에 저장
                tmpD = Math.min(tmpD, Math.abs(house.get(i)[0] - select[s][0]) + Math.abs(house.get(i)[1] - select[s][1]));
            }
            tmpRes += tmpD;
        }
        return tmpRes;  // 한 조합에서의 최소치킨거리
    }
}
