package Programmers.y22.m4.w3;

public class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        long answer = 0;
        for (long i = 0; i < w; i++) {  // 여기도  long
            double diagonalH = h * (i + 1) / (double) w;
            long cnt = (long) ((h - diagonalH) / 1);
            answer += cnt;
        }
        return answer * 2;
    }
}
// w, h가 1억 이하이므로 최대 1억 * 1억 고려하면 int로 부족

