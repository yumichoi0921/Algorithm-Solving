package Programmers;

// 3개만 비교하면 되니까
// 3개 중에 max값을 고르고
// 나머지 값이 max랑 같은지 비교하는 방법도 있음

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] result = {{1, 0}, {2, 0}, {3, 0}};
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length; i++) {
            if (p1[i % p1.length] == answers[i]) result[0][1]++;
            if (p2[i % p2.length] == answers[i]) result[1][1]++;
            if (p3[i % p3.length] == answers[i]) result[2][1]++;
        }

        Arrays.sort(result, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(result[0][0]);
        for(int i = 1; i < result.length; i++) {
            if(result[i][1] == result[0][1]) {
                answerList.add(result[i][0]);
            }
        }

        answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
