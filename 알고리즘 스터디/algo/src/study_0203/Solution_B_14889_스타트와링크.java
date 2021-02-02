package study_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_14889_��ŸƮ�͸�ũ {

	static int N;
	static int[][] S;
	static boolean[] checked;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		S = new int[N][N];
		checked = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j<N;j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//N/2�� ����. ����� ������� ������ �������� ������.
		//dfs ������ N/2����
		//boolean�迭 ���
		
		dfs(0,0,0);
		
		System.out.println(answer);
	}

	private static void dfs(int depth,int k,int teamA) {
		
		if(depth == N/2) {
			int teamB=0;
			for(int i = 0 ; i<N;i++) {
				if(!checked[i]) {
					for(int j = 0 ;j<N;j++) {
						if(i!=j&&!checked[j])
							teamB+=S[i][j];
					}
				}
			}
			
			answer = Math.min(answer, Math.abs(teamA-teamB));
			return;
		}
		
		for(int i = k ; i<N;i++) {
			if(!checked[i]) {
				int temp=0;
				checked[i] = true;
				for(int j = 0 ; j<N;j++) {
					if(checked[j])
						temp+=S[j][i]+S[i][j];
				}
				dfs(depth+1,i,teamA+temp);
				checked[i] = false;
			}
		}
		
	}
	
}
