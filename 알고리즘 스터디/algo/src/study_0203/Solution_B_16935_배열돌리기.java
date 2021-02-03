package study_0203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_16935_배열돌리기 {

	static int[][] data;
	static int[][] answer;
	static int N, M;
	static int R;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		data = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < R; i++) {
			int rotate = Integer.parseInt(st.nextToken());

			if (rotate == 1) {
				data = upDown();
			} else if (rotate == 2) {
				data = leftRight();
			} else if (rotate == 3) {
				data = rRotate();
			}
			else if(rotate == 4) {
				data = lRotate();
			}
			else if(rotate == 5) {
				data = rAreaRotate();
			}
			else if(rotate == 6) {
				data = lAreaRotate();
			}
			N = data.length;
			M = data[0].length;
		}

		for(int i = 0 ; i<N;i++) {
			for(int j = 0 ; j<M;j++) {
				out.write(data[i][j] + " ");
			}
			out.write("\n");
		}
		
		out.close();

	}

	static int[][] upDown() {
		int[][] temp = new int[N][M];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[N - 1 - j][i] = data[j][i];
			}
		}

		return temp;
	}

	static int[][] leftRight() {
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][M - 1 - j] = data[i][j];
			}
		}

		return temp;
	}

	static int[][] rRotate() {
		int[][] temp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][N - 1 - i] = data[i][j];
			}
		}

		return temp;
	}

	static int[][] lRotate() {
		int[][] temp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[M-1-j][i] = data[i][j];
			}
		}

		return temp;
	}
	
	static int[][] rAreaRotate(){
		int[][] temp = new int[N][M];
		
		int[] ty = new int[] {0,0,N/2,N/2};
		int[] tx = new int[] {0,M/2,M/2,0};
		
		for(int t = 0 ; t<4;t++) {
			int from = t;
			int to = t+1;
			if(to == 4) to = 0;
			
			int dy = ty[to];
			
			for(int i = ty[from];i<ty[from]+N/2;i++) {
				int dx = tx[to];
				for(int j = tx[from];j<tx[from]+M/2;j++) {
					temp[dy][dx] =data[i][j];
					dx++;
				}
				dy++;
			}
			
		}
		
		return temp;
	}
	
	static int[][] lAreaRotate(){
		int[][] temp = new int[N][M];
		
		int[] ty = new int[] {0,0,N/2,N/2};
		int[] tx = new int[] {0,M/2,M/2,0};
		
		for(int t = 0 ; t<4;t++) {
			int from = t;
			int to = t-1;
			if(to == -1) to = 3;
			
			int dy = ty[to];
			
			for(int i = ty[from];i<ty[from]+N/2;i++) {
				int dx = tx[to];
				for(int j = tx[from];j<tx[from]+M/2;j++) {
					temp[dy][dx] =data[i][j];
					dx++;
				}
				dy++;
			}
			
		}
		
		return temp;
	}
}
