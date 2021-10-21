package study_0116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_D2_1940_가랏RC카 {

	static int T;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t<=T;t++) {
			
			int answer = 0;
			int speed = 0;
			int time = Integer.parseInt(in.readLine());
			for(int i = 0 ;i<time;i++) {
				st = new StringTokenizer(in.readLine());
				int type = Integer.parseInt(st.nextToken());
				if(type == 1) {
					speed += Integer.parseInt(st.nextToken());
				}
				else if(type == 2) {
					speed -= Integer.parseInt(st.nextToken());
				}
				
				if(speed<0) speed = 0;
				answer+=speed;
			}
			
			System.out.println("#"+t+" "+answer);
			
		}
	}
}
