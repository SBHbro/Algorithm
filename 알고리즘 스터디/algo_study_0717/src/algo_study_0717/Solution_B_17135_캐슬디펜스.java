package algo_study_0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_B_17135_ĳ�����潺 {

	static int N, M; // y,x
	static int[][] map; // ��
	static int ay, ax;
	static int sy, sx;
	static int D;// ����
	static int answer;
	static int answerTemp;
	static int[] archer; // �ü� ����
	static int[] dy = { -1, 0, 0 };
	static int[] dx = { 0, 1, -1 };
	static Queue<int[]> enemy = new LinkedList<>();
	static boolean[][] visited;
	// �ü��� 3��
	// �ü��� ��� ���ÿ� �����ϸ� �������� �� ���� �ִ�.
	// �Ÿ��� D ������ �� �߿��� ���� ����� ���̰� ������ ��������� ���� ���ʿ� �ִ� ���� ����
	// ������ ������ ���� �̵�
	// �� �Ʒ��ٿ� ������� ���ӿ��� ����
	// �ʿ� ���� ���ٸ� ���� ����

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// �ʱ�ȭ
		map = new int[N + 1][M];
		archer = new int[3];
		answer = Integer.MIN_VALUE;

		// 0 ����� 1 ��
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(answer);
	}

	// �ü����� ��ġŽ��
	private static void dfs(int depth, int v) {
		if (depth == 3) {
			int[][] map2 = new int[N + 1][M];
			for (int i = 0; i < N + 1; i++) {
				map2[i] = map[i].clone();
			}
			answerTemp = 0;
			catleDefense(map2);
			answer = Math.max(answer, answerTemp);
			return;
		}

		for (int i = v; i < M; i++) {
			archer[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}

	// 1. �ü�ǥ�� Ž�� - 1������ 3������ �ؼ� ǥ���� ť�� �ִ´�.
	// ������ �˻�, �Ÿ��� �ü��� �������� �۰� ���� ǥ���̸� �Ÿ��� ���� ǥ��
	// 2. ���
	// 3. �� �̵�
	// 4. ���ִ��� Ȯ�� �� ������� ����
	private static void catleDefense(int[][] map) {
		while (checkEnemy(map)) {
			for (int i = 0; i < 3; i++) {
				ay = N;
				ax = archer[i];
				findEnemy(N, archer[i], map);
			}
			shoot(map);
			moveEnemy(map);
		}
	}

	// 1. �ü�ǥ�� Ž�� - 1������ 3������ �ؼ� ǥ���� ť�� �ִ´�.
	// ������ �˻�, �Ÿ��� �ü��� �������� �۰� ���� ǥ���̸� �Ÿ��� ���� ǥ��
	private static void findEnemy(int y, int x, int[][] map) {
		Queue<int[]> que = new LinkedList<>();
		Queue<int[]> enemyQue = new LinkedList<>();
		que.add(new int[] { y, x });
		visited = new boolean[N + 1][M];

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			if (visited[temp[0]][temp[1]])
				continue;
			visited[temp[0]][temp[1]] = true;

			for (int i = 0; i < 3; i++) {
				int ty = temp[0] + dy[i];
				int tx = temp[1] + dx[i];

				// �迭�� �������̰� �Ÿ��� ������ �Ÿ����� ª����, �׸��� �湮 ���������
				if (isSafe(ty, tx) && Math.abs(ty - ay) + Math.abs(tx - ax) <= D && !visited[ty][tx]) {
					// Ȯ���� ���� ���� �������
					if (map[ty][tx] == 1) {
						// ť�� �־�а� ������� �ְ�
						if (enemyQue.isEmpty()) {
							enemyQue.add(new int[] { ty, tx });
						}
						// ������� ������ ���Ŀ� �������� �ִ��� �Ȱ����� ���ʰ��� �ִ´�.
						else {
							int[] tp = enemyQue.poll();
							// ������ �� �������
							if (Math.abs(tp[0] - ay) + Math.abs(tp[1] - ax) < Math.abs(ty - ay) + Math.abs(tx - ax)) {
								enemyQue.add(tp);
							}
							// ���簡 �� �����
							else if (Math.abs(tp[0] - ay) + Math.abs(tp[1] - ax) > Math.abs(ty - ay)
									+ Math.abs(tx - ax)) {
								enemyQue.add(new int[] { ty, tx });
							}
							// �������
							else if (Math.abs(tp[0] - ay) + Math.abs(tp[1] - ax) == Math.abs(ty - ay)
									+ Math.abs(tx - ax)) {
								// ������ �� ����
								if (tp[1] < tx) {
									enemyQue.add(tp);
								}
								// ���簡 �� ����
								else if (tx < tp[1]) {
									enemyQue.add(new int[] { ty, tx });
								} else {
									enemyQue.add(new int[] { ty, tx });
								}
							}
						}
					}

					que.add(new int[] { ty, tx });
				}
			}
		}

		if (!enemyQue.isEmpty()) {
			int[] tp = enemyQue.poll();
			enemy.add(tp);
		}
	}

	// 2. ���
	private static void shoot(int[][] map) {
		while (!enemy.isEmpty()) {
			int[] temp = enemy.poll();
			if (temp != null && map[temp[0]][temp[1]] == 1) {
				map[temp[0]][temp[1]] = 0;
				answerTemp++;
			}
		}

	}

	// 3. �� �̵�
	private static void moveEnemy(int[][] map) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					if (i + 1 == N) {
						map[i][j] = 0;
						continue;
					}
					map[i + 1][j] = map[i][j];
					map[i][j] = 0;
				}

			}
		}
	}

	// 4. ���ִ��� Ȯ�� �� ������� ����
	private static boolean checkEnemy(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int ty, int tx) {
		// TODO Auto-generated method stub
		return 0 <= ty && ty < N && 0 <= tx && tx < M;
	}

}
