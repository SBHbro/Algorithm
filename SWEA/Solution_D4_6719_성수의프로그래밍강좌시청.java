package study_0310;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청 {
	
	static int T,N,M;
	static int[] data;
	static double answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		for(int t = 1 ; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = 0;
			data = new int[N];
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ;i<N;i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(data);
			
			for(int i = N-M;i<N;i++) {
				answer = (answer +data[i])/2;
			}
			
			System.out.println("#"+t+" "+answer);
			
		}
		
	}
	
}
