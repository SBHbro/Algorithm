package study_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_19238_스타트택시2 {

	static int N, M;// 맵 크기, 승객 수
	static int[][] map; // 맵
	static int ay, ax;
	static int min; // 승객에게 갈 수 있는 최단거리
	static int fuel;// 연료
	static int minIndex;
	static int[] dy = { -1, 0, 1, 0 }; // 이동에 사용할 배열
	static int[] dx = { 0, -1, 0, 1 };
	static ArrayList<Node> start;
	static ArrayList<Node> end;

	static class Node {

		public int y = 0;
		public int x = 0;
		public int depth = 0;

		public Node(int y, int x, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		start = new ArrayList<>();
		end = new ArrayList<>();

		// 맵 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 택시 시작좌표 입력
		st = new StringTokenizer(in.readLine());
		ay = Integer.parseInt(st.nextToken()) - 1;
		ax = Integer.parseInt(st.nextToken()) - 1;

		// 승객 좌표와 도착지좌표 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			start.add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
			end.add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
		}

		while (M > 0) {
			// 택시에서 승객까지의 최단거리를 모두 구하면서(택시와 승객이 같은곳에 있으면 0, 최단거리가 같을경우 y,x 순으로 작은 승객부터 간다
			// 최단거리가 가장 짧은 승객과 최단거리를 저장해놓는다
			// bfs로 변경
			min = Integer.MAX_VALUE;
			int minLength = Integer.MAX_VALUE;
			if (bfsAll(ay, ax)) {
				minLength = min;
			}
			else {
				fuel = -1;
				break;
			}

			// 택시의 위치를 승객으로 옮긴 후 연료를 이동한 거리만큼 뺀다

			if (fuel - minLength > 0) {
				fuel -= minLength;
				ay = start.get(minIndex).y;
				ax = start.get(minIndex).x;
				
			}

			// 목적지까지의 최단거리 계산 후 연료가 충분하다면 이동한 후 연료를 충전한다.
			min = Integer.MAX_VALUE;
			if (bfs(ay, ax, end.get(minIndex).y, end.get(minIndex).x)) {
				if (fuel - min >= 0) {
					fuel += min;
					ay = end.get(minIndex).y;
					ax = end.get(minIndex).x;
					M--;
					start.remove(minIndex);
					end.remove(minIndex);
				} else {
					fuel = -1;
					break;
				}
			}
			// 이동할 수 없을 경우 종료
			else {
				fuel = -1;
				break;
			}

		}
		System.out.println(fuel);
	}

	private static boolean bfsAll(int sy, int sx) {

		if (isSame(sy, sx)) {
			min = 0;
			return true;
		}
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { sy, sx, 0 });
		boolean[][] check = new boolean[N][N];
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			boolean isEnd = false;
			Queue<int[]> que2 = new LinkedList<int[]>();
			
			for (int i = 0; i < 4; i++) {
				int ty = temp[0] + dy[i];
				int tx = temp[1] + dx[i];
				// 이동할 수 있을 경우에
				if (isSafe(ty, tx) && map[ty][tx] != 1 && !check[ty][tx]) {
					if (isSame(ty, tx)) {
						que2.add(new int[] {ty,tx,temp[2]+1});
						isEnd = true;
//						min = temp[2] + 1;
//						return true;
					}
					check[ty][tx] = true;
					que.add(new int[] { ty, tx, temp[2] + 1 });
				}

			}
			if(isEnd) {
				int[] answer = que2.poll();
				
				while(!que2.isEmpty()) {
					int[] atemp = que2.poll();
					if(answer[0]>atemp[0]) {
						answer = atemp;
					}
					else if(answer[0]==atemp[0]) {
						if(answer[1]>atemp[1]) {
							answer = atemp;
						}
					}
				}
				
				min = answer[2];
				isSame(answer[0],answer[1]);
				return true;
			}
		}

		return false;
	}

	private static boolean isSame(int y, int x) {
		for (int i = 0; i < start.size(); i++) {
			if (start.get(i).y == y && start.get(i).x == x) {
				minIndex = i;
				return true;
			}
		}

		return false;
	}

	private static boolean bfs(int sy, int sx, int ey, int ex) {

		if (sy == ey && sx == ex) {
			min = 0;
			return true;
		}
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { sy, sx, 0 });
		boolean[][] check = new boolean[N][N];
		while (!que.isEmpty()) {
			int[] temp = que.poll();

			for (int i = 0; i < 4; i++) {
				int ty = temp[0] + dy[i];
				int tx = temp[1] + dx[i];
				// 이동할 수 있을 경우에
				if (isSafe(ty, tx) && map[ty][tx] != 1 && !check[ty][tx]) {
//					System.out.println("ty : "+ ty + " tx : " + tx);
					check[ty][tx] = true;
					que.add(new int[] { ty, tx, temp[2] + 1 });
					// 목표지점 도착했을경우
					if (check[ey][ex]) {
						if (min > temp[2] + 1) {
							min = temp[2] + 1;
							return true;
						}
					}
				}

			}
		}

		return false;
	}

	public static boolean isSafe(int y, int x) {
		if (0 <= y && y < N && 0 <= x && x < N)
			return true;
		return false;
	}
}
