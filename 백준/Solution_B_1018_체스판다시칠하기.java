package study_0117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_1018_체스판다시칠하기 {
	
	//입력받음
	//8*8로 끊을 수 있는 최대 값부터 0,0까지 모든 범위에 대해 검사
	//검사 -> 첫위치의 색깔 확인 -> 한칸씩 진행하면서 이 색깔이여야 하는것과 이칸의 색깔이 맞는지 비교 ->틀리면 temp++
	//answer찾기
	
	static char[][] map;
	static int N,M;
	static int answer;
	static char[][] W;
	static char[][] B;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0 ; i<N;i++) {
			map[i] = in.readLine().toCharArray();
		}
		//W,B 만든다.
		W = new char[8][8];
		B = new char[8][8];
		
		int temp = 0;
		for(int i = 0 ; i<8;i++) {
			for(int j = 0 ; j<8;j++) {
				if(temp%2==0) {
					W[i][j] = 'W';
					B[i][j] = 'B';
				}
				else {
					W[i][j] = 'B';
					B[i][j] = 'W';
				}
				temp++;
			}
			temp++;
		}
		//비교했을때더작은것
		
		
		answer = Integer.MAX_VALUE;
		
		for(int i = N-8; i>=0;i--) {
			for(int j = M-8;j>=0;j--) {
				answer = Math.min(answer, checkNum(i,j));
			}
		}
		
		System.out.println(answer);
		
		
	}

	private static int checkNum(int y, int x) {
		int wCount=0;
		int bCount =0;
		int ty = 0;
		int tx = 0;
		for(int i = y; i<y+8;i++) {
			for(int j = x; j<x+8;j++) {
				if(map[i][j] != W[ty][tx]) {
					wCount++;
				}
				if(map[i][j] != B[ty][tx]) {
					bCount++;
				}
				tx++;
			}
			ty++;
			tx = 0;
		}
		return Math.min(wCount, bCount);
		
	}
}
