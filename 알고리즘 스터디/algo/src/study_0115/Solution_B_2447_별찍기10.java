package study_0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_2447_�����10 {

	static int N;
	static char[][] map;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new char[N+1][N+1];
		
		
		
	}
	
	public static void run(int N,int y,int x) {
		
		//9����
		for(int i = 1 ;i<=9;i++) {
			
			//���ٿ� 3�� �ϸ� �����ٷ� �Ѿ
			for(int j = 1;j<=3;j++) {
				run(N/3,y,x);
				x+=N/3;
			}
			y+=N/3;
		}
		
	}
	
}
