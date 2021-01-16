package study_0116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1959_두개의숫자열 {
	
	static int T;
	static int[] A,B;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int t = 1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int aLength = Integer.parseInt(st.nextToken());
			int bLength = Integer.parseInt(st.nextToken());
			A = new int[aLength];
			B = new int[bLength];
			
			st = new StringTokenizer(in.readLine());
			for (int i = 0 ; i<aLength;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0 ; i<bLength;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int time = aLength-bLength;
			int answer = Integer.MIN_VALUE;
			int temp = 0;
			if(0<time) {
				//A가더큼
				for(int i = 0;i<=time;i++) {
					int tb = 0;
					temp = 0;
					for(int j = time-i;j<aLength-i;j++) {
						temp += A[j]*B[tb];
						tb++;
					}
					answer = Math.max(answer, temp);
				}
			}
			else if(time<0) {
				//B가더큼
				time *= -1;
				for(int i = 0;i<=time;i++) {
					int ta = 0;
					temp = 0;
					for(int j = time-i;j<bLength-i;j++) {
						temp += A[ta]*B[j];
						ta++;
					}
					answer = Math.max(answer, temp);
				}
			}
			else if(time == 0) {
				for(int i =0;i<aLength;i++) {
					answer += A[i]*B[i];
				}
			}
			
			System.out.println("#"+t+" "+answer);
			
		}
		
	}
	
	
}
