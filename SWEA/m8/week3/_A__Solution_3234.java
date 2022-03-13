package SWEA.m8.week3;

import java.util.*;
// 순열, 부분집합
public class _A__Solution_3234 {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] weight = new int[N];
            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
            }

            res = 0;
            permutation(weight, new boolean[N], new int[N], 0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    // 무게추 올리는 순서 순열
    private static void permutation(int[] weight, boolean[] isSelected, int[] sequence, int idx) {
        if (idx == sequence.length) {
            subset_isAvailable(sequence, new boolean[sequence.length], 0, 0, 0);
            return;
        }

        for (int i = 0; i < weight.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                sequence[idx] = weight[i];
                permutation(weight, isSelected, sequence, idx+1);
                isSelected[i] = false;
            }
        }
    }

    // 오른쪽 저울에 올릴 무게추를 정하는 부분집합
    // 왼쪽무게 >= 오른쪽 무게
    private static void subset_isAvailable(int[] weight, boolean[] isSelected, int idx, int lw, int rw) {
        if (lw < rw) {  // 왼쪽 저울보다 오른쪽 저울이 더 무거우면 리턴 (방금 무게추는 오른쪽에 올리면 안됨)
            return;
        }
        if (idx == weight.length) { // 왼쪽>=오른쪽을 유지하며 무게추를 저울에 다 올렸으면 리턴
            res++;
            return;
        }

        isSelected[idx] = true; // 지금 무게추를 오른쪽에 올림
        subset_isAvailable(weight, isSelected, idx+1, lw, rw+weight[idx]);  // 지금 뽑은 무게추의 무게를 오른쪽에 더함
        // 리턴해서 돌아오면 방금 뽑은 무게추를 오른쪽에 두면 안됨
        isSelected[idx] = false;    // 지금 무게추를 왼쪽에 올림
        subset_isAvailable(weight, isSelected, idx+1, lw+weight[idx], rw);  // 지금 뽑은 무게추의 무게를 왼쪽에 더함
    }
}
