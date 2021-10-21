package study_0907;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Solution_P_가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		
		System.out.println(solution(numbers));
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        
        //앞글자 순서
        String[] answerArray = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			answerArray[i] = numbers[i] + "";
		}

		Arrays.sort(answerArray, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
		});

		for (int i = 0; i < answerArray.length; i++) {
			answer += answerArray[i];
		}
		if(answer.charAt(0)=='0')return "0";
		return answer;
    }
}
