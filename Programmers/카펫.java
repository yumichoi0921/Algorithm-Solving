package Programmers;
// 전체 = yellow + brown
// yellow = 넓이-2 * 높이-2
// brown = 전체 - yellow
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        for(int garo = yellow; garo > 0; garo--) {
            if((yellow % garo) != 0) continue;
            int sero = yellow/garo;
            int cnt = garo*2 + sero*2 + 4;
            if(cnt == brown) {
                answer[0] = garo+2;
                answer[1] = sero+2;
                break;
            }
        }
        return answer;
    }
}
