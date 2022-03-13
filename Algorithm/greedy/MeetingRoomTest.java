package Algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomTest {
	
	static class Meeting implements Comparable<Meeting> {
		int start, end;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			
			int value = this.end - o.end;
			// 종료시간이 다르면 종료시간이 빠른 순서로
			if (value != 0) return value;
			// 종료시간이 같다면 시작시간이 빠른 순서로
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < meetings.length; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		for (Meeting meeting : getSchedule(meetings)) {
			System.out.println(meeting);
		}
	}
	
	static ArrayList<Meeting> getSchedule(Meeting[] meetings) {
		ArrayList<Meeting> list = new ArrayList<Meeting>();
		// 종료시간 기준 오름차순 정렬
		Arrays.sort(meetings);
		// 첫회의 추가
		list.add(meetings[0]);
		
		for (int i = 1; i < meetings.length; i++) {
			if (list.get(list.size()-1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
	}

}
