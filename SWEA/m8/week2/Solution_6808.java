package SWEA.m8.week2;

import java.util.*;

public class Solution_6808 {
    static int resW;
    static int resL;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            List<Integer> myCard = new ArrayList<>();
            List<Integer> otherCard = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                myCard.add(sc.nextInt());
            }
            for (int i = 1; i <= 18; i++) {
                if (!myCard.contains(i)) otherCard.add(i);
            }

            resW = 0; resL = 0;
            permutation(myCard, otherCard, new int[9], new boolean[9], 0);
            System.out.printf("#%d %d %d\n", tc, resW, resL);
        }
    }

    private static void permutation(List<Integer> myCard, List<Integer> otherCard, int[] card, boolean[] isSelected, int idx) {
        if (idx == otherCard.size()) {
            game(myCard, card);
            return;
        }
        for (int i = 0; i < otherCard.size(); i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                card[idx] = otherCard.get(i);
                permutation(myCard, otherCard, card, isSelected, idx+1);
                isSelected[i] = false;
            }
        }
    }

    private static void game(List<Integer> myCard, int[] card) {
        int myV = 0, oV = 0;
        for (int j = 0; j < myCard.size(); j++) {
            if (myCard.get(j) > card[j]) {
                myV += myCard.get(j)+card[j];
            } else if (myCard.get(j) < card[j]) {
                oV += myCard.get(j)+card[j];
            }
        }
        if (myV > oV) resW++;
        else if (myV < oV) resL++;
    }
}
