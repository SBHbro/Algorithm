import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7733_移利?? {

	static int T;
	static int[][] map;
	static int N;
	static int max;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());

			map = new int[N][N];
			max = 0;
			visited = new boolean[N][N];
			que = new LinkedList<int[]>();
			ans = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

//			for(int i =0;i<N;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			for (int m = 1; m <= max; m++) {
				int cnt = 0;
				visited=new boolean[N][N];
				// m?대 ?媛?嫄?0?쇰?
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == m) {
							map[i][j] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] != 0 && !visited[i][j]) {
							visited[i][j]=true;
							que.add(new int[] { i, j });
							while (!que.isEmpty()) {
								int[] temp = que.poll();

								for (int k = 0; k < 4; k++) {
									int ay = temp[0] + dy[k];
									int ax = temp[1] + dx[k];

									if (isSafe(ay, ax) && map[ay][ax] != 0 && !visited[ay][ax]) {
										visited[ay][ax] = true;
										que.add(new int[] { ay, ax });
									}
								}
							}
							cnt++;

						}
					}
				}
				//?
				
//				System.out.println("-----------------------------");
//				for(int i = 0 ; i<N;i++) {
//					System.out.println(Arrays.toString(map[i])+ "cnt : "+cnt + " ans : "+ans);
//				}
//				
				ans = Math.max(ans, cnt);

			}
			
			if(ans ==0)
				System.out.println("#"+t+" "+1);
			else
				System.out.println("#"+t+" "+ans);

		}

	}

	private static boolean isSafe(int ay, int ax) {
		// TODO Auto-generated method stub
		return 0 <= ay && ay < N && 0 <= ax && ax < N;
	}
}
