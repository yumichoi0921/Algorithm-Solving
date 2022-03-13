package BAEKJOON.y21.m11.week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 트럭 
// 구현
public class Main_13335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 다리를 건너는 트럭의 수
        int W = sc.nextInt();   // 다리의 길이
        int L = sc.nextInt();   // 다리 최대하중
        int[] truck = new int[N];
        for (int i = 0; i < N; i++) {
            truck[i] = sc.nextInt();
        }
        int time = 0;
        Queue<int[]> bridge = new LinkedList<>();   // 다리 0:트럭인덱스, 1:다리에서 트럭위치
        int tIdx = 0;   // 현재 트럭 인덱스
        int nL = L;     // 현재 가능 하중
        while (true) {
            time++;
            if (!bridge.isEmpty()) {            // 다리에 트럭이 있다면
                for (int[] t:bridge) {          // 모든 트럭의 위치 증가
                    t[1]++;
                }
                int[] t = bridge.peek();        // 머리에 있는 트럭
                if (t[1] > W) {                 // 트럭이 다시를 벗어났다면
                    bridge.poll();              // 트럭 제거
                    nL += truck[t[0]];          // 가능하중 증가
                }
                if (bridge.isEmpty() && tIdx == N) break;   // 다리가 비었고 남아있는 트럭이 없다면 종료
            }
            if (tIdx < N && bridge.size() < W) {    // 남아있는 트럭이 있고 다리가 꽉 차지 않았다면
              if (nL-truck[tIdx]>=0) {              // 하중이 현재 트럭 무게보다 크다면
                  bridge.add(new int[]{tIdx, 1});   // 다리에 현재 트럭 추가
                  nL -= truck[tIdx];                // 하중이 현재 트럭 무게만큼 감소
                  tIdx++;                           // 다음 트럭
              }
            }
        }
        System.out.println(time);
    }
}
