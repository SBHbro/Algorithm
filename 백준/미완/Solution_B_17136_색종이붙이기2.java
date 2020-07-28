package algo_study_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_17136_�����̺��̱�2 {

	static int[][] map;
	static int N = 10;
	static int ans;
	static int[] paper;
	static boolean isAns;

	// �������� ũ��� 1.1 2.2 3.3 4.4 5.5
	// ���� 10x10
	// 10x10 ���� ������ ū�ͺ��� 2���������� ���� �����̷� ���� �� �ִ��� �˻�
	// ���� �� ���� ��� �׺κ��� ��� 0 ���� ����
	// �������� 1�� �ִ��� Ȯ���� �� ������ ans ������ -1���
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
//		//y,x�� 10�� ����������
//		if(y>=N-1&&x>=N-1) {
//			
//		}
//		
		if(k>ans)return;
		
		
		
		//0���ͳ����� Ȯ���Ѵ�
		for(int i =y;i<N;i++) {
			for(int j = 0 ;j<N;j++) {
				//���� 1�ϰ��
				if(map[i][j]==1) {
					//������ũ�� 1~5���� ���鼭
					for(int t =4;t>=0;t--) {
						//1~5�� ũ���� ���̷� ������ �ִ���, �� ���̰� �����ִ��� Ȯ���ϰ�
						if(check(i,j,t,map)&&paper[t]>=0) {
							//map ����
							int[][] map2 = new int[N][N];
							for(int z = 0;z<N;z++) {
								map2[z] = map[z].clone();
							}
							
							//���� dfsȣ��
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
