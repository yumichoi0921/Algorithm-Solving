package Programmers.y22.m7.w1;

import java.util.*;

public class 메뉴_리뉴얼 {
    Map<String, Integer> combos;
    List<String> menus;

    public String[] solution(String[] orders, int[] course) {
        combos = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            String[] order = orders[i].split("");
            Arrays.sort(order);
            for (int j = 0; j < course.length; j++) {
                combi(order, course[j], new String[course[j]], 0, 0);
            }
        }
        menus = new LinkedList<>();
        List<Map.Entry<String, Integer>> comboList = new ArrayList<>(combos.entrySet());
        Collections.sort(comboList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getKey().length() == o2.getKey().length()) {
                    return o2.getValue() - o1.getValue();
                }
                return o1.getKey().length() - o2.getKey().length();
            }
        });
        int menulength = 0;
        int menuMaxCnt = 0;
        for (int c = 0; c < comboList.size(); c++) {
            if (comboList.get(c).getValue() < 2) continue;
            if (comboList.get(c).getKey().length() != menulength) {
                menulength = comboList.get(c).getKey().length();
                menuMaxCnt = comboList.get(c).getValue();
            }

            if (comboList.get(c).getValue() < menuMaxCnt) continue;
            menus.add(comboList.get(c).getKey());
        }

        String[] answer = new String[menus.size()];
        Collections.sort(menus);
        for (int i = 0; i < menus.size(); i++) {
            answer[i] = menus.get(i);
        }

        return answer;
    }

    private void combi(String[] order, int course, String[] combo, int start, int idx) {
        if (idx == course) {
            String comboName = String.join("", combo);
            if (combos.containsKey(comboName)) {
                combos.put(comboName, combos.get(comboName) + 1);
            } else {
                combos.put(comboName, 1);
            }
            return;
        }

        for (int i = start; i < order.length; i++) {
            combo[idx] = order[i];
            combi(order, course, combo, i + 1, idx + 1);

        }

    }


}
