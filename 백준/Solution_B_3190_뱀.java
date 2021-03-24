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

public class Solution_B_3190_�� {

	static int N, K, L;
	static Set<XY> apple;
	static List<XY> snake;
	static int sy = 0, sx = 0;
	static int direction;
	static int second;
	static int[] dy = { -1, 0, 1, 0 }; // �� �� �� ��
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

		//�����ǥ�Է�
		apple = new HashSet<>();
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int ty = Integer.parseInt(st.nextToken()) - 1;
			int tx = Integer.parseInt(st.nextToken()) - 1;
			apple.add(new XY(ty, tx));
		}

		//������ �Է�
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
			// ť���� ���ư� �ð��� ������ ������.
			int[] temp;
			if (!moving.isEmpty()) {
				temp = moving.poll();
			} else {
				temp = new int[] { 100001, direction };
			}

			// �ʰ� �������� ��� ���� �������� ��ĭ�� ����.
			while (second < temp[0]) {
				int ty = sy + dy[direction];
				int tx = sx + dx[direction];
				XY head = new XY(ty, tx);

				// ������ �Ѿ�ų� �� ���� ������ �״´�.
				if (!isSafe(ty, tx) || snake.contains(head)) {
					second++;
					break outloop;
				}

				snake.add(0, head);
				// �̵��� ���� �����? ����Ʈ�� �Ǿտ� ����� �߰�.
				if (apple.contains(head)) {
					apple.remove(head);
				}
				// �̵��Ѱ��� ����� ������? ����Ʈ�� �� �� ���� ����.
				else {
					snake.remove(snake.size() - 1);
				}
				sy = ty;
				sx = tx;
				second++;
			}

			// ������ ������.
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
