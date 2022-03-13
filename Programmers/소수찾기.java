package Programmers;
// 2는 소수란다..
// n개 중 r개 고르는 순열..
// 순열은 r개 골라서 정렬하는 것
// 모든 부분집합 구하기 + 부분집합 크기(r개) 순열 ->
// r은 1-n일 때 순열이 쉽겠지?

// 소수 판별 알고리즘
// 1: 2부터 판별하는 수 전까지 나눠보고 나머지가 0이 안나온다면 소수로 정의 -> O(N)
// 2: 2부터 판별하는 수의 절반까지 나눠보고 나머지가 0이 안나온다면 소수로 정의 -> O(N)
// 3: 2에서부터 √N까지 나눠보고 나머지가 0이 안나온다면 소수로 정의 -> O(√N)
// 에라토스테네스의 체: 1-n까지 소수 몇개?
// 2제외 2의 배수에 해당하는 숫자 지움
// 3제외 3의 배수에 해당하는 숫자 지움
// ..n제외 n의 배수에 해당하는 숫자 지움
// 남은 수가 소수
import java.util.ArrayList;

public class 소수찾기 {
    static int answer;
    static ArrayList<Integer> numberList;
    public int solution(String numbers) {
        answer = 0;
        numberList = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            permutation(numbers, new boolean[numbers.length()], "",  i+1);
        }
        for (int i = 0; i < numberList.size(); i++) {
            isPrimeNumber(numberList.get(i));
        }
        return answer;
    }

    private void permutation(String numbers, boolean[] selected, String number, int size) {
        if (number.length() == size) {
            System.out.println(number);
            int num = Integer.parseInt(number);
            if (!numberList.contains(num)) {
                numberList.add(num);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                number += numbers.charAt(i);
                permutation(numbers, selected, number, size);
                selected[i] = false;
                number = number.substring(0, number.length()-1);
            }
        }
    }

    private void isPrimeNumber(int num) {
        if (num < 2) return;
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
          if (num != 2 && num%i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) answer++;
    }
}



