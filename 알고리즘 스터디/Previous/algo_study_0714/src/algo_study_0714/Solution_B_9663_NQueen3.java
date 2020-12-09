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
	//���ٿ� ���� �ϳ��ۿ� ������.
	//�� ���ٺ��� �ϳ��� ���� �׹��� ��ġ�� ���ϴ� ������� Ǭ��
	//������, ��, ������ �� �� �˻��ϸ� �ȴ�.
	

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
		System.out.println("���� �ð� : " + (end - start) / 1000.0);

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
	
	private static boolean safe(int h, int i) { //���� ���� �� �ִ��� �˻�
		
		for(int k = h;k>=0;k--) { //���� �˻�
			if(map[k][i]) return false;
		}
		
		int ty = h-1; //���� ���� �˻�
		int tx = i-1;
		while(0<=ty&&0<=tx) {
			if(map[ty][tx]) return false;
			ty--;
			tx--;
		}
		
		ty = h-1; // ������ ���� �˻�
		tx = i+1;
		while(0<=ty&&tx<N) {
			if(map[ty][tx]) return false;
			ty--;
			tx++;
		}
		
		return true;
	}

}
