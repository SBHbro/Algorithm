package study_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_20057_마법사상어와토네이도 {

	static int N;
	static int map[][];
	static int d;
	static int ty,tx;
	static int answer;
	static int[][] tonado = new int[][] {{0,0,2,0,0},{0,10,7,1,0},{5,0,0,0,0},{0,10,7,1,0},{0,0,2,0,0}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = 0;//0좌 1하 2우 3상
		
		map = new int[N][N];
		
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ty = N/2;
		tx = N/2;
		
		
		for(int i = 1 ; i<=N;i++) {
			
			
			for(int j = 0 ;j<i;j++) {
				if(d==0)tx--;
				else if(d==1)ty++;
				else if(d==2)tx++;
				else if(d==3)ty--;
				move();
			}
			//방향돌림
			if(i==N)break;
			d++;
			if(d==4)d=0;
			tonadoTurn();
			for(int j = 0 ;j<i;j++) {
				if(d==0)tx--;
				else if(d==1)ty++;
				else if(d==2)tx++;
				else if(d==3)ty--;
				move();
			}
			//방향돌림
			d++;
			if(d==4)d=0;
			tonadoTurn();
			
		}
		System.out.println(answer);
	}

	private static void tonadoTurn() {
		int n= tonado.length;
		int temp[][]= new int[n][n];
		for(int i = 0 ;i<n;i++) {
			temp[i] = tonado[i].clone();
		}
		
		for(int i = 0 ;i<tonado.length;i++) {
			for(int j = 0 ; j<tonado.length;j++) {
				tonado[i][j] = temp[j][n-i-1];
			}
		}
	}

	private static void move() {
		if(isSafe(ty,tx)) {
			
			int startY = ty-2;
			int endY = ty+2;
			int startX = tx-2;
			int endX = tx+2;
			int sand = map[ty][tx];
			
			int temp = sand;
			for(int i = startY ; i<= endY;i++) {
				for(int j = startX ;j<=endX;j++) {
					int value = (int) (tonado[i-startY][j-startX]*0.01*sand);
					if(isSafe(i,j)) {
						map[i][j] += value;
						temp -=value;
					}
					else {
						answer += value;
						temp -=value;
					}
				}
			}
			if(d == 0 )
				{
				 if(isSafe(ty,tx-1)){
					 map[ty][tx-1]+=temp;
				 }
				 else answer +=temp;
			}
			if(d == 1 )
			{
				if(isSafe(ty+1,tx)){
					map[ty+1][tx]+=temp;
				}
				else answer +=temp;
			}
			if(d == 2 )
			{
				if(isSafe(ty,tx+1)){
					map[ty][tx+1]+=temp;
				}
				else answer +=temp;
			}
			if(d == 3 )
			{
				if(isSafe(ty-1,tx)){
					map[ty-1][tx]+=temp;
				}
				else answer +=temp;
			}
			map[ty][tx] = 0;
		}
		
	}
	
	public static boolean isSafe(int y, int x) {
		if(0<=y&&y<N&&0<=x&&x<N)return true;
		
		return false;
	}
}
