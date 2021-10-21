package study_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_1912_연속합 {

	static int N;
	static int answer;
	static int[] data;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		data = new int[N+1];
		answer = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 1 ; i<=N;i++) {
			int input = Integer.parseInt(st.nextToken());
			data[i] = Math.max(input, data[i-1]+input);
			answer = Math.max(answer, data[i]);
		}
		
		System.out.println(answer);
	}
	
}
