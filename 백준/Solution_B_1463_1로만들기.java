package study_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_1463_1로만들기 {

	static int[] data;
	static int N;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N+1];
		
		data[1] = 0;
		
		for(int i = 2; i<=N;i++) {
			int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
			if(i%3==0)
				a = data[i/3]+1;
			if(i%2==0)
				b = data[i/2]+1;
			
			c = data[i-1]+1;
			
			data[i] = Math.min(a, Math.min(b, c));
		}
		
		System.out.println(data[N]);
		
	}

	
}
