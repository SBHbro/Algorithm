package algo_study_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_17136_색종이붙이기2 {

	static int[][] map;
	static int N = 10;
	static int ans;
	static int[] paper;
	static boolean isAns;

	// 색종이의 크기는 1.1 2.2 3.3 4.4 5.5
	// 맵은 10x10
	// 10x10 맵을 색종이 큰것부터 2중포문으로 돌며 색종이로 덮을 수 있는지 검사
	// 덮을 수 있을 경우 그부분을 모두 0 으로 변경
	// 마지막에 1이 있는지 확인한 후 있으면 ans 없으면 -1출력
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		paper = new int[5];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(paper, 5);
		
		dfs(0,0,map,0);

		System.out.println(ans);
	}

	private static void dfs(int y,int x,int[][] map,int k) {
//		System.out.println(y+" "+ x+ " "+ k + " " + ans);
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println(Arrays.toString(paper));
//		System.out.println();
//		//y,x가 10에 도착했을때
//		if(y>=N-1&&x>=N-1) {
//			
//		}
//		
		if(k>ans)return;
		
		
		
		//0부터끝까지 확인한다
		for(int i =y;i<N;i++) {
			for(int j = 0 ;j<N;j++) {
				//맵이 1일경우
				if(map[i][j]==1) {
					//종이의크기 1~5까지 돌면서
					for(int t =4;t>=0;t--) {
						//1~5의 크기인 종이로 덮을수 있는지, 그 종이가 남아있는지 확인하고
						if(check(i,j,t,map)&&paper[t]>=0) {
							//map 복사
							int[][] map2 = new int[N][N];
							for(int z = 0;z<N;z++) {
								map2[z] = map[z].clone();
							}
							
							//다음 dfs호출
							paper[t]--;
							paint(i,j,t,map2);
							dfs(i,j+t+1,map2,k+1);
							paper[t]++;
						}
					}
				}
			}
		}
		
		if(!answer(map)) {
			if(!isAns)ans = 26;
		}
		else{
			isAns=true;
			ans = Math.min(ans, k);
		}
		return;
	}

	private static boolean answer(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}
		return true;
	}


	private static void paint(int y, int x, int k, int[][] map) {
		for (int i = y; i <= y + k; i++) {
			for (int j = x; j <= x + k; j++) {
				map[i][j] = 0;
			}
		}
	}

	private static boolean check(int y, int x, int k,int[][] map) {

		int tmp = 0;
		for (int i = y; i <= y + k; i++) {
			for (int j = x; j <= x + k; j++) {
				if (isSafe(i, j) && map[i][j] == 1)
					tmp++;
				else {
					return false;
				}
			}
		}
		if (tmp == (k+1) * (k+1))
			return true;

		return false;
	}

	private static boolean isSafe(int i, int j) {
		// TODO Auto-generated method stub
		return 0 <= i && i < N && 0 <= j && j < N;
	}

}
