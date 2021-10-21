package study_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_11047_동전0 {
	
	static int N,K;
	static int[] input;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		
		for(int i = 0 ; i<N; i++) {
			input[i] = Integer.parseInt(in.readLine());
		}
		
		dfs(0,K);
		
		System.out.println(answer);
	}

	private static void dfs(int depth,int temp) {
		if(temp<0 || answer!=0) {
			return;
		}
		
		if(0==temp) {
			answer=depth;
			return;
		}
		
		for(int i = N-1;i>=0;i--) {
			if(answer!=0)
				return;
			
			if(temp>=input[i]) {
				dfs(depth+temp/input[i],temp-(input[i]*(temp/input[i])));
			}
		}
	}
	
}
