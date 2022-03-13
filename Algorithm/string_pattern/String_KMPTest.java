package Algorithm.string_pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class String_KMPTest {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		// 부분일치테이블 = 실패함수 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		// 패턴 포인터를 어디로 옮겨야 하는지 인덱스 저장
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 우리는 실패함수를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
	        while(j > 0 && pattern[i] != pattern[j]) {
	        	j = pi[j-1];  
	        }
	        // pattern[i] == pattern[[j]
	        if(pattern[i] == pattern[j]) pi[i] = ++j;	// j증가, 패턴 길이 저장
	        // j == 0
	        else pi[i] = 0;								// int배열은 초기값이 0이므로 안해도 됨
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터 
		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1];	// 유효한 곳까지 j 포인터 옮김
			
			if(text[i] == pattern[j]) { //두 글자 일치
				if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면 -> 패턴 글자 모두 일치
					cnt++; // 카운트 증가
					list.add((i+1)-pLength); 
					j=pi[j];	// j==0이 아니라 부분일치 테이블을 이용하여 움직인다. j까지 일치하므로 j까지 일치했을 때 패턴 포인터 위치로 이동
				}else {	// 패턴 일치 중간 과정
					j++;
				}
			}
			// j == 0이면 j는 고정, i만 이동
		}
		
		System.out.println(cnt);
		if(cnt>0) {
			System.out.println(list);
		}
	}

}
