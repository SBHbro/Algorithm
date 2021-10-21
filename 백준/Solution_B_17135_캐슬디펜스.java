package algo_study_0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_B_17135_캐슬디펜스 {

	static int N, M; // y,x
	static int[][] map; // 맵
	static int ay, ax;
	static int sy, sx;
	static int D;// 범위
	static int answer;
	static int answerTemp;
	static int[] archer; // 궁수 저장
	static int[] dy = { -1, 0, 0 };
	static int[] dx = { 0, 1, -1 };
	static Queue<int[]> enemy = new LinkedList<>();
	static boolean[][] visited;
	// 궁수는 3명
	// 궁수는 모두 동시에 공격하며 같은것을 쏠 수도 있다.
	// 거리가 D 이하인 적 중에서 가장 가까운 적이고 가까운게 여러개라면 가장 왼쪽에 있는 적을 공격
	// 공격이 끝나면 적이 이동
	// 맨 아랫줄에 왔을경우 게임에서 제외
	// 맵에 적이 없다면 게임 종료

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// 초기화
		map = new int[N + 1][M];
		archer = new int[3];
		answer = Integer.MIN_VALUE;

		// 0 빈공간 1 적
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(answer);
	}

	// 궁수들의 위치탐색
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

	// 1. 궁수표적 탐색 - 1번부터 3번까지 해서 표적을 큐에 넣는다.
	// 위부터 검사, 거리가 궁수의 범위보다 작고 만약 표적이면 거리가 이전 표적
	// 2. 사살
	// 3. 적 이동
	// 4. 적있는지 확인 후 없을경우 종료
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

	// 1. 궁수표적 탐색 - 1번부터 3번까지 해서 표적을 큐에 넣는다.
	// 위부터 검사, 거리가 궁수의 범위보다 작고 만약 표적이면 거리가 이전 표적
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

				// 배열의 범위안이고 거리가 정해진 거리보다 짧으면, 그리고 방문 안했을경우
				if (isSafe(ty, tx) && Math.abs(ty - ay) + Math.abs(tx - ax) <= D && !visited[ty][tx]) {
					// 확인한 곳에 적이 있을경우
					if (map[ty][tx] == 1) {
						// 큐에 넣어둔게 없을경우 넣고
						if (enemyQue.isEmpty()) {
							enemyQue.add(new int[] { ty, tx });
						}
						// 있을경우 꺼내서 비교후에 가까운것을 넣던지 똑같으면 왼쪽것을 넣는다.
						else {
							int[] tp = enemyQue.poll();
							// 꺼낸게 더 가까울경우
							if (Math.abs(tp[0] - ay) + Math.abs(tp[1] - ax) < Math.abs(ty - ay) + Math.abs(tx - ax)) {
								enemyQue.add(tp);
							}
							// 현재가 더 까가울경우
							else if (Math.abs(tp[0] - ay) + Math.abs(tp[1] - ax) > Math.abs(ty - ay)
									+ Math.abs(tx - ax)) {
								enemyQue.add(new int[] { ty, tx });
							}
							// 같을경우
							else if (Math.abs(tp[0] - ay) + Math.abs(tp[1] - ax) == Math.abs(ty - ay)
									+ Math.abs(tx - ax)) {
								// 꺼낸게 더 왼쪽
								if (tp[1] < tx) {
									enemyQue.add(tp);
								}
								// 현재가 더 왼쪽
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

	// 2. 사살
	private static void shoot(int[][] map) {
		while (!enemy.isEmpty()) {
			int[] temp = enemy.poll();
			if (temp != null && map[temp[0]][temp[1]] == 1) {
				map[temp[0]][temp[1]] = 0;
				answerTemp++;
			}
		}

	}

	// 3. 적 이동
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

	// 4. 적있는지 확인 후 없을경우 종료
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
