package study_0121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_1436_¿µÈ­°¨µ¶¼ò {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int answer = 0;
		int number = 665;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		while(answer<N) {
			number++;
			if((number+"").contains("666")) {
				answer++;
			}
		}
		
		System.out.println(number);
	}
}
