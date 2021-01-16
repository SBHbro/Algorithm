package study_0115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_B_2447_별찍기10 {

	static int N;
	static char[][] map;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new char[N+1][N+1];
		
		run(N,0,0);
		
		for(int i =0;i<N;i++) {
			for(int j = 0 ;j<N;j++) {
				if(map[i][j]=='*')
				out.write(map[i][j]);
				else
					out.write(" ");
			}
			out.write("\n");
		}
		
		out.close();
	}
	
	public static void run(int N,int y,int x) {
		if(N==3) {
			fill_Map(y,x);
			return;
		}
		
		int tx = x;
		int ty = y;
		//9구역
		for(int i = 1 ;i<=3;i++) {
			//한줄에 3번 하면 다음줄로 넘어감
			for(int j = 1;j<=3;j++) {
				if(i==2&&j==2) {
					tx+=N/3;
					continue;
				}
				run(N/3,ty,tx);
				tx+=N/3;
				if(tx>=N+x)tx=x;
			}
			ty+=N/3;
		}
		
	}

	private static void fill_Map(int y, int x) {
		for(int i = y; i<=y+2;i++) {
			for(int j = x;j<=x+2;j++) {
				if(i==y+1&&j==x+1)
					continue;
				map[i][j] = '*';
			}
		}
	}
	
}
