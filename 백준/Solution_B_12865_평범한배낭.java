package study_0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_12865_평범한배낭 {

	static int N,K;
	static int[][] input;
	static int[][] data;
	
	public static void main(String[] args) throws IOException {
		
		//입력받기
		//이차원 배열 만들기 크기는 N+1, K+1
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new int[N+1][2];
		data = new int[N+1][K+1];
		
		for(int i = 1 ; i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//1~N 1~k j<input[i] => data[i][j]==0  else math.max(data[i-1][j],data[i-1][j-input[i][0]]+input[i][1])
		for(int i = 1;i<=N;i++) {
			for(int j = 1; j<=K;j++) {
				if(j<input[i][0])
					data[i][j] = data[i-1][j];
				else {
					data[i][j] = Math.max(data[i-1][j], data[i-1][j-input[i][0]]+input[i][1]);
				}
			}
		}
		
		System.out.println(data[N][K]);
		
	}
	
	
}
