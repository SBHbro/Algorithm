package study_0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_1699_제곱수의합_dp {

	//루트를 씌운 가장 큰 정수 찾기
	//입력값에서 찾아낸 정수 제곱을 뺀 후 반복
	static int N;
	static int answer;
	static int[] data;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(Math.sqrt(99999));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		data = new int[N+1];
		data[0] = 0;
		
		for(int i = 1; i<=N;i++) {
			data[i]= i;
			for(int j = 1; j*j<=i;j++) {
				data[i] = Math.min(data[i], data[i-j*j]+1);
			}
		}
		
		System.out.println(data[N]);
		
	}
	
}
