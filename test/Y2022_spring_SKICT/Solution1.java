package Y2022_spring_SKICT;

public class Solution1 {
    static int answer;

    public static void main(String[] args) {

    }

    public int solution(int money, int[] costs) {
        int answer = 0;
        int[] units = {1, 5, 10, 50, 100, 500};
        costs[1] = Math.min(costs[1], costs[0] * 5);
        costs[2] = Math.min(costs[2], costs[2] * 2);
        costs[3] = Math.min(costs[3], costs[3] * 5);
        costs[4] = Math.min(costs[4], costs[4] * 2);
        costs[5] = Math.min(costs[5], costs[5] * 5);
        while (money > 0) {
            int tempCost = Integer.MAX_VALUE;
            int unit = 0;
            for (int c = 0; c < costs.length; c++) {
                if (money >= units[c]) {
                    int tc = costs[c] * (money / units[c]);
                    if (tc < tempCost) {
                        tempCost = tc;
                        unit = c;
                    }
                }
            }
            answer += tempCost;
            money = money % units[unit];
        }
        return answer;
    }


}
