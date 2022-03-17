package Programmers.y22.m3.w2;

import java.util.ArrayList;
import java.util.Arrays;

public class 신규아이디추천 {
    static ArrayList<Character> lowerCase = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    static ArrayList<Character> upperCase = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
    static ArrayList<Character> chars = new ArrayList<>(Arrays.asList('-', '_', '.'));
    static ArrayList<Character> digit = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

    public static void main(String[] args) {
        System.out.println(solution("=.="));
    }

    public static String solution(String new_id) {
        ArrayList<Character> id = new ArrayList<>();
        for (int i = 0; i < new_id.length(); i++) {
            id.add(new_id.charAt(i));
        }
        // 1단계: new_id의 모든 대문자를 대응되는 소문자로 치환
        for (int i = 0; i < id.size(); i++) {
            if (upperCase.contains(id.get(i))) {
                int idx = upperCase.indexOf(id.get(i));
                id.set(i, lowerCase.get(idx));
            }
        }
        // 2단계: new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        for (int i = 0; i < id.size(); i++) {
            if (!lowerCase.contains(id.get(i)) && !digit.contains(id.get(i)) && !chars.contains(id.get(i))) {
                id.remove(i);
                i--;
            }
        }
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for (int i = 0; i < id.size(); i++) {
            if (id.get(i) == '.') {
                if (i + 1 < id.size() && id.get(i + 1) == '.') {
                    id.remove(i);
                    i--;
                }
            }
        }
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (!id.isEmpty() && id.get(0) == '.') id.remove(0);
        if (!id.isEmpty() && id.get(id.size() - 1) == '.') id.remove(id.size() - 1);
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (id.isEmpty()) id.add('a');
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (id.size() > 15) {
            for (int i = id.size() - 1; i >= 15; i--) {
                id.remove(i);
            }
        }
        if (id.get(id.size() - 1) == '.') id.remove(id.size() - 1);
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (id.size() <= 2) {
            while (id.size() < 3) id.add(id.get(id.size() - 1));
        }

        String answer = "";
        for (int i = 0; i < id.size(); i++) {
            answer += id.get(i).toString();
        }
        return answer;
    }
}
