package Programmers.y22.m3.w4;

public class 문자열_압축 {
    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int u = 1; u <= s.length(); u++) {
            StringBuilder sb = new StringBuilder();
            String unit = "";   // 단위 문자열
            String tail = "";   // n개로 잘랐을 때 남는 마지막
            int cnt = 0;
            for (int i = 0; i < s.length(); i += u) {
                if (i + u > s.length()) {   // 나머지 문자열을 u개 단위로 자를 수 없을 경우
                    tail = s.substring(i);  // 나머지 문자열 저장
                    break;
                }
                String now = s.substring(i, i + u); // 현재부터 u개 단위 문자열
                if (now.equals(unit)) {             // 단위 문자열과 같다면
                    cnt++;                          // 갯수 증가
                } else {
                    if (cnt > 1) sb.append(cnt);    // 갯수가 1보다 클때만 갯수 추가
                    sb.append(unit);                // 이전 단위 문자열 추가
                    unit = now;                     // 단위 문자열 변경
                    cnt = 1;                        // 갯수 1로 초기화
                }
            }
            // 전체 문자열이 n개 단위로 나눠질 경우
            if (cnt > 1) sb.append(cnt);            // 마지막 단위 문자열의 갯수 추가
            sb.append(unit);                        // 마지막 단위 문자열 추가
            sb.append(tail);                        // 나머지 문자열이 있었을 경우 추가
            answer = Math.min(answer, sb.length()); // 문자열 최솟값
        }
        return answer;
    }
}
