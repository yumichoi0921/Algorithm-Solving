package Programmers.y22.m3.w4;

public class 비밀지도 {

    // 시간은 이게 더 빠름
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder a1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder a2 = new StringBuilder(Integer.toBinaryString(arr2[i]));
            while (a1.length() < n) a1.insert(0, "0");
            while (a2.length() < n) a2.insert(0, "0");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (a1.substring(j, j + 1).equals("0") && a2.substring(j, j + 1).equals("0")) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String result = Integer.toBinaryString(arr1[i] | arr2[i]);
            String format = "%" + n + "s";
            String resultFormat = String.format(format, result);
            resultFormat = resultFormat.replace("1", "#");
            resultFormat = resultFormat.replace("0", " ");
            answer[i] = resultFormat;
        }
        return answer;
    }
}
