package algo_study_0715;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_B_2630_�����̸���� {

	static int N;
	static int[][] map;
	static int answer,answer2;
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	//1. start~end ��� ���� ���� ������ �ִ��� Ȯ���Ѵ�.
	//2. �ٸ� ���� ������ �ִ� ��� ����,������ �߰��� �߶� �����Ѵ�.
	//3. �������� �κе鿡 ���ؼ� N�� 1�̰ų� ��� ���� ���� ������ �ִ� ��� answer�� 1 ������Ų��
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		answer = 0;
		answer2 = 0;
		
		for(int i = 0 ;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0 ;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dq(N,0,0,N,N);
		
		System.out.println(answer);
		System.out.println(answer2);
		
	}

	private static void dq(int n,int starty,int startx,int endy, int endx) {
		if(n==1) {
			if(map[starty][startx]==0) {
				answer++;
				return;
			}
			else if(map[starty][startx]==1) {
				answer2++;
				return;
			}
		}
		
		if(blockSame(n,starty,startx,endy, endx)) {//��� ���� ���� ���
			if(map[starty][startx]==0) {
				answer++;
				return;
			}
			else if(map[starty][startx]==1) {
				answer2++;
				return;
			}
		}
		else { //�ٸ� ���� ���� ���
			//4���� ������
			//�»�, ���, ����, ����
			dq(n/2,starty,startx,(endy+starty)/2,(endx+startx)/2);
			dq(n/2,starty,(endx+startx)/2,(endy+starty)/2,endx);
			dq(n/2,(endy+starty)/2,startx,endy,(endx+startx)/2);
			dq(n/2,(endy+starty)/2,(endx+startx)/2,endy,endx);
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
