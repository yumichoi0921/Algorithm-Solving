package Algorithm.shortest_path;

import java.util.Scanner;

// 플로이드 워샬
public class Floyd_Warshall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 노드 수
        int[][] edge = new int[N][N];  // 간선 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                edge[i][j] = sc.nextInt();
            }
        }

        // i->j로 바로가는 것과
        // i -> k-> j로 거쳐가는 것 비교
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i==k || j==k || i==j) continue;
                    edge[i][j] = Math.min(edge[i][j], edge[i][k]+edge[k][j]);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(edge[i][j]+" ");
            }
            System.out.println();
        }



    }
}
