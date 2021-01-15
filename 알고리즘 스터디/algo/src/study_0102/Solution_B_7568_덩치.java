package study_0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_7568_��ġ {

	static int N; // ��� ��
	static int[][] data; // ������, Ű, ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		data = new int[N][3];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j<2;j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
			data[i][2] = 1;
		}
		
		for(int i = 0 ;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(data[i][0]<data[j][0]&&data[i][1]<data[j][1]) {
					data[i][2]++;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			System.out.print(data[i][2] + " ");
		}
		
	}
	
}
