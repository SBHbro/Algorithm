package study_0121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_2580_������ {

	static int[][] map;
	static int N = 9;
	static int zeroPoint;
	
	public static void main(String[] args) throws IOException {
		
		//������ �Ʒ��� �˻�
		//���ٿ� �� ������ �ϳ��ϰ�� ���� ���ڸ� ��� ���ѵ� 45���� ���� �� ������ ��ġ�� �ִ´�.
		//�¿��� ��� �˻�
		//���ٿ� �� ������ �ϳ��ϰ�� ���� ���ڸ� ��� ���ѵ� 45���� ���� �� ������ ��ġ�� �ִ´�.
		//3*3�����˻�
		//������� �˻��� �� �� ������ �ϳ��� ��� 45���� ������ ��� ���ڸ� ���Ѱ��� ���� �� ������ ��ġ�� �ִ´�.
		//�� ������ 0�� �ɶ����� �ݺ�
		
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
		//������ �Ʒ��� �˻�
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
		//�¿��� ��� �˻�
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
