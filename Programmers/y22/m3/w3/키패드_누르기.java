package Programmers.y22.m3.w3;

public class 키패드_누르기 {
    public static void main(String[] args) {

    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        char[][] keypad = new char[][]{{'1', '2', '3'}, {'4', '5', '6',}, {'7', '8', '9'}, {'*', '0', '#'}};    // 키패드 배열
        int[] leftPos = {3, 0};     // 왼손 최초 위치
        int[] rightPos = {3, 2};    // 오른손 최초 위치
        for (int n = 0; n < numbers.length; n++) {
            String touch = "";      // 터치한 손
            int[] tempPos = new int[2]; // 눌러야 하는 번호의 위치
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (numbers[n] == keypad[i][j] - '0') {
                        tempPos[0] = i;
                        tempPos[1] = j;
                    }
                }
            }
            if (numbers[n] == 1 || numbers[n] == 4 || numbers[n] == 7) {    // 해당하면 왼손으로 터치
                touch = "L";
            } else if (numbers[n] == 3 || numbers[n] == 6 || numbers[n] == 9) { // 해당하면 오른손으로 터치
                touch = "R";
            } else {
                int rightDis = Math.abs(rightPos[0] - tempPos[0]) + Math.abs(rightPos[1] - tempPos[1]); // 오른손까지의 거리
                int leftDis = Math.abs(leftPos[0] - tempPos[0]) + Math.abs(leftPos[1] - tempPos[1]);    // 왼손까지의 거리
                if (leftDis < rightDis) touch = "L";    // 왼손이 더 가까우면 왼손으로 터치
                else if (rightDis < leftDis) touch = "R";   // 오른손이 더 가까우면 오른손으로 터치
                else touch = hand.equals("left") ? "L" : "R";   // 왼손 오른손 거리가 같다면 hand로 터치
            }
            if (touch.equals("L")) {    // 왼소으로 터치했다면 왼손 현재 위치 변경
                leftPos[0] = tempPos[0];
                leftPos[1] = tempPos[1];
            } else {                    // 오른손으로 터치했다면 오른손 현재 위치 변경
                rightPos[0] = tempPos[0];
                rightPos[1] = tempPos[1];
            }
            answer += touch;    // 터치한 손 더하기
        }
        return answer;
    }
}
