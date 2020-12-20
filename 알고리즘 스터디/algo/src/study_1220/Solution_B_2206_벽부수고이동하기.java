package study_1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_2206_���μ����̵��ϱ� {

	static int[][] map;
	static int[][] isValid;
	static int N, M;
	static int answer;
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isValid = new int[N][M];

		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		answer = -1;

		bfs();

		System.out.println(answer);

	}

	private static void bfs() {
		// ù ��ġ�� ť�� �ִ´� (y,x,�ν����� ����)
		// �ϳ��� ������ ���Ž��(���̸� �ν����� ���� Ȯ�� �� �μ��� ����)
		// �ٽ� ������ ���Ž�� �� N,M�� �������� �� �����Ѵ�.

		Queue<int[]> que = new LinkedList<int[]>();
		Queue<int[]> que2 = new LinkedList<int[]>();

		que.add(new int[] { 0, 0, 1, 0 });

		int ans = 1;

		while (!que.isEmpty()) {

			while (!que.isEmpty()) {
				que2.add(que.poll());
			}

			while (!que2.isEmpty()) {
				int[] temp = que2.poll();

				for (int i = 0; i < 4; i++) {
					int ty = dy[i] + temp[0];
					int tx = dx[i] + temp[1];

					// ó�� �ͺ� ���� ��
					if (isSafe(ty, tx) && isValid[ty][tx] == 0) {
						// ���̶�� �ν��� üũ �� isValid �� ����
						isValid[ty][tx] = temp[2] + 1;
						if (map[ty][tx] == 1) {
							que.add(new int[] { ty, tx, temp[2] + 1, 1 });
						} else {
							que.add(new int[] { ty, tx, temp[2] + 1, 0 });
						}
					}
					// ó�� �� ���� �ƴ� ��
					else if (isSafe(ty, tx) && isValid[ty][tx] != 0) {
						// �̹� �μ��� ���� ��쿡�� �̵��Ϸ��� ��ǥ�� ���� �ƴ� ���� isValid���̶� ���ؼ� ���� Ŭ��� �Ҹ�
						if (temp[3] == 1) {
							if (map[ty][tx]==0&&temp[2] + 1 <= isValid[ty][tx]) {
								que.add(new int[] { ty, tx, temp[2] + 1, temp[3] });
								isValid[ty][tx] = temp[2] + 1;
							}
						}
						// �μ��� �ʰ� ���� ���
						else if (temp[3] == 0) {
							//���� �������� �̵��Ϸ��� ��ǥ�� ������ �۰ų� ��������
							if(temp[2]+1<=isValid[ty][tx]) {
								if(map[ty][tx] == 0)
									que.add(new int[] {ty,tx,temp[2]+1,0});
								else if(map[ty][tx] == 1)
									que.add(new int[] {ty,tx,temp[2]+1,1});
							}
						}
					}
				}

			}

			ans++;

		}

	}

	private static boolean isSafe(int y, int x) {
		// TODO Auto-generated method stub
		return 0 <= y && y < N && 0 <= x && x < M;
	}
}
