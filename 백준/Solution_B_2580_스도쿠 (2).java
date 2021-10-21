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

public class Solution_B_2580_스도쿠 {
	
	static int[][] map;
	static int[][] answer;
	static List<Blank> list = new ArrayList<>();
	
	static class Blank{
		int y,x;
		public Blank(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		//빈칸을 모두 찾는다.
		//빈칸일 경우
		//1~9 돌며 숫자를 넣고 R,C,3*3을 검사한 후 가능하면 넣고 다음단계로 넘어간다.
		//반복
		
		map = new int[9][9];
		answer = new int[9][9];
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int i = 0 ; i<9;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j<9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					list.add(new Blank(i,j));
			}
		}
		
		fill_sudoku(list.size(),0);
		
		for(int i = 0 ; i<9;i++) {
			for(int j=0 ; j<9;j++) {
				out.write(answer[i][j] +" ");
			}
			out.write("\n");
		}
		
		out.close();
		
	}

	private static void fill_sudoku(int size, int depth) {
		if(depth == size) {
			for(int i = 0 ; i<9;i++) {
				answer[i]= map[i].clone();
			}
			return;
		}
		
		for(int i = 1;i<=9;i++) {
			if(answer[0][0] !=0)return;
			boolean flag = false;
			//y로검사
			for(int j = 8 ; j>=0;j--) {
				if(map[list.get(depth).y][j]==i) {
					flag = true;
					break;
				}
			}
			if(flag)
				continue;
			
			//x로검사
			for(int j = 8 ; j>=0;j--) {
				if(map[j][list.get(depth).x]==i) {
					flag = true;
					break;
				}
			}
			if(flag)
				continue;
			
			//구역검사
			for(int y = (list.get(depth).y/3)*3;y<(list.get(depth).y/3)*3+3;y++) {
				for(int x = (list.get(depth).x/3)*3;x<(list.get(depth).x/3)*3+3;x++) {
					if(map[y][x]==i) {
						flag=true;
						break;
					}
				}
			}
			if(flag)
				continue;
			else {
				map[list.get(depth).y][list.get(depth).x]= i;
				fill_sudoku(size, depth+1);
				map[list.get(depth).y][list.get(depth).x]= 0;
			}
			
		}
		
	}
}
