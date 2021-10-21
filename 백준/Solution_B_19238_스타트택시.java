package study_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_19238_스타트택시 {

	static int N,M;//맵 크기, 승객 수
	static int[][] map; // 맵
	static int ay,ax;
	static int min; //승객에게 갈 수 있는 최단거리
	static int fuel;//연료
	static int[] dy = {-1,1,0,0}; // 이동에 사용할 배열
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
		
		
		//맵 정보 입력
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//택시 시작좌표 입력
		st= new StringTokenizer(in.readLine());
		ay = Integer.parseInt(st.nextToken())-1;
		ax = Integer.parseInt(st.nextToken())-1;
		
		//승객 좌표와 도착지좌표 입력
		start = new ArrayList<>();
		end = new ArrayList<>();
		for(int i = 0 ; i<M;i++) {
			st = new StringTokenizer(in.readLine());
			start.add(new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1});
			end.add(new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1});
		}
		
		//택시에서 승객까지의 최단거리를 모두 구하면서(택시와 승객이 같은곳에 있으면 0, 최단거리가 같을경우 y,x 순으로 작은 승객부터 간다
		//최단거리가 가장 짧은 승객과 최단거리를 저장해놓는다
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
			
			//택시의 위치를 승객으로 옮긴 후 연료를 이동한 거리만큼 뺀다
			if(fuel-minLength >0) {
				fuel-=minLength;
				ay = start.get(minIndex)[0];
				ax = start.get(minIndex)[1];
			}
			else
				break;
			
			//목적지까지의 최단거리 계산 후 연료가 충분하다면 이동한 후 연료를 충전한다.
			//이동할 수 없을 경우 종료
			min = Integer.MAX_VALUE;
			boolean[][] check = new boolean[N][N];
			dfs(ay,ax,0,minIndex,check,end);
			
			//이동할 수 있다면
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
	
	//최단거리 계산 dfs
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
