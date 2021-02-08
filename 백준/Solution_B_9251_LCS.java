package study_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_9251_LCS {

	static int[][] data;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String A = in.readLine();
		String B = in.readLine();
		
		data = new int[B.length()+1][A.length()+1];
		
		for(int i = 1 ; i<=B.length();i++) {
			for(int j = 1 ; j<=A.length();j++) {
				if(B.charAt(i-1)==A.charAt(j-1)) {
					data[i][j] = data[i-1][j-1]+1;
				}
				else
					data[i][j] = Math.max(data[i-1][j], data[i][j-1]);
				
				answer = Math.max(answer, data[i][j]);
			}
		}
		
		System.out.println(answer);
	}
	
}
