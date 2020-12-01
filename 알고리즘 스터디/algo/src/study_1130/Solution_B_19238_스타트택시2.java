package study_1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_19238_��ŸƮ�ý�2 {

	static int N, M;// �� ũ��, �°� ��
	static int[][] map; // ��
	static int ay, ax;
	static int min; // �°����� �� �� �ִ� �ִܰŸ�
	static int fuel;// ����
	static int minIndex;
	static int[] dy = { -1, 0, 1, 0 }; // �̵��� ����� �迭
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

		// �� ���� �Է�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// �ý� ������ǥ �Է�
		st = new StringTokenizer(in.readLine());
		ay = Integer.parseInt(st.nextToken()) - 1;
		ax = Integer.parseInt(st.nextToken()) - 1;

		// �°� ��ǥ�� ��������ǥ �Է�
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			start.add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
			end.add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
		}

		while (M > 0) {
			// �ýÿ��� �°������� �ִܰŸ��� ��� ���ϸ鼭(�ýÿ� �°��� �������� ������ 0, �ִܰŸ��� ������� y,x ������ ���� �°����� ����
			// �ִܰŸ��� ���� ª�� �°��� �ִܰŸ��� �����س��´�
			// bfs�� ����
			min = Integer.MAX_VALUE;
			int minLength = Integer.MAX_VALUE;
			if (bfsAll(ay, ax)) {
				minLength = min;
			}
			else {
				fuel = -1;
				break;
			}

			// �ý��� ��ġ�� �°����� �ű� �� ���Ḧ �̵��� �Ÿ���ŭ ����

			if (fuel - minLength > 0) {
				fuel -= minLength;
				ay = start.get(minIndex).y;
				ax = start.get(minIndex).x;
				
			}

			// ������������ �ִܰŸ� ��� �� ���ᰡ ����ϴٸ� �̵��� �� ���Ḧ �����Ѵ�.
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
			// �̵��� �� ���� ��� ����
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
				// �̵��� �� ���� ��쿡
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
				// �̵��� �� ���� ��쿡
				if (isSafe(ty, tx) && map[ty][tx] != 1 && !check[ty][tx]) {
//					System.out.println("ty : "+ ty + " tx : " + tx);
					check[ty][tx] = true;
					que.add(new int[] { ty, tx, temp[2] + 1 });
					// ��ǥ���� �����������
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
