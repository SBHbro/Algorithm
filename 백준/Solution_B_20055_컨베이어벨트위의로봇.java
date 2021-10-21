package study_1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_20055_컨베이어벨트위의로봇 {

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
		// 돌리기
		int temp = map[max];
		for (int i = max; i > 1; i--) {
			map[i] = map[i - 1];
			isRobot[i] = isRobot[i - 1];
		}
		map[1] = temp;
		isRobot[1] = false;
		// 마지막에 있는 로봇 빼기
		isRobot[N] = false;
	}

	public static void move() {
		// 로봇 이동
		for (int i = N - 1; i >= 1; i--) {
			// 로봇이 있다면
			if (isRobot[i]) {
				// 내구도가 0보다 크고 다른 로봇이없다면
				if (!isRobot[i + 1] && 0 < map[i + 1]) {
					map[i + 1]--;
					isRobot[i] = false;
					isRobot[i + 1] = true;
					if (map[i + 1] == 0)
						count++;
				}
			}
		}

		// 로봇 올리기
		if (map[1] > 0 && !isRobot[1]) {
			map[1]--;
			isRobot[1] = true;
			if (map[1] == 0)
				count++;
		}

		// 마지막에 있는 로봇 빼기
		isRobot[N] = false;
	}
}
