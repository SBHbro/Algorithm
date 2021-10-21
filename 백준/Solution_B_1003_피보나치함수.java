package study_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_1003_피보나치함수 {

	
	static int T;
	static int N;
	static int[][] fibo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		fibo = new int[41][2];
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		
		for(int i = 2 ; i<41;i++) {
//			fibo[i][0] += fibo[i-2][0]+fibo[i-1][0];
//			fibo[i][1] += fibo[i-2][1]+fibo[i-1][1];
			fibo[i][0]=fibo[i-1][1];
			fibo[i][1]=fibo[i-1][0]+fibo[i-1][1];
		}
		
		for(int t = 1; t<=T;t++) {
			
			N = Integer.parseInt(in.readLine());
			System.out.println(fibo[N][0]+ " " + fibo[N][1]);
			
		}
		
		
	}
}
