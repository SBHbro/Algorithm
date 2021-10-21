package study_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_9461_파도반수열 {

	static long[] data;
	static int T,N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		
		data = new long[101];
		
		data[1] = 1;
		data[2] = 1;
		data[3] = 1;
		
		for(int i = 4; i<=100;i++) {
			data[i] = data[i-2]+data[i-3];
		}
		
		for(int i = 0; i<T;i++) {
			System.out.println(data[Integer.parseInt(in.readLine())]);
		}
	}
	
}
