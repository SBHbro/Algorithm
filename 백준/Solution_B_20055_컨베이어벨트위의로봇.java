package study_1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_20055_�����̾Ʈ���Ƿκ� {

	static int N, K;
	static int answer = 1;
	static int max, count;
	static int[] map;
	static boolean[] isRobot;

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		max = 2 * N;
		map = new int[max + 1];
		isRobot = new boolean[max + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= max; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		count = 0;
		while (true) {
			rotate();
			move();
			if (count >= K)
				break;
			answer++;
		}
		System.out.println(answer);

	}

	public static void rotate() {
		// ������
		int temp = map[max];
		for (int i = max; i > 1; i--) {
			map[i] = map[i - 1];
			isRobot[i] = isRobot[i - 1];
		}
		map[1] = temp;
		isRobot[1] = false;
		// �������� �ִ� �κ� ����
		isRobot[N] = false;
	}

	public static void move() {
		// �κ� �̵�
		for (int i = N - 1; i >= 1; i--) {
			// �κ��� �ִٸ�
			if (isRobot[i]) {
				// �������� 0���� ũ�� �ٸ� �κ��̾��ٸ�
				if (!isRobot[i + 1] && 0 < map[i + 1]) {
					map[i + 1]--;
					isRobot[i] = false;
					isRobot[i + 1] = true;
					if (map[i + 1] == 0)
						count++;
				}
			}
		}

		// �κ� �ø���
		if (map[1] > 0 && !isRobot[1]) {
			map[1]--;
			isRobot[1] = true;
			if (map[1] == 0)
				count++;
		}

		// �������� �ִ� �κ� ����
		isRobot[N] = false;
	}
}
