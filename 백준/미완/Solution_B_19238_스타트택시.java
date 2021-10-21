package study_1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_19238_스타트택시 {
	
	static class Node{
		int y,x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static int N,M,F;
	static int[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int taxiY,taxiX;
	static Node[] man;
	static Node[] visit;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		man = new Node[M+1];
		visit = new Node[M+1];
		
		for(int i = 1 ; i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1 ; j<=N;j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					map[i][j] = -1;
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		
		st = new StringTokenizer(in.readLine());
		taxiY = Integer.parseInt(st.nextToken());
		taxiX = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i<=M;i++) {
			st = new StringTokenizer(in.readLine());
			man[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			visit[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			map[man[i].y][man[i].x]=i;
		}
		
		for(int m = 1; m<=M;m++) {
			
			boolean[][] visited = new boolean[N+1][N+1];
			int[] nearMan = findNearMan(taxiY,taxiX,visited);
			int index = nearMan[0];
			if(index == 0) {
				F = -1;
				break;
			}
			int length = nearMan[1];
			if(F>=length) {
				F-=length;
				taxiY = man[index].y;
				taxiX = man[index].x;
				map[man[index].y][man[index].x] = 0;
			}
			else {
				F = -1;
				break;
			}
			
			visited = new boolean[N+1][N+1];
			length = findShortLength(taxiY,taxiX,visit[index],visited);
			if(length == 0) {
				F = -1;
				break;
			}
			if(F>=length) {
				F+=length;
				taxiY = visit[index].y;
				taxiX = visit[index].x;
			}
			else {
				F = -1;
				break;
			}
		}
		
		System.out.println(F);
		
	}


	private static int findShortLength(int y, int x, Node node, boolean[][] visited) {
		
		int length = 0;
		Queue<int[]> que = new LinkedList<>();
		Queue<int[]> que2 = new LinkedList<>();
		que.add(new int[] {y,x});
		
		while(!que.isEmpty()) {
			while(!que.isEmpty()) {
				que2.add(que.poll());
			}
			
			while(!que2.isEmpty()) {
				
				int[] temp = que2.poll();
				
				for(int i = 0 ; i<4;i++) {
					int ty = temp[0]+ dy[i];
					int tx = temp[1]+ dx[i];
					
					if(isSafe(ty,tx)&&map[ty][tx]>=0&&!visited[ty][tx]) {
						if(ty==node.y&&tx==node.x) {
							return length+1;
						}
						else {
							que.add(new int[] {ty,tx});
							visited[ty][tx] = true;
						}
					}
				}
			}
			length++;
		}
		
		return length;
	}


	private static int[] findNearMan(int y, int x, boolean[][] visited) {
		
		Queue<int[]> que = new LinkedList<int[]>();
		Queue<int[]> que2 = new LinkedList<int[]>();
		que.add(new int[] {y,x});
		int index = 0;
		int length = 0;
		visited[y][x] = true;
		boolean flag = false;
		
		if(map[y][x]>=1) {
			index = map[y][x];
			return new int[] {index,length};
		}
		
		while(!que.isEmpty()) {
			while(!que.isEmpty()) {
				que2.add(que.poll());
			}
			
			while(!que2.isEmpty()) {
				int[] temp = que2.poll();
				
				for(int i = 0 ; i<4;i++) {
					int ty = dy[i]+temp[0];
					int tx = dx[i]+temp[1];
					
					if(isSafe(ty,tx) && map[ty][tx] >= 0 && !visited[ty][tx]) {
						if(map[ty][tx] >= 1) {
							flag = true;
							if(index!=0) {
								if(ty <= man[index].y) {
									if(ty<man[index].y) {
										index = map[ty][tx];
									}
									else {
										if(tx<man[index].x) {
											index = map[ty][tx];
										}
									}
								}
							}
							else {
								index = map[ty][tx];
							}
						}
						else {
							que.add(new int[] {ty,tx});
							visited[ty][tx] = true;
						}
					}
				}
			}
			length++;
			if(flag)break;
		}
		
		
		return new int[] {index,length};
	}


	private static boolean isSafe(int ty, int tx) {
		return 1<=ty&&ty<=N&&1<=tx&&tx<=N;
	}
}
