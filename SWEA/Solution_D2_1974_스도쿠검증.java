package study_0116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_스도쿠검증 {

	static int T;
	static int[][] map;
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		for(int t= 1 ; t<=T;t++) {
			map = new int[9][9];
			for(int i = 0 ; i<9;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0 ;j<9;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(checkRow()&&checkColumn()&&checkThree()) {
				System.out.println("#"+t+" "+1);
			}
			else {
				System.out.println("#"+t+" "+0);
			}
			
		}
	}
	
	static boolean checkRow() {
		for(int i = 0 ; i<9;i++) {
			boolean[] check = new boolean[10];
			for(int j = 0;j<9;j++) {
				if(check[map[i][j]]) {
					return false;
				}
				else
					check[map[i][j]] = true;
			}
		}
		return true;
	}
	
	static boolean checkColumn() {
		for(int i = 0 ; i<9;i++) {
			boolean[] check = new boolean[10];
			for(int j = 0;j<9;j++) {
				if(check[map[j][i]]) {
					return false;
				}
				else
					check[map[j][i]] = true;
			}
		}
		return true;
	}
	
	static boolean checkThree() {
		
		for(int i = 0 ;i<9;i+=3) {
			for(int j = 0 ; j<9;j+=3) {
				boolean[] check = new boolean[10];
				for(int y = i;y<i+3;y++) {
					for(int x = j;x<j+3;x++) {
						if(check[map[y][x]]) {
							return false;
						}
						else
							check[map[y][x]]=true;
					}
				}
			}
		}
		
		return true;
	}
}
