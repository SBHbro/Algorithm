package study_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_19238_��ŸƮ�ý� {

	static int N,M;//�� ũ��, �°� ��
	static int[][] map; // ��
	static int ay,ax;
	static int min; //�°����� �� �� �ִ� �ִܰŸ�
	static int fuel;//����
	static int[] dy = {-1,1,0,0}; // �̵��� ����� �迭
	static int[] dx = {0,0,-1,1};
	static ArrayList<int[]> start;
	static ArrayList<int[]> end;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		
		//�� ���� �Է�
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//�ý� ������ǥ �Է�
		st= new StringTokenizer(in.readLine());
		ay = Integer.parseInt(st.nextToken())-1;
		ax = Integer.parseInt(st.nextToken())-1;
		
		//�°� ��ǥ�� ��������ǥ �Է�
		start = new ArrayList<>();
		end = new ArrayList<>();
		for(int i = 0 ; i<M;i++) {
			st = new StringTokenizer(in.readLine());
			start.add(new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1});
			end.add(new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1});
		}
		
		//�ýÿ��� �°������� �ִܰŸ��� ��� ���ϸ鼭(�ýÿ� �°��� �������� ������ 0, �ִܰŸ��� ������� y,x ������ ���� �°����� ����
		//�ִܰŸ��� ���� ª�� �°��� �ִܰŸ��� �����س��´�
		while(M>0) {
			int minIndex = 0;
			int minLength = Integer.MAX_VALUE;
			for(int i = 0 ; i<start.size();i++) {
				min = Integer.MAX_VALUE;
				boolean[][] check= new boolean[N][N];
				dfs(ay,ax,0,i,check,start);
				if(minLength>min) {
					minLength = min;
					minIndex = i;
				}
			}
			
			//�ý��� ��ġ�� �°����� �ű� �� ���Ḧ �̵��� �Ÿ���ŭ ����
			if(fuel-minLength >0) {
				fuel-=minLength;
				ay = start.get(minIndex)[0];
				ax = start.get(minIndex)[1];
			}
			else
				break;
			
			//������������ �ִܰŸ� ��� �� ���ᰡ ����ϴٸ� �̵��� �� ���Ḧ �����Ѵ�.
			//�̵��� �� ���� ��� ����
			min = Integer.MAX_VALUE;
			boolean[][] check = new boolean[N][N];
			dfs(ay,ax,0,minIndex,check,end);
			
			//�̵��� �� �ִٸ�
			if(fuel-min>=0) {
				ay = end.get(minIndex)[0];
				ax = end.get(minIndex)[1];
				start.remove(minIndex);
				end.remove(minIndex);
				M--;
				fuel+=min;
			}
			else
				break;
		}
		if(M>0)
			System.out.println(-1);
		else
			System.out.println(fuel);
	}
	
	//�ִܰŸ� ��� dfs
	private static void dfs(int y, int x,int k,int man,boolean[][] check,ArrayList<int[]> list) {
		if(k>min) {
			return;
		}
		
		if(y == list.get(man)[0] && x == list.get(man)[1]) {
			if(min>k) {
				min = k;
			}
			return;
		}
		
		
		for(int i = 0 ; i<4;i++) {
			int ty = y+dy[i];
			int tx = x+dx[i];
			
			if(isSafe(ty,tx)&&!check[ty][tx]&&map[ty][tx]!=1) {
				check[ty][tx] = true;
				dfs(ty,tx,k+1,man,check,list);
				check[ty][tx] = false;
			}
		}
		
	}

	public static boolean isSafe(int y, int x) {
		if(0<=y && y < N && 0<=x && x<N)
			return true;
		return false;
	}
}
