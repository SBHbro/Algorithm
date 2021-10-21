package study_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_12015_가장긴증가하는부분수열2 {

	static int N;
	static List<Integer> dp = new ArrayList<Integer>();
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		dp.add(0);
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0 ; i<N;i++) {
			int input = Integer.parseInt(st.nextToken());
			int temp = 0;
			boolean flag= false;
			for(int j = 0 ; j<dp.size();j++) {
				if(input<=dp.get(j)) {
					temp = j;
					flag = true;
					break;
				}
			}
			if(!flag)
				dp.add(input);
			else 
				dp.set(temp, input);
		}
		System.out.println(dp.size()-1);
		for(int i = 1 ; i<dp.size();i++) {
			System.out.print(dp.get(i)+ " ");
		}
		
	}
	
}


