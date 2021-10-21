package study_1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_20056_마법사상어와파이어볼 {
	
	
	public static class Node{
		public Node(int y, int x, int m, int s, int d) {
			super();
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		int y;
		int x;
		int m;
		int s;
		int d;
	}
	
	static int N,M,K;
	static int answer;
	static List<Node>[][] map;
	static int[] dy = new int[] {-1,-1,0,1,1,1,0,-1};
	static int[] dx = new int[] {0,1,1,1,0,-1,-1,-1};
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); //맵 사이즈
		M = Integer.parseInt(st.nextToken()); //파이어볼 개수
		K = Integer.parseInt(st.nextToken()); //이동 회수
		
		map = new ArrayList[N+1][N+1];
		//맵 생성
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1 ; j<=N;j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0 ; i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			Node temp = new Node(y,x,m,s,d);
			map[y][x].add(temp);
		}
		
		//k번반복
		for(int k = 0 ; k<K;k++) {
			
			//이동하기
			Queue<Node> que = new LinkedList<>();
			for(int i = 1;i<=N;i++) {
				for(int j = 1; j<=N;j++) {
					if(map[i][j].size()>=1) {
						while(map[i][j].size()!=0) {
							Node temp = map[i][j].get(0);
							int ty = temp.y;
							int tx = temp.x;
							ty += dy[temp.d]*temp.s;
							tx += dx[temp.d]*temp.s;
							while(N<ty)ty-=N;
							while(ty<1)ty+=N;
							while(N<tx)tx-=N;
							while(tx<1)tx+=N;
							que.add(new Node(ty,tx,temp.m,temp.s,temp.d));
							map[i][j].remove(0);
						}
					}
				}
			}
			
			while(!que.isEmpty()) {
				Node temp = que.poll();
				map[temp.y][temp.x].add(temp); 
			}
			
			for(int i = 1;i<=N;i++) {
				for(int j =1;j<=N;j++) {
					if(map[i][j].size()>=2) {
						//파이어볼 모두 합치고
						int allFireM = 0;
						int allFireS = 0;
						int checkD = 0;
						int checkD2 = 0;
						int size = map[i][j].size();
						
						for(int f = 0;f<size;f++) {
							allFireM +=map[i][j].get(f).m;
							allFireS +=map[i][j].get(f).s;
							if(map[i][j].get(f).d%2==0)//짝수
								checkD++;
							else
								checkD2++;
						}
						map[i][j].clear();
						allFireM = allFireM/5;
						if(allFireM != 0) {
							allFireS = allFireS/size;
							//4개로 나눈다
							//m -> 모든 파이어볼 질량의 합/5
							//s -> 합쳐진 파이어볼 속력의 합/ 합쳐진 파이어볼 개수
							//d -> 방향이 모두 홀수이거나 모두 짝수이면 0,2,4,6 아니면 1,3,5,7
							if(checkD==0||checkD2==0) {
								map[i][j].add(new Node(i,j,allFireM,allFireS,0));
								map[i][j].add(new Node(i,j,allFireM,allFireS,2));
								map[i][j].add(new Node(i,j,allFireM,allFireS,4));
								map[i][j].add(new Node(i,j,allFireM,allFireS,6));
							}
							else {
								//모두 홀수나 짝수가 아닐경우
								map[i][j].add(new Node(i,j,allFireM,allFireS,1));
								map[i][j].add(new Node(i,j,allFireM,allFireS,3));
								map[i][j].add(new Node(i,j,allFireM,allFireS,5));
								map[i][j].add(new Node(i,j,allFireM,allFireS,7));
							}
						}
					}
				}
			}
		}
		
		//답 구하기
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1;j<=N;j++) {
				int size = map[i][j].size();
				if(size>=1) {
					for(int a = 0 ;a<size;a++) {
						answer+=map[i][j].get(a).m;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
