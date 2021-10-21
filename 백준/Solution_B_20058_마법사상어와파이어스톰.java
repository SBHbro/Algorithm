package study_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Solution_B_20058_마법사상어와파이어스톰 {

	static int N,Q;
	static int[] L;
	static int answer,answerMax;
	static int[][] map;
	static int[][] mapCopy;
	static int[] dy = new int[] {-1,1,0,0};
	static int[] dx = new int[] {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		
		map = new int[size][size];
		mapCopy = new int[size][size];
		
		for(int i = 0;i<size;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j<size;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapCopy[i][j] = map[i][j];
			}
		}
		
		L = new int[Q];
		st = new StringTokenizer(in.readLine());
		
		for(int i=0;i<Q;i++) {
			L[i] = (int) Math.pow(2,Integer.parseInt(st.nextToken()));
		}
		
		int k = 0;
		
		while(k<Q) {
			answer = 0;
			//구역별로 맵을 돌린다.
			for(int i = 0 ; i<size;i+=L[k]) {//L[0] 수정하기
				for(int j = 0 ; j<size;j+=L[k]) {
					mapRotate(i,j,i+L[k]-1,j+L[k]-1);
				}
			}

			//근처에 얼음이 3개이상이 아닌애들은 1씩낮춘다.
			
			for(int i = 0 ; i<size;i++) {
				for(int j = 0 ; j<size;j++) {
					if(map[i][j] !=0) {
						int count = 0;
						for(int d = 0 ;d<4;d++) {
							int ty = i+dy[d];
							int tx = j+dx[d];
							if(count>=3)break;
							if(isSafe(ty,tx,size)&& map[ty][tx] > 0) {
								count++;
							}
						}
						int temp = map[i][j];
						if(count<3) {
							mapCopy[i][j] = temp - 1;
						}
						else {
							mapCopy[i][j] = temp;
						}
					}
					else
						mapCopy[i][j] = 0;
					
					answer+=mapCopy[i][j];
				}
			}
			
			//반복하여 답을 구한다.
			k++;
		}
		
		for(int i = 0 ;i<size;i++) {
			for(int j = 0 ; j<size; j++) {
				if(mapCopy[i][j]!=0) {
					answerMax = Math.max(dfs(i,j,size,0), answerMax);
				}
			}
		}
		
		
		System.out.println(answer);
		System.out.println(answerMax);
		
	}


	private static int dfs(int y, int x,int size,int depth) {
		
		for(int i = 0 ; i<4;i++) {
			int ty = y+dy[i];
			int tx = x+dx[i];
			if(isSafe(ty,tx,size)&&mapCopy[ty][tx]!=0) {
				mapCopy[ty][tx]=0;
				depth = dfs(ty,tx,size,depth+1);
			}
		}
		
		return depth;
		
	}


	private static boolean isSafe(int ty, int tx,int size) {

		if(0<=ty&&ty<size&&0<=tx&&tx<size)return true;
		
		return false;
	}


	private static void mapRotate(int startY, int startX,int endY,int endX) {
		// TODO Auto-generated method stub
		int tempX = 0;
		for(int i = startY;i<=endY;i++) {
			int tempY = 0;
			for(int j = startX;j<=endX;j++) {
				map[i][j] = mapCopy[endY-tempY][startX+tempX];
				tempY++;
			}
			tempX++;
		}
	}
	
}
