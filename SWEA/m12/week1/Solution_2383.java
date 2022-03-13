package SWEA.m12.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 점심 식사시간
// 조합
// 시뮬레이션
public class Solution_2383 {
    static int N, result;
    static int[][] map;
    static ArrayList<int[]> person, stair;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            person = new ArrayList<>();
            stair = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 1) person.add(new int[]{i, j});
                    else if (map[i][j] > 1) stair.add(new int[]{i, j, map[i][j]});
                }
            }

            result = Integer.MAX_VALUE;
            combination(0, new int[person.size()]);
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void combination(int idx, int[] selected) {
        if (idx == person.size()) {
            result = Math.min(result, calculate(selected));
            return;
        }

        for (int i = 0; i < 2; i++) {
            selected[idx] = i;
            combination(idx + 1, selected);
        }

    }

    private static int calculate(int[] selected) {
        // selected -> 몇번 계단을 이용할 것인지 저장된 배열
        ArrayList<int[]>[] waitingList = new ArrayList[2];
        waitingList[0] = new ArrayList<>(); // 0번 계단 대기 리스트
        waitingList[1] = new ArrayList<>(); // 1번 계단 대기 리스트

        // 각 계단까지 가는데 걸리는 시간
        for (int i = 0; i < selected.length; i++) {
            if (selected[i] == 0) {
                int distance = Math.abs(person.get(i)[0] - stair.get(0)[0]) + Math.abs(person.get(i)[1] - stair.get(0)[1]);
                waitingList[0].add(new int[]{i, distance});
            } else {
                int distance = Math.abs(person.get(i)[0] - stair.get(1)[0]) + Math.abs(person.get(i)[1] - stair.get(1)[1]);
                waitingList[1].add(new int[]{i, distance});
            }
        }

        // 각 계단까지 가는데 걸리는 시간 빠른 순서대로 정렬
        for (int i = 0; i < waitingList.length; i++) {
            Collections.sort(waitingList[i], new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
        }

        ArrayList<int[]>[] stairs = new ArrayList[2];   // 현재 계단에 있는 사람 리스트
        stairs[0] = new ArrayList<>();
        stairs[1] = new ArrayList<>();
        boolean[] isFinished = new boolean[person.size()]; // 계단을 내려가는 사람 true
        int breakPoint = 0; // 계단을 다 내려온 사람 수
        int second = 0; // 초
        while (true) {
            second++;

            // 계단까지 가는데 걸리는 시간 감소
            for (int i = 0; i < waitingList.length; i++) {
                for (int j = 0; j < waitingList[i].size(); j++) {
                    waitingList[i].get(j)[1]--;
                }
            }

            // 계단을 내려가는데 필요한 시간 감소
            for (int i = 0; i < stairs.length; i++) {
                for (int j = 0; j < stairs[i].size(); j++) {
                    stairs[i].get(j)[1]--;
                }
            }

            // 만약 계단을 다 내려왔으면 계단에 있는 사람 리스트에서 제거 && 계단을 다 내려온 사람 수 증가
            for (int i = 0; i < stairs.length; i++) {
                for (int j = 0; j < stairs[i].size(); j++) {
                    if (stairs[i].get(j)[1] == 0) {
                        stairs[i].remove(j);
                        breakPoint++;
                        j--;
                    }
                }
            }

            // 대기 리스트에서 계단에 도착한 사람이 있고 계단이 다 차지 않았으면 계단리스트에 추가 && 계단 내려가는 사람 true
            for (int i = 0; i < waitingList.length; i++) {
                for (int j = 0; j < waitingList[i].size(); j++) {
                    if (waitingList[i].get(j)[1] < 0 && stairs[i].size() < 3) {
                        if (stairs[i].size() < 3) {
                            stairs[i].add(new int[]{waitingList[i].get(j)[0], stair.get(i)[2]});
                            isFinished[waitingList[i].get(j)[0]] = true;
                        }
                    }
                }
            }

            // 계단을 내려가는 사람이면 대기리스트에서 삭제
            for (int i = 0; i < waitingList.length; i++) {
                for (int j = 0; j < waitingList[i].size(); j++) {
                    if (isFinished[waitingList[i].get(j)[0]]) {
                        waitingList[i].remove(j);
                        j--;
                    }
                }
            }

            // 모든 사람이 다 내려왔으면 종료
            if (breakPoint == person.size()) break;
        }

        return second;
    }
}
