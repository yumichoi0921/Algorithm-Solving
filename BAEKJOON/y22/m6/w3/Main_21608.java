// 상어초등학교
// 시뮬레이션
package BAEKJOON.y22.m6.w3;

import java.util.*;

public class Main_21608 {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static LinkedHashMap<Integer, List<Integer>> studentInfo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        studentInfo = new LinkedHashMap<>();
        for (int i = 1; i <= N * N; i++) {
            int stNum = sc.nextInt();   // 학생 번호
            List<Integer> favoriteNums = new LinkedList<>();    // 좋아하는 학생 번호
            for (int j = 0; j < 4; j++) {
                favoriteNums.add(sc.nextInt());
            }
            studentInfo.put(stNum, favoriteNums);   // 학생번호-좋아하는 학생번호 리스트

            List<int[]> candidate = stepOne(favoriteNums);   // 비어있는 칸중에서 주변에 좋아하는 학생이 가장 많은 칸
            if (candidate.size() == 1) {    // 후보칸이 하나이면 여기에 앉힘
                map[candidate.get(0)[0]][candidate.get(0)[1]] = stNum;
                continue;
            }

            candidate = stepTwo(candidate); // 후보칸이 여러 개면 후보칸의 주변 칸중에 비어있는 칸이 가장 많은 칸
            if (candidate.size() == 1) {    // 후보칸이 하나면 여기에 앉힘
                map[candidate.get(0)[0]][candidate.get(0)[1]] = stNum;
                continue;
            }

            Collections.sort(candidate, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];   // 행번호가 같다면 열번호 순으로 오름차순 정렬
                    else return o1[0] - o2[0];                  // 행번호 순으로 오름차순 정렬
                }
            });
            map[candidate.get(0)[0]][candidate.get(0)[1]] = stNum;  // 행-열 번호가 가장 작은 칸에 앉힘
        }


        // 만족도
        int answer = 0;

        HashMap<Integer, Integer> score = new HashMap<>();
        score.put(0, 0);
        score.put(1, 1);
        score.put(2, 10);
        score.put(3, 100);
        score.put(4, 1000);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;
                    if (studentInfo.get(map[i][j]).contains(map[nr][nc])) cnt++;
                }
                answer += score.get(cnt);
            }
        }

        System.out.println(answer);
    }

    private static List stepTwo(List<int[]> candidates) {
        int[][] tmpMap = new int[N][N]; // 해당 칸 주변에 빈 칸이 몇개인지 저장
        for (int[] pos : candidates) {  // 후보칸만 고려
            for (int d = 0; d < 4; d++) {
                int nr = pos[0] + dr[d];
                int nc = pos[1] + dc[d];
                if (!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;
                if (map[nr][nc] == 0) tmpMap[pos[0]][pos[1]]++; // 주변에 빈 칸이 있으면 값 증가
            }
        }

        int max = 0;
        List<int[]> answer = new ArrayList<>();
        for (int[] pos : candidates) {  // 후보칸만 고려
            if (tmpMap[pos[0]][pos[1]] > max) {
                max = tmpMap[pos[0]][pos[1]];
                answer.clear();
                answer.add(new int[]{pos[0], pos[1]});
            } else if (tmpMap[pos[0]][pos[1]] == max) {
                answer.add(new int[]{pos[0], pos[1]});
            }
        }

        return answer;
    }

    private static List stepOne(List<Integer> favoriteNums) {
        int[][] tmpMap = new int[N][N]; // 해당 칸 주변에 좋아하는 학생이 몇명인지 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) continue;   // 빈칸만 고려
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;
                    if (favoriteNums.contains(map[nr][nc])) tmpMap[i][j]++; // 주변에 좋아하는 학생이 있으면 값 증가
                }
            }
        }

        int max = 0;
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) continue;   // 이미 학생이 앉은 칸은 후보로 고려하지 않음
                if (tmpMap[i][j] > max) {
                    max = tmpMap[i][j];
                    answer.clear();
                    answer.add(new int[]{i, j});
                } else if (tmpMap[i][j] == max) {
                    answer.add(new int[]{i, j});
                }
            }
        }

        return answer;
    }
}
