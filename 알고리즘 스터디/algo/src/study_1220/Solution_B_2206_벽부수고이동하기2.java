package study_1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_2206_벽부수고이동하기2 {

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
		isValid[0][0] =1;

		bfs();
		if(isValid[N-1][M-1] !=0) {
			System.out.println(isValid[N-1][M-1]);
		}
		else
			System.out.println(-1);

	
	}

	private static void bfs() {

		Queue<int[]> que = new LinkedList<int[]>();
		Queue<int[]> que2 = new LinkedList<int[]>();

		que.add(new int[] { 0, 0, 1, 0 });


		while (!que.isEmpty()) {
			
			while (!que.isEmpty()) {
				que2.add(que.poll());
			}

			while (!que2.isEmpty()) {
				for(int i = 0 ; i<N;i++) {
					System.out.println(Arrays.toString(isValid[i]));
				}
				System.out.println();
				int[] temp = que2.poll();

				for (int i = 0; i < 4; i++) {
					int ty = dy[i] + temp[0];
					int tx = dx[i] + temp[1];

					// 처음 와본 곳일 때
					if (isSafe(ty, tx) && isValid[ty][tx] == 0) {
						//벽을 안부수고 온 루트일 경우
						if(temp[3]==0) {
							// 벽이라면 부쉈음 체크 후 isValid 값 갱신
							isValid[ty][tx] = temp[2] + 1;
							if (map[ty][tx] == 1) {
								que.add(new int[] { ty, tx, temp[2] + 1, 1 });
							} else {
								que.add(new int[] { ty, tx, temp[2] + 1, 0 });
							}
						}
						//벽을 부수고 온 루트일 경우
						if(temp[3] == 1) {
							//벽이 아닐때만 값을 넣는다.
							if(map[ty][tx] == 0) {
								que.add(new int[] {ty,tx,temp[2]+1,1});
								isValid[ty][tx] = temp[2]+1;
							}
						}
					}
					// 처음 온 곳이 아닐 때
					else if (isSafe(ty, tx) && isValid[ty][tx] != 0) {
						// 벽을 부수고 온 루트
						if (temp[3] == 1) {
							// 벽이 아니어야 하고 내가 가는 루트가 기존 루트보다 값이 적을 때만 살린다.
							if (map[ty][tx]==0&&temp[2] + 1 < isValid[ty][tx]) {
								que.add(new int[] { ty, tx, temp[2] + 1, temp[3] });
								isValid[ty][tx] = temp[2] + 1;
							}
						}
						// 부수지 않고 왔을 경우
						else if (temp[3] == 0) {
							//내가 가진값이 이동하려는 좌표의 값보다 작거나 같을때만
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

		}

	}

	private static boolean isSafe(int y, int x) {
		// TODO Auto-generated method stub
		return 0 <= y && y < N && 0 <= x && x < M;
	}
}
