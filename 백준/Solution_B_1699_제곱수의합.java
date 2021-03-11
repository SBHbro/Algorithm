package study_0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_1699_제곱수의합 {

	//루트를 씌운 가장 큰 정수 찾기
	//입력값에서 찾아낸 정수 제곱을 뺀 후 반복
	static int N;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(Math.sqrt(99999));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		answer = Integer.MAX_VALUE;
		dfs(N,0);
		
		System.out.println(answer);
		
	}
	
	public static void dfs(int input,int depth) {
//		System.out.println(input+ " " +depth);
		if(input == 0) {
			answer = Math.min(answer, depth);
			return;
		}
		if(answer<=depth)
			return;
		//입력값에 루트 씌워서 정수찾기
		//입력값 - 찾아낸수^2 == 0일경우 depth+1 리턴
		//입력값 - 찾아낸수^2을 입력으로 넣고 depth+1
		
		int rootedInput = (int)Math.sqrt(input);
		for(int i = rootedInput;i>0;i--) {
			if(depth+1<answer)
			dfs(input - (int)Math.pow(i, 2),depth+1);
		}
		
	}
	
}
