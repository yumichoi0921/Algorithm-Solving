// 이차원 배열과 연산
// 시뮬레이션
package BAEKJOON.y22.m6.w3;

import java.util.*;

public class Main_17140 {
    static int r, c, k;
    static int rs, cs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        k = sc.nextInt();
        rs = 3;
        cs = 3;
        int[][] map = new int[rs][cs];
        for (int i = 0; i < rs; i++) {
            for (int j = 0; j < cs; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0;
        while (true) {
            if (r < rs && c < cs && map[r][c] == k) break;
            if (time > 100) break;  // 100초가 넘으면

            time++;
            if (rs >= cs) {
                map = operation(rs, cs, map, 0);
            } else {
                map = operation(cs, rs, map, 1);
            }
        }
        time = time > 100 ? -1 : time;
        System.out.println(time);

    }

    private static int[][] operation(int fixedSize, int varSize, int[][] map, int op) {
        int newSize = varSize;  // 새로 변할 사이즈
        List<List<Map.Entry<Integer, Integer>>> lines = new LinkedList<>(); // 키는 숫자, 값은 갯수
        for (int i = 0; i < fixedSize; i++) {
            Map<Integer, Integer> line = new HashMap<>();
            for (int j = 0; j < varSize; j++) {
                if (op == 0) {  // r연산
                    if (map[i][j] == 0) continue;
                    if (line.containsKey(map[i][j])) line.put(map[i][j], line.get(map[i][j]) + 1);  // 이미 등장한 수라면 갯수 증가
                    else line.put(map[i][j], 1);                                                    // 처음 등장한 수라면 갯수 1
                } else {        // c연산
                    if (map[j][i] == 0) continue;
                    if (line.containsKey(map[j][i])) line.put(map[j][i], line.get(map[j][i]) + 1);
                    else line.put(map[j][i], 1);
                }

            }
            List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(line.entrySet());  // 맵 정렬
            entries.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if (o1.getValue() == o2.getValue()) return o1.getKey() - o2.getKey();   // 갯수가 같다면 숫자로 비교
                    else return o1.getValue() - o2.getValue();                              // 갯수 오름차순
                }
            });
            lines.add(entries);
            newSize = Math.max(newSize, entries.size() * 2 <= 100 ? entries.size() * 2 : 100);  // 라인의 최대 사이즈를 새로 변하는 사이즈로, 100이 넘으면 100
        }

        int[][] newMap;
        if (op == 0) {  // r연산
            newMap = new int[fixedSize][newSize];
            cs = newSize;
        } else {    // c연산
            newMap = new int[newSize][fixedSize];
            rs = newSize;
        }

        for (int i = 0; i < lines.size(); i++) {
            List<Map.Entry<Integer, Integer>> line = lines.get(i);
            for (int j = 0; j < line.size(); j++) {
                if (j * 2 == 100) break;    // 100개 넘으면 버림
                if (op == 0) {              // r연산
                    newMap[i][j * 2] = line.get(j).getKey(); // 짝수에는 수 저장
                    newMap[i][j * 2 + 1] = line.get(j).getValue();  // 홀수에는 갯수 저장
                } else {                    // c연산
                    newMap[j * 2][i] = line.get(j).getKey();
                    newMap[j * 2 + 1][i] = line.get(j).getValue();
                }
            }
        }
        return newMap;
    }
}

