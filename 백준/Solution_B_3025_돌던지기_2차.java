package study_0203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_3025_돌던지기_2차 {

	static char[][] map;
	static List<int[]>[] data;
	static int R, C;
	static int N;

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		//벽의 위치를 기억한다.
		//C개의 리스트를 만들고 거기에 벽을 넣는다(벽인지 돌멩인지 구분).
		//떨어뜨릴 위치를 받고 벽에 부딛히는지 돌멩이에 부딛히는지 부딛히는게 없는지 확인한다.
		//확인의 결과에 따라 돌멩이를 놓고 리스트에 돌멩이의 위치를 넣는다.(삽입정렬)

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		data = new ArrayList[C];
		for (int i = 0; i < R; i++) {
			String temp = in.readLine();
			for(int j = 0; j<C;j++) {
				if(i==0)
					data[j]=new ArrayList<>();
				
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='X') {
					data[j].add(new int[] {i,0});
				}
			}
		}

		N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(in.readLine());
			drop(input-1,0);
			
		}
		print();

		out.close();

	}

	private static void print() throws IOException {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				out.write(map[i][j]);
			}
			out.write("\n");
		}
		out.write("\n");
		out.write("\n");
	}

	private static void drop(int x, int y) throws IOException {
		if(data[x].size()==0) {
			map[R-1][x] = 'O';
			addData(R-1,x,1);
			return;
		}
		
		if(data[x].get(data[x].size()-1)[0]<y) {
			map[R-1][x] = 'O';
			addData(R-1,x,1);
			return;
		}
		
		int by =0;
		int type =0;
		for(int i = 0 ; i<data[x].size();i++) {
			if(y<data[x].get(i)[0])
				{
					by = data[x].get(i)[0];
					type = data[x].get(i)[1];
					break;
				}
		}
		
		if(type == 0) {
			map[by-1][x] = 'O';
			addData(by-1,x,1);
			return;
		}
		else if(type == 1) {
			if(0<=x-1&&map[by-1][x-1]=='.'&&map[by][x-1]=='.') {
				drop(x-1,by-1);
				return;
			}
			
			if(x+1<C&&map[by-1][x+1]=='.'&&map[by][x+1]=='.') {
				drop(x+1,by-1);
				return;
			}
		}		

	}

	private static void addData(int y, int x, int type) {
		if(data[x].size()==0) {
			data[x].add(new int[] {y,type});
			return;
		}
		
			for(int i = 0 ; i<data[x].size();i++) {
				if(y<data[x].get(i)[0]) {
					data[x].add(i,new int[] {y,type});
					return;
				}
			}
		
	}

}
