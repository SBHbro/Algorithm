package study_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_11054_가장긴바이토닉부분수열 {

	static int N;
	static int[] data;
	static int[] front;
	static int[] end;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N+2];
		front = new int[N+2];
		end = new int[N+2];
		answer = 1;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 1;i<=N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=N;i++) {
			int temp = 0;
			int temp2 = N+1;
			for(int j =0;j<i;j++) {
				if(data[j]<data[i])
					if(front[temp]<front[j])
						temp = j;
				if(data[N-j+1]<data[N-i+1])
					if(end[temp2]<end[N-j+1])
						temp2 = N-j+1;
			}
			
			front[i] = front[temp]+1;
			end[N-i+1] = end[temp2]+1;
		}
		
		for(int i = 1 ; i<=N;i++) {
			for(int j = N;i<j;j--) {
				if(data[i]!=data[j])
					answer = Math.max(front[i]+end[j], answer);
			}
		}
		
		System.out.println(answer);
		
	}
	
}
