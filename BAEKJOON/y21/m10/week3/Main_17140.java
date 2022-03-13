package BAEKJOON.y21.m10.week3;

import java.util.*;
// 이차원 배열과 연산
// 시뮬레이션
public class Main_17140 {
    static class Point implements Comparable<Point> {
        int num, cnt;

        public Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            if (this.cnt == o.cnt) {
                return this.num-o.num;
            }
            return this.cnt-o.cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return num == point.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }
    static int R, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int k = sc.nextInt();

        R = 3;
        C = 3;
        int[][] arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        while (true) {
            if (r<R&&c<C&&arr[r][c] == k) {
                break;
            }
            if (cnt > 100) {
                cnt = -1;
                break;
            }
            if (R>=C) {
                arr = makeNewArr1(arr);
            } else {
                arr = makeNewArr2(arr);
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static int[][] makeNewArr1(int[][] arr) {
        // 숫자와 등장 횟수 계산
        ArrayList<Point>[] list = new ArrayList[R]; // 행마다 리스트 만들기
        for (int i = 0; i < R; i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 0) continue;               // 0이면 계산하지 않음
                Point tmp = new Point(arr[i][j], 1);    // 리스트에 같은 수가 있는지 확인
                if (list[i].contains(tmp)) {                // 리스트에 이미 같은 수가 있다면
                    int idx = list[i].indexOf(tmp);         // 리스트에서 그 숫자의 인덱스
                    list[i].get(idx).cnt++;                 // 해당 수에 횟수 증가
                } else {                                    // 없다면
                    list[i].add(tmp);                       // 리스트에 숫자 추가
                }
            }
        }

        int nC = 0;                             // 새로운 행 크기 계산
       for (int i = 0; i < R; i++) {
            Collections.sort(list[i]);          // 횟수 순서 + 숫자 순서대로 정렬
            nC = Math.max(nC, list[i].size());  // 행 리스트의 사이즈가 가장 큰 것
        }

        C = nC*2>=100? 100 : nC*2;                               // 숫자 종류+횟수가 행의 새로운 크기
        int[][] newArr = new int[R][C];
        for (int i = 0; i < R; i++) {           // 배열에 새로운 계산한 결과 넣기
            int size = list[i].size();
            for (int j = 0; j < size; j++) {
                if (j*2+1 < C) {
                    newArr[i][2*j] = list[i].get(j).num;
                    newArr[i][2*j+1] = list[i].get(j).cnt;
                }
            }

        }
        return newArr;
    }

    private static int[][] makeNewArr2(int[][] arr) {
        // 숫자와 등장 횟수 계산
        ArrayList<Point>[] list = new ArrayList[C]; // 열마다 리스트 만들기
        for (int j = 0; j < C; j++) {
            list[j] = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                if (arr[i][j] == 0) continue;               // 0이면 계산하지 않음
                Point tmp = new Point(arr[i][j], 1);    // 리스트에 같은 수가 있는지 확인
                if (list[j].contains(tmp)) {                // 리스트에 이미 같은 수가 있다면
                    int idx = list[j].indexOf(tmp);         // 리스트에서 그 숫자의 인덱스
                    list[j].get(idx).cnt++;                 // 해당 수에 횟수 증가
                } else {                                    // 없다면
                    list[j].add(tmp);                       // 리스트에 숫자 추가
                }
            }
        }

        int nR = 0;                             // 새로운 열 크기 계산
        for (int j = 0; j < C; j++) {
            Collections.sort(list[j]);          // 횟수 순서 + 숫자 순서대로 정렬
            nR = Math.max(nR, list[j].size());  // 행 리스트의 사이즈가 가장 큰 것
        }

        R = nR*2>=100? 100 : nR*2;                               // 숫자 종류+횟수가 행의 새로운 크기
        int[][] newArr = new int[R][C];
        for (int j = 0; j < C; j++) {           // 배열에 새로운 계산한 결과 넣기
            int size = list[j].size();
            for (int i = 0; i < size; i++) {
                if (i*2+1 < R) {
                    newArr[i*2][j] = list[j].get(i).num;
                    newArr[i*2+1][j] = list[j].get(i).cnt;
                }
            }

        }
        return newArr;
    }
    private static void print(int[][] arr) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
