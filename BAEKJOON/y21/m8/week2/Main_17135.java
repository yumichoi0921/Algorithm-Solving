package BAEKJOON.y21.m8.week2;

import java.util.*;

public class Main_17135 {
    static int N;
    static int M;
    static int D;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        List<int[]> enemy = new ArrayList<>();  // 모든 적의 위치
        List<int[]> archerLoc = new ArrayList<>();  // 궁수가 있을 수 있는 위치
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (sc.nextInt() == 1) enemy.add(new int[]{i, j});
            }
        }
        for (int i = 1; i <= M; i++) {
            archerLoc.add(new int[]{N + 1, i});
        }

        res = 0;
        combination(enemy, archerLoc, new int[3][2], 0, 0); // 궁수 위치 3개 조합중 최대로 죽일 수 있는 적의 수 계산
        System.out.println(res);
    }

    private static void combination(List<int[]> enemy, List<int[]> archerLoc, int[][] select, int start, int idx) {
        if (idx == select.length) {
            res = Math.max(res, cal(enemy, select));    // 각 조합에서 죽일 수 있는 적의 수 중에서 최대
            return;
        }

        for (int i = start; i < archerLoc.size(); i++) {
            select[idx] = archerLoc.get(i);
            combination(enemy, archerLoc, select, i + 1, idx + 1);
        }
    }

    private static int cal(List<int[]> enemy, int[][] select) {
        List<int[]> enemyList = new ArrayList<>();  // 모든 적의 위치
        for (int[] e : enemy) enemyList.add(e.clone());
        HashSet<Integer> targetSet = new HashSet<>();   // 화살에 맞은 적의 인덱스
        int deadEnemy = 0;  // 죽은 적의 수

        while (!enemyList.isEmpty()) {  // 적이 남아있다면 루프 계속
            for (int i = 0; i < select.length; i++) {
                int[][] target = {{-1, -1}};    // 0: 적의 인덱스, 1: 적의 col값
                int targetDis = Integer.MAX_VALUE;  // 적과의 최소 거리
                int distance = 0;   // 적과의 거리

                for (int j = 0; j < enemyList.size(); j++) {
                    distance = Math.abs(select[i][0] - enemyList.get(j)[0]) + Math.abs(select[i][1] - enemyList.get(j)[1]);   // j번 적과의 거리
                    if (distance <= D) {
                        if (distance < targetDis) { // 이전 적과의 최소거리보다 작다면 최소거리와 타겟 변경
                            targetDis = distance;
                            target[0][0] = j;
                            target[0][1] = enemyList.get(j)[1];
                        } else if (distance == targetDis) {
                            if (enemyList.get(j)[1] < target[0][1]) {   // 최소거리 같은데 더 왼쪽에 있는 적이라면 타겟 변경
                                target[0][0] = j;
                                target[0][1] = enemyList.get(j)[1];
                            }
                        }
                    }
                }
                if (target[0][0] != -1) targetSet.add(target[0][0]);   // 명중할 타겟이 있다면 타겟셋에 추가
            }

            for (Iterator it = targetSet.iterator(); it.hasNext(); ) {    // 타겟셋에 있는 적의 row값 N+1로
                int idx = (int) it.next();
                enemyList.get(idx)[0] = N + 1;
            }
            for (Iterator it = enemyList.iterator(); it.hasNext(); ) {    // 모든 적의 위치 row+1, 만약 적의 위치가 지역 N을 벗어나면(타겟 포함) 리스트에서 삭제
                int[] tmp = (int[]) it.next();
                tmp[0]++;
                if (tmp[0] > N) {
                    it.remove();
                }
            }
            deadEnemy += targetSet.size();  // 타겟셋에 있던 적을 죽인 적으로 추가
            targetSet.clear();  // 타겟셋 조기화
        }

        return deadEnemy;
    }

}
