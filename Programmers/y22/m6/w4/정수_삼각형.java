package Programmers.y22.m6.w4;

public class 정수_삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j + 0], triangle[i + 1][j + 1]);
            }
        }

        answer = triangle[0][0];

        return answer;
    }
}
