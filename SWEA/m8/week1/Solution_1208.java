package SWEA.m8.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/SWEA/input.txt");
        Scanner sc = new Scanner(file);

        for (int tc = 1; tc <= 10 ; tc++) {
            int dump = sc.nextInt();
            // 방법 1
//            int[] box = new int[101];
//            for (int i = 1; i <= 100; i++) {
//                box[i] = sc.nextInt();
//            }
//
//            int[] idx = new int[2];
//            int diff = 0;
//            while (dump > 0) {
//                idx = searchMaxMin(box);
//                if (box[idx[1]]-box[idx[0]] <= 1) {
//                    diff = box[idx[1]]-box[idx[0]];
//                    break;
//                } else {
//                    box[idx[0]]+=1;
//                    box[idx[1]]-=1;
//                }
//                dump-=1;
//                if (dump == 0) {
//                    idx = searchMaxMin(box);
//                    diff = box[idx[1]]-box[idx[0]];
//                }

            // 방법 2
            int[] box = new int[100];
            for (int i = 0; i < box.length; i++) {
                box[i] = sc.nextInt();
            }
            Arrays.sort(box);
            while (dump > 0) {
                box[0]++;
                box[box.length-1]--;
                Arrays.sort(box);
                dump--;
            }
            int diff = box[box.length-1]-box[0];
            System.out.printf("#%d %d\n", tc, diff);
        }
    }

//    private static int[] searchMaxMin(int[] box) {
//        int min = 101, max = 0;
//        int minIdx = 101, maxIdx = 0;
//        for (int i = 1; i <= 100 ; i++) {
//            if (box[i] >= max) {
//                max = box[i];
//                maxIdx = i;
//            }
//            if (box[i] <= min) {
//                min = box[i];
//                minIdx = i;
//            }
//        }
//        int[] idx = {minIdx, maxIdx};
//        return idx;
//    }
}
