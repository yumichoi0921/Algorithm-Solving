package Programmers.y22.m3.w4;

public class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int hit = 0;
        int guess = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                guess++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    hit++;
                }
            }
        }
        int[] ranking = {6, 6, 5, 4, 3, 2, 1};
        answer = new int[]{ranking[hit + guess], ranking[hit]};
        return answer;
    }
}
