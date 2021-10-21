package algo_study_0715;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_B_1992_쿼드트리 {

	static int N;
	static int[][] map;
	static int answer,answer2;
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	//1. start~end 모두 같은 값을 가지고 있는지 확인한다.
	//2. 다른 값을 가지고 있는 경우 가로,세로의 중간을 잘라서 분할한다.
	//3. 나누어진 부분들에 대해서 N이 1이거나 모두 같은 값을 가지고 있는 경우 answer를 1 증가시킨다
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		answer = 0;
		answer2 = 0;
		
		for(int i = 0 ;i<N;i++) {
			String input = in.readLine();
			for(int j = 0 ;j<N;j++) {
				map[i][j] = Integer.parseInt(input.charAt(j)+"");
			}
		}
		
		dq(N,0,0,N,N);
		
		
	}

	private static void dq(int n,int starty,int startx,int endy, int endx) {
		if(n==1) {
			if(map[starty][startx]==0) {
				System.out.print(0);
				return;
			}
			else if(map[starty][startx]==1) {
				System.out.print(1);
				return;
			}
		}
		
		if(blockSame(n,starty,startx,endy, endx)) {//모두 같은 블럭일 경우
			if(map[starty][startx]==0) {
				System.out.print(0);
				return;
			}
			else if(map[starty][startx]==1) {
				System.out.print(1);
				return;
			}
		}
		else { //다른 블럭이 있을 경우
			//4개로 나눈다
			//좌상, 우상, 좌하, 우하
			System.out.print("(");
			dq(n/2,starty,startx,(endy+starty)/2,(endx+startx)/2);
			dq(n/2,starty,(endx+startx)/2,(endy+starty)/2,endx);
			dq(n/2,(endy+starty)/2,startx,endy,(endx+startx)/2);
			dq(n/2,(endy+starty)/2,(endx+startx)/2,endy,endx);
			System.out.print(")");
		}
	}

	private static boolean blockSame(int n, int starty, int startx,int endy, int endx) {
		// TODO Auto-generated method stub
		int temp = map[starty][startx];
		for(int i = starty;i<endy;i++) {
			for(int j = startx;j<endx;j++) {
				if(map[i][j] != temp) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
}
