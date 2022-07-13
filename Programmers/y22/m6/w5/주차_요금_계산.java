package Programmers.y22.m6.w5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 주차_요금_계산 {

    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Record> parking = new HashMap<>();             // 주차장
        Map<Integer, Integer> parkingDuration = new HashMap<>();    // 총 주차시간 저장

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            int number = Integer.parseInt(record[1]);   // 차량번호
            if (!parkingDuration.containsKey(number)) parkingDuration.put(number, 0);   // 처음 주차시간을 0으로

            if (parking.containsKey(number)) {  // 이미 주차되어 있는 차라면
                String[] inTime = parking.get(Integer.parseInt(record[1])).time.split(":");
                String[] outTime = record[0].split(":");
                int duration = getDuration(inTime, outTime);    // 주차시간 구하기
                parkingDuration.put(number, parkingDuration.get(number) + duration);    // 총 주차시간에 더함
                parking.remove(number);         // 나간 차는 제거
            } else {
                parking.put(number, new Record(record[0], number));  // 주차가 안되어 있으면 주차장에 시간과 주차번호 저장
            }
        }

        for (Map.Entry<Integer, Record> record : parking.entrySet() // 아직 주차장에 남은 차들에 대해
        ) {
            String[] inTime = record.getValue().time.split(":");
            String[] outTime = {"23", "59"};
            int duration = getDuration(inTime, outTime);    // 23:59까지의 주차시간
            parkingDuration.put(record.getKey(), parkingDuration.get(record.getKey()) + duration);  // 총 주차시간에 추가
        }


        Object[] numbers = parkingDuration.keySet().toArray();  // 키인 차량 번호를
        Arrays.sort(numbers);                                   // 오름차순 정렬

        int[] answer = new int[parkingDuration.size()];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = calculate(fees, parkingDuration.get(numbers[i]));   // 주차비 구하기
        }
        return answer;
    }

    private int getDuration(String[] inTime, String[] outTime) {
        int hourDiff = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);  // 시간차
        int minDiff = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);   // 분차
        if (minDiff < 0) {  // 3분-15분
            hourDiff--;
            minDiff += 60;
        }
        return 60 * hourDiff + minDiff; // 주차시간을 분으로
    }

    private int calculate(int[] fees, int duration) {
        if (duration <= fees[0]) {  // 기본시간보다 작을 경우
            return fees[1];
        } else {
            return (int) (fees[1] + Math.ceil((duration - fees[0]) / (double) fees[2]) * fees[3]);
        }
    }

    class Record {
        String time;
        int number;

        public Record(String time, int number) {
            this.time = time;
            this.number = number;
        }
    }
}
