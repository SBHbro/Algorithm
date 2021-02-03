package study_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_1904_01≈∏¿œ {

	static long[] data;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new long[N+1];
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		data[1] = 1;
		data[2] = 2;
		
		for(int i = 3 ; i<=N;i++) {
			data[i] = (data[i-1]+data[i-2])%15746;
		}
		
		System.out.println(data[N]);
		
	}
	
}
