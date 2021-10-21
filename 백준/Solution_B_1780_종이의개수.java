package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_1780_종이의개수 {

	static int N;
	static int[][] input;
	static int[] answer = new int[3];	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		input = new int[N][N];
		
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j<N;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0,N);
		
		for(int i = 0 ; i<3;i++) {
			System.out.println(answer[i]);
		}
		
		
	}


	private static void find(int startY, int startX, int len) {
		
		if(len == 1) {
			answer[input[startY][startX]+1]++;
			return;
		}
		
		int temp = input[startY][startX];
		boolean check = false;
		for(int i = startY; i<startY+len; i++) {
			boolean tmp = false;
			for(int j = startX; j<startX+len;j++) {
				if(input[i][j]!=temp) {
					check = true;
					tmp = true;
					break;
				}
			}
			if(tmp)break;
		}
		
		if(!check) {
			answer[temp+1]++;
			return;
		}
		else {
			//시작위치잡는곳 부터 다시
			find(startY,startX,len/3);
			find(startY,startX+len/3,len/3);
			find(startY,startX+(len/3)*2,len/3);
			find(startY+len/3,startX,len/3);
			find(startY+len/3,startX+len/3,len/3);
			find(startY+len/3,startX+(len/3)*2,len/3);
			find(startY+(len/3)*2,startX,len/3);
			find(startY+(len/3)*2,startX+len/3,len/3);
			find(startY+(len/3)*2,startX+(len/3)*2,len/3);
		}
		
	}
	
}
