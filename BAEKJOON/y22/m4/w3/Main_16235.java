// 나무제테크
// LinkedList의 경우 순회를 할때 for문보다 for-each문이 훨씬 빠르다.
// 각각을 add 하는 것보다 리스트를 생성하여 addAll하는 것이 빠름
package BAEKJOON.y22.m4.w3;

import java.util.*;

public class Main_16235 {
    static int N, M, K;
    static int[][] A;
    static int[][] food;
    static LinkedList<Tree> trees;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        food = new int[N][N];
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(food[i], 5);
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        trees = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            trees.add(new Tree(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
        }
        Collections.sort(trees);

        while (K > 0) {
            Iterator<Tree> treesIter = trees.iterator();
            LinkedList<Tree> deadTrees = new LinkedList<>();
            // 봄
            while (treesIter.hasNext()) {
                Tree tree = treesIter.next();
                if (food[tree.r][tree.c] - tree.age >= 0) {
                    food[tree.r][tree.c] -= tree.age;
                    tree.age++;
                } else {
                    deadTrees.add(tree);
                    treesIter.remove();
                }
            }

            // 여름
            Iterator<Tree> deadTreesIter = deadTrees.iterator();
            while (deadTreesIter.hasNext()) {
                Tree tree = deadTreesIter.next();
                food[tree.r][tree.c] += tree.age / 2;
            }
            // 가을
            LinkedList<Tree> newTrees = new LinkedList<>();
            for (Tree tree : trees) {
                if (tree.age % 5 != 0) continue;
                for (int d = 0; d < 8; d++) {
                    int nr = tree.r + dr[d];
                    int nc = tree.c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        newTrees.add(0, new Tree(nr, nc, 1));
                    }
                }
            }
            trees.addAll(0, newTrees);

            // 겨울
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    food[i][j] += A[i][j];
                }
            }

            K--;
        }

        int ans = trees.size();
        System.out.println(ans);
    }

    static class Tree implements Comparable<Tree> {
        int r, c, age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}