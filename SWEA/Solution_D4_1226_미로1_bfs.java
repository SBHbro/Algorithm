

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1226_미로1_bfs {

	static int N = 16;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;
	static boolean[][] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			// 테스트케이스 번호받는부붑
			in.readLine();

			// 변수 초기화
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = 0;
			queue = new LinkedList<int[]>();

			// 데이터 입력
			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input.charAt(j) + "");
				}
			}

			queue.add(new int[]{1,1});
			while(!queue.isEmpty()&&ans==0) {
				int[] temp = queue.poll();
				int y = temp[0];
				int x = temp[1];
				visited[y][x] = true;
				
				for(int i =0;i<4;i++) {
					int ty = y+dy[i];
					int tx = x+dx[i];

					if(isSafe(ty,tx)&&map[ty][tx]!=1&&!visited[ty][tx]) {
						if(map[ty][tx]==3) {
							ans = 1;
						}
						
						queue.add(new int[] {ty,tx});
					}
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}

	}

	private static boolean isSafe(int ty, int tx) {
		return 0 <= ty && ty < N && 0 <= tx && tx < N;
	}
}
