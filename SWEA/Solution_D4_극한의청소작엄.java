package study_0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_극한의청소작엄 {
	
	static int T;
	static long A,B;
	static long[] countFour;
	static long answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		countFour = new long[13];
		countFour[1] = 1;
		
		for(int i = 2; i<=12;i++) {
			countFour[i] = (long) Math.pow(10, i-1)+(countFour[i-1]*9); 
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		for(int t = 1 ; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			if(A<0&&0<B) {
				A*=-1;
				answer = A+B-getStair(A)-getStair(B)-1;
			}
			else {
				if(A<0&&B<0) {
					long temp = A*-1;
					A = B*-1;
					B = temp;
				}
				answer = B-A-getStair(B)+getStair(A);
			}
			
			System.out.println("#"+t+" "+answer);
		}
		
	}
	
	public static long getStair(long input) {
		if(input<10) {
			if(input<4)
				return 0;
			else return 1;
		}
		
		String data = Long.toString(input);
		
		int first = Integer.parseInt(data.charAt(0)+"");
		int pow = data.length()-1;

		if(first<4) {
			return first*countFour[pow]+getStair(input%(long)Math.pow(10, pow));
		}
		else {
			return (first-1)*countFour[pow]+(long)(Math.pow(10, pow))+getStair(input%(long)Math.pow(10, pow));
		}
	}
}
