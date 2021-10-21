package study_0121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_2580_스도쿠 {

	static int[][] map;
	static int N = 9;
	static int zeroPoint;
	
	public static void main(String[] args) throws IOException {
		
		//위에서 아래로 검사
		//한줄에 빈 구멍이 하나일경우 나온 숫자를 모두 더한뒤 45에서 빼고 빈 구멍의 위치에 넣는다.
		//좌에서 우로 검사
		//한줄에 빈 구멍이 하나일경우 나온 숫자를 모두 더한뒤 45에서 빼고 빈 구멍의 위치에 넣는다.
		//3*3영역검사
		//영역모두 검사한 뒤 빈 구멍이 하나일 경우 45에서 영역의 모든 숫자를 더한값을 빼고 빈 구멍의 위치에 넣는다.
		//빈 구멍이 0이 될때까지 반복
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[N][N];
		
		for(int i = 0 ; i< N ; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j <N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)zeroPoint++;
			}
		}
		
		while(zeroPoint>0) {
			
			topDown();
			
			if(zeroPoint==0) break;
			
			leftRight();
			if(zeroPoint==0) break;
			
			for(int i = 0 ; i<N;i+=3) {
				for(int j = 0 ; j<N;j+=3) {
					region(i,j);
				}
			}
			
		}
		
		for(int i = 0 ; i<N;i++) {
			for(int j = 0 ; j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	private static void region(int y, int x) {
		int plus = 0;
		int ty =0, tx =0;
		int count = 0;
		for(int i = y;i<y+3;i++) {
			for(int j = x; j<x+3;j++) {
				if(map[i][j] == 0) {
					count++;
					ty = i;
					tx = j;
				}
				plus += map[i][j];
			}
		}
		if(count == 1) {
			map[ty][tx] = 45-plus;
			zeroPoint--;
		}
	}

	static void topDown() {
		//위에서 아래로 검사
		for(int i = 0 ; i< N ; i++) {
			int plus = 0;
			int ty =0, tx =0;
			int count = 0;
			for (int j = 0; j <N;j++) {
				if(map[i][j] == 0) {
					count++;
					ty = i;
					tx = j;
				}
				plus += map[i][j];
			}
			if(count == 1) {
				map[ty][tx] = 45-plus;
				zeroPoint--;
			}
		}
	}
	
	static void leftRight() {
		//좌에서 우로 검사
		for(int i = 0 ; i< N ; i++) {
			int plus = 0;
			int ty =0, tx =0;
			int count = 0;
			for (int j = 0; j <N;j++) {
				if(map[j][i] == 0) {
					count++;
					ty = j;
					tx = i;
				}
				plus += map[j][i];
			}
			if(count == 1) {
				map[ty][tx] = 45-plus;
				zeroPoint--;
			}
		}
	}
	
}
