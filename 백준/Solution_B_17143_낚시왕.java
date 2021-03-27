package ssibal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Solution_B_17143_낚시왕 {

	
	static class Shark{
		int y,x,d,z,s,life;

		public Shark(int y, int x, int d, int z, int s, int life) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.z = z;
			this.s = s;
			this.life = life;
		}
	}
	
	static int R,C,M;
	static int[][] map;
	static Shark[] shark;
	static int manX;
	static int answer;
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,1,-1};
	
	//입력
	
	//상어 클래스 만들기 y,x,크기,방향,속력,생존
	//배열로 만들기
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		
		shark = new Shark[M+1];
		
		for(int i = 1 ;i<=M;i++) {
			st = new StringTokenizer(in.readLine());
			
			int tempY = Integer.parseInt(st.nextToken());
			int tempX = Integer.parseInt(st.nextToken());
			int tempS = Integer.parseInt(st.nextToken());
			int tempD = Integer.parseInt(st.nextToken());
			int tempZ = Integer.parseInt(st.nextToken());
			
			map[tempY][tempX] = i;
			shark[i] = new Shark(tempY, tempX, tempD, tempZ, tempS, 1);
		}
		
		//낚시왕 한칸오른쪽
		//상어잡기(같은칸에 상어두마리있을수있음)
		//상어이동(경계일경우 반대로 방향바꿈)
		//맵에 상어 찍어주기
//		print();
		while(manX<C) {
			manX++;
			catchShark();
			moveShark();
			checkShark();
//			print();
			
		}
		
		System.out.println(answer);
		
		
	}
	

	private static void print() {
		for(int i = 1;i<=R;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println();
		
	}


	private static void checkShark() {
		
		for(int i = 1; i<=M;i++) {
			//살아있는애들만
			if(shark[i].life==1) {
				//자리에 누가있으면
				if(map[shark[i].y][shark[i].x] != 0) {
					Shark pre = shark[map[shark[i].y][shark[i].x]];
					//내가크면 날넣는다
					if(pre.z<shark[i].z) {
						pre.life = -1;
						map[shark[i].y][shark[i].x] = i;
					}
					//원래 있던애가 크면 나 뒤짐
					else {
						shark[i].life = -1;
					}
				}
				//자리에 아무도 없을때
				else {
					map[shark[i].y][shark[i].x] = i;
				}
			}
		}
	}


	private static void moveShark() {
		for(int i = 1; i<=M;i++) {
			if(shark[i].life==1) {
				
				map[shark[i].y][shark[i].x] = 0;
				int ty = shark[i].y+(dy[shark[i].d]*shark[i].s);
				int tx = shark[i].x+(dx[shark[i].d]*shark[i].s);
				while(!isSafe(ty,tx)) {
					//상하
					if(shark[i].d==1||shark[i].d==2) {
						if(R<ty) {
							ty = R - (ty-R);
							shark[i].d = shark[i].d ==1 ? 2:1;
						}
						else if(ty<1) {
							ty = (ty*-1)+2;
							shark[i].d = shark[i].d ==1 ? 2:1;
						}
					}
					//좌우
					else {
						if(C<tx) {
							tx = C - (tx-C);
							shark[i].d = shark[i].d ==3 ? 4:3;
						}
						else if(tx<1) {
							tx = (tx*-1)+2;
							shark[i].d = shark[i].d ==3 ? 4:3;
						}
					}
				}
				shark[i].y = ty;
				shark[i].x = tx;
				
			}
		}
		
	}


	private static boolean isSafe(int ty, int tx) {
		return 0<ty&&ty<=R&&0<tx&&tx<=C;
	}


	private static void catchShark() {
		//같은 열에있는애중 가장 위에있는애.
		for(int i = 1;i<=R;i++) {
			if(map[i][manX]!=0) {
				Shark temp = shark[map[i][manX]];
				temp.life = -1;
				answer += temp.z;
				map[temp.y][temp.x]=0;
				return;
			}
		}
	}
}
