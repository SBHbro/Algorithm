package study_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_2573_ºù»ê {

	static class Ice {
		int y, x;
		int height;

		public Ice(int y, int x, int height) {
			super();
			this.y = y;
			this.x = x;
			this.height = height;
		}
	}

	static int N, M;
	static int[][] map;
	static int year;
	static int answer;
	static Queue<Ice> meltQue = new LinkedList<>();
	static Queue<Ice> massQue = new LinkedList<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0) {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
					Ice iceTemp = new Ice(i, j, temp);
					meltQue.add(iceTemp);
				}
			}
		}

		year = 2;
		while (!meltQue.isEmpty()) {

			melt();
			if(massQue.isEmpty())
				break;
			if (!mass()) {
				answer = year-1;
				break;
			}
			year++;
		}

		System.out.println(answer);

	}

	private static boolean mass() {
		Ice temp = massQue.poll();
		dfs(temp.y,temp.x);
		while(!massQue.isEmpty()) {
			Ice temp2 = massQue.poll();
			if(map[temp2.y][temp2.x]!=year) {
				return false;
			}
		}
		return true;
	}

	private static void dfs(int y, int x) {
		map[y][x] = year;
		for(int i = 0 ; i<4;i++) {
			int ty = y+dy[i];
			int tx = x+dx[i];
			if(isSafe(ty,tx)&&map[ty][tx] == year-1) {
				dfs(ty,tx);
			}
		}
	}

	private static void melt() {
		Queue<Ice> tempQue = new LinkedList<>();
		Queue<Ice> tempQue2 = new LinkedList<>();

		while (!meltQue.isEmpty()) {
			tempQue.add(meltQue.poll());
		}

		while (!tempQue.isEmpty()) {
			Ice temp = tempQue.poll();

			int minus = 0;
			for (int i = 0; i < 4; i++) {
				int ty = temp.y + dy[i];
				int tx = temp.x + dx[i];
				if (isSafe(ty, tx) && map[ty][tx] == 0) {
					minus++;
				}
			}

			temp.height = temp.height - minus < 0 ? 0 : temp.height - minus;
			
			tempQue2.add(temp);
		}
		
		while(!tempQue2.isEmpty()) {
			Ice temp = tempQue2.poll();
			if(temp.height==0) {
				map[temp.y][temp.x] = 0;
			}
			else {
				meltQue.add(temp);
				massQue.add(temp);
			}
		}
		
	}

	private static boolean isSafe(int ty, int tx) {
		return 0 <= ty && ty < N && 0 <= tx && tx < M;
	}
}
