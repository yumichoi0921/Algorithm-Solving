package Programmers.y22.m3.w3;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    public static void main(String[] args) {

    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();      // 뽑은 인형 담을 바구니
        for (int i = 0; i < moves.length; i++) {    // 뽑을 만큼 반복
            int pos = moves[i] - 1;                 // 좌우위치
            int doll = 0;                           // 뽑은 인형 종류
            for (int j = 0; j < board.length; j++) {
                if (board[j][pos] != 0) {           // 뽑을 인형 만나면
                    doll = board[j][pos];           // 인형에 번호 저장
                    board[j][pos] = 0;              // 해당 위치 빈칸으로
                    break;
                }
            }

            if (doll != 0) {                        // 뽑을 인형이 있었다면
                int bottom = basket.size() > 0 ? basket.peek() : 0; // 바구니에 제일 위에 있는 인형
                if (doll == bottom) {   // 지금 넣을 인형과 바구니 제일 위에 있는 인형이 같다면
                    basket.pop();       // 바구니 제일 위의 인형 제거
                    answer += 2;        // 인형 터짐 2개 (지금 넣을 인형 + 바구니 제일 위 인형)
                } else {                // 다르다면
                    basket.push(doll);  // 지금 인형 바구니에 추가
                }
            }
        }
        return answer;
    }
}
