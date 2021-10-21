package study_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_B_3190_뱀 {

	static int N, K, L;
	static Set<XY> apple;
	static List<XY> snake;
	static int sy = 0, sx = 0;
	static int direction;
	static int second;
	static int[] dy = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dx = { 0, 1, 0, -1 };

	static class XY {
		int y;
		int x;

		public XY(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object obj) {
			XY a = (XY) obj;
			return this.y == a.y && this.x == a.x;
		}

		@Override
		public int hashCode() {
			return this.y * 101 + this.x * 102;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());

		//사과좌표입력
		apple = new HashSet<>();
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int ty = Integer.parseInt(st.nextToken()) - 1;
			int tx = Integer.parseInt(st.nextToken()) - 1;
			apple.add(new XY(ty, tx));
		}

		//움직임 입력
		L = Integer.parseInt(in.readLine());
		Queue<int[]> moving = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int second = Integer.parseInt(st.nextToken());
			int dir = st.nextToken().charAt(0) == 'D' ? 1 : -1;
			moving.add(new int[] { second, dir });
		}

		snake = new ArrayList<>();
		snake.add(new XY(sy, sx));
		direction = 1;

		outloop: while (true) {
			// 큐에서 돌아갈 시간와 방향을 꺼낸다.
			int[] temp;
			if (!moving.isEmpty()) {
				temp = moving.poll();
			} else {
				temp = new int[] { 100001, direction };
			}

			// 초가 작은동안 계속 뱀의 방향으로 한칸씩 간다.
			while (second < temp[0]) {
				int ty = sy + dy[direction];
				int tx = sx + dx[direction];
				XY head = new XY(ty, tx);

				// 범위를 넘어가거나 내 몸을 만나면 죽는다.
				if (!isSafe(ty, tx) || snake.contains(head)) {
					second++;
					break outloop;
				}

				snake.add(0, head);
				// 이동한 곳이 사과면? 리스트의 맨앞에 사과를 추가.
				if (apple.contains(head)) {
					apple.remove(head);
				}
				// 이동한곳이 사과가 없으면? 리스트의 맨 뒤 원소 삭제.
				else {
					snake.remove(snake.size() - 1);
				}
				sy = ty;
				sx = tx;
				second++;
			}

			// 방향을 돌린다.
			direction += temp[1];
			if (direction == -1)
				direction = 3;
			else if (direction == 4) {
				direction = 0;
			}
		}

		System.out.println(second);

	}

	static boolean isSafe(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
