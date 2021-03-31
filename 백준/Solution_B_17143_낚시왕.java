package ssibal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Solution_B_17143_���ÿ� {

	
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
	
	//�Է�
	
	//��� Ŭ���� ����� y,x,ũ��,����,�ӷ�,����
	//�迭�� �����
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
		
		//���ÿ� ��ĭ������
		//������(����ĭ�� ���θ�������������)
		//����̵�(����ϰ�� �ݴ�� ����ٲ�)
		//�ʿ� ��� ����ֱ�
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
			//����ִ¾ֵ鸸
			if(shark[i].life==1) {
				//�ڸ��� ����������
				if(map[shark[i].y][shark[i].x] != 0) {
					Shark pre = shark[map[shark[i].y][shark[i].x]];
					//����ũ�� ���ִ´�
					if(pre.z<shark[i].z) {
						pre.life = -1;
						map[shark[i].y][shark[i].x] = i;
					}
					//���� �ִ��ְ� ũ�� �� ����
					else {
						shark[i].life = -1;
					}
				}
				//�ڸ��� �ƹ��� ������
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
					//����
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
					//�¿�
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
		//���� �����ִ¾��� ���� �����ִ¾�.
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
