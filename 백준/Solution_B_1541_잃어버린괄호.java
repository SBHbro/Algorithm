package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_B_1541_ÀÒ¾î¹ö¸°°ýÈ£ {

	static String input;
	static int answer;
	static List<Integer> data = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		input = in.readLine();
		

		find();
		
		answer = data.get(0);
		for(int i = 1;i<data.size();i++) {
			answer -=data.get(i);
		}
		System.out.println(answer);
	}

	private static void find() {
		int pointer = 0;
		int save = Integer.MAX_VALUE;
		for(int i = 0 ; i< input.length();i++) {
			char select = input.charAt(i);
			if(select=='+'||select=='-'||input.length()-1 == i) {
				int temp = (input.length()-1==i)?Integer.parseInt(input.substring(pointer, i+1)):Integer.parseInt(input.substring(pointer, i));
				pointer = i+1;
				if(select == '+') {
					save = save==Integer.MAX_VALUE? temp:save+temp;
				}
				else {
					if(save == Integer.MAX_VALUE)
						data.add(temp);
					else {
						data.add(save+temp);
						save = Integer.MAX_VALUE;
					}
				}
			}
		}
	}
	
}
