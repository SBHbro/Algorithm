package algo_study_0714;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_B_9663_NQueen3 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int answer;
	static boolean[][] map;
	//한줄에 퀸은 하나밖에 못들어간다.
	//맨 윗줄부터 하나씩 놓고 그밑의 위치를 정하는 방식으로 푼다
	//왼쪽위, 위, 오른쪽 위 만 검사하면 된다.
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();

		N = Integer.parseInt(in.readLine());

		map = new boolean[N][N];
		answer = 0;
		for(int i = 0 ;i<N;i++) {
			map[0][i]=true;
			dfs(0,1);
			map[0][i]=false;
		}

		System.out.println(answer);

		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);

	}

	private static void dfs(int k,int h) {
		if (k == N-1) {
			answer++;
			return;
		}
		if(h==N)
			return;
		
		for(int i = 0 ; i<N;i++) {
			if(safe(h,i)) {
				map[h][i]=true;
				dfs(k+1,h+1);
				map[h][i]=false;
			}
		}
		
	}
	
	private static boolean safe(int h, int i) { //퀸을 놓을 수 있는지 검사
		
		for(int k = h;k>=0;k--) { //위로 검사
			if(map[k][i]) return false;
		}
		
		int ty = h-1; //왼쪽 위로 검사
		int tx = i-1;
		while(0<=ty&&0<=tx) {
			if(map[ty][tx]) return false;
			ty--;
			tx--;
		}
		
		ty = h-1; // 오른쪽 위로 검사
		tx = i+1;
		while(0<=ty&&tx<N) {
			if(map[ty][tx]) return false;
			ty--;
			tx++;
		}
		
		return true;
	}

}
