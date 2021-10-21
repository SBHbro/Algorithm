package algo_study_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_4179_遺 {

	static int R, C;// ???
	static char[][] map; // 留?
	static boolean isExit; // ?異??吏
	static int ans;
	static Queue<int[]> que; //遺 ????
	static Queue<int[]> que2; // ?щ ????

	static int fx, fy;// 遺? 醫?
	static int ux, uy;// ?щ 醫?

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 1;
		que = new LinkedList<int[]>();
		que2 = new LinkedList<int[]>();
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			map[i] = input.toCharArray();
			if (input.contains("F")) { // 遺怨???? ?移 ??, 遺? ??媛 ????
				fy = i;
				fx = input.indexOf("F");
				que.add(new int[] {fy,fx});
			}
			if (input.contains("J")) {
				uy = i;
				ux = input.indexOf("J");
				que2.add(new int[] {uy,ux});
			}
		}
		
		if(isEnd(uy, ux)) // 泥?遺???異? ? ?? ?移? ??ㅻ㈃
			isExit=true;
		
		// while臾???? 遺 ?吏?닿? ?щ ?吏?닿?
		while (true) {
			if (isExit)//?異??ㅻ㈃
				break;
			if (que2.isEmpty()) // ?щ????댁 ?대? ? ??ㅻ㈃
				break;

			fireMove();
			manMove();
			ans++;
		}

		if (isExit)
			System.out.println(ans);
		else
			System.out.println("IMPOSSIBLE");
	}

	private static void manMove() {
		Queue<int[]> tmp = new LinkedList<int[]>();
		while (!que2.isEmpty()) {
			tmp.add(que2.poll());
		}
		while(!tmp.isEmpty()) {
			int[] temp = tmp.poll();
			
			for(int i = 0 ; i<4;i++) {
				int ty = temp[0]+dy[i];
				int tx = temp[1]+dx[i];
				
				if(isSafe(ty, tx) && map[ty][tx] == '.') {
					map[ty][tx] = 'J';
					que2.add(new int[] {ty,tx});
					if(isEnd(ty, tx))
						isExit=true;
				}
			}
			
		}
		
	}

	private static void fireMove() {
		Queue<int[]> tmp = new LinkedList<int[]>();
		while (!que.isEmpty()) {
			tmp.add(que.poll());
		}
		while(!tmp.isEmpty()) {
			int[] temp = tmp.poll();
			
			for(int i = 0 ; i<4;i++) {
				int ty = temp[0]+dy[i];
				int tx = temp[1]+dx[i];
				
				if(isSafe(ty, tx) && (map[ty][tx] == '.'||map[ty][tx]=='J')) {
					map[ty][tx] = 'F';
					que.add(new int[] {ty,tx});
				}
			}
			
		}
		

	}

	private static boolean isEnd(int ty, int tx) {
		// TODO Auto-generated method stub
		return ty == 0 || ty == R - 1 || tx == 0 || tx == C - 1;
	}

	private static boolean isSafe(int ty, int tx) {
		// TODO Auto-generated method stub
		return 0 <= ty && ty < R && 0 <= tx && tx < C;
	}

}
