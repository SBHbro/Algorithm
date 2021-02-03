package study_0117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_1018_ü���Ǵٽ�ĥ�ϱ� {
	
	//�Է¹���
	//8*8�� ���� �� �ִ� �ִ� ������ 0,0���� ��� ������ ���� �˻�
	//�˻� -> ù��ġ�� ���� Ȯ�� -> ��ĭ�� �����ϸ鼭 �� �����̿��� �ϴ°Ͱ� ��ĭ�� ������ �´��� �� ->Ʋ���� temp++
	//answerã��
	
	static char[][] map;
	static int N,M;
	static int answer;
	static char[][] W;
	static char[][] B;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0 ; i<N;i++) {
			map[i] = in.readLine().toCharArray();
		}
		//W,B �����.
		W = new char[8][8];
		B = new char[8][8];
		
		int temp = 0;
		for(int i = 0 ; i<8;i++) {
			for(int j = 0 ; j<8;j++) {
				if(temp%2==0) {
					W[i][j] = 'W';
					B[i][j] = 'B';
				}
				else {
					W[i][j] = 'B';
					B[i][j] = 'W';
				}
				temp++;
			}
			temp++;
		}
		//����������������
		
		
		answer = Integer.MAX_VALUE;
		
		for(int i = N-8; i>=0;i--) {
			for(int j = M-8;j>=0;j--) {
				answer = Math.min(answer, checkNum(i,j));
			}
		}
		
		System.out.println(answer);
		
		
	}

	private static int checkNum(int y, int x) {
		int wCount=0;
		int bCount =0;
		int ty = 0;
		int tx = 0;
		for(int i = y; i<y+8;i++) {
			for(int j = x; j<x+8;j++) {
				if(map[i][j] != W[ty][tx]) {
					wCount++;
				}
				if(map[i][j] != B[ty][tx]) {
					bCount++;
				}
				tx++;
			}
			ty++;
			tx = 0;
		}
		return Math.min(wCount, bCount);
		
	}
}
