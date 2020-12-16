package study_1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_2231_ºÐÇØÇÕ {
	
	static int answer;
	static int input;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		input = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(answer>input) {
				answer = 0;
				break;
			}
			
			if(makeNum(answer)==input)
				break;
			
			answer++;
			
		}
		
		System.out.println(answer);
		
	}

	private static int makeNum(int num) {
		String input = Integer.toString(num);
		for(int i = 0 ; i<input.length();i++) {
			num += input.charAt(i)-'0';
		}
		return num;
	}
	
}
