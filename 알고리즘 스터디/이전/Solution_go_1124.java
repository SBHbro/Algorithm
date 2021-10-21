package algo_study_1124;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_go_1124 {
	
	public static void main(String[] args) {
		String input = "103 123 4444 99 2000";
		String input2 = "11 11 2 2000 2 10003 22 31 123 4 1234000 44444444 9999";
		String input3 = "105 1023";
		solution(input3);
		
		System.out.println("3000".compareTo("01"));
		
	}
	
	public static void solution(String input) {
		System.out.println(input);
		StringTokenizer st = new StringTokenizer(input);
		int inputNum = st.countTokens();
		
		String[] first = new String[inputNum];
		int[] second = new int[inputNum];
		
		for(int i = 0 ; i<inputNum;i++) {
			first[i] = st.nextToken();
			for(int j = 0 ; j<first[i].length();j++) {
				second[i] += first[i].charAt(j)-'0';
			}
		}
		
		for(int i = 0 ;i<first.length;i++) {
			for(int j = 1 ;j<first.length;j++) {
				if(second[j-1]>second[j]) {
					int temp = second[j-1];
					second[j-1] = second[j];
					second[j] = temp;
					String temp2 = first[j-1];
					first[j-1] = first[j];
					first[j] = temp2;
				}
				else if(second[j-1]==second[j]) {
					if(first[j-1].compareTo(first[j])>=1) {
						int temp = second[j-1];
						second[j-1] = second[j];
						second[j] = temp;
						String temp2 = first[j-1];
						first[j-1] = first[j];
						first[j] = temp2;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(first));
		System.out.println(Arrays.toString(second));
	}
	
}
