package study_0115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_B_11729_하노이탑이동순서 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		
		System.out.println((int)Math.pow(2, N)-1);
		Hanoi(N,1,3,2);
		bw.close();
	}
	
	public static void Hanoi(int N, int start, int end, int stopover) throws IOException {
		if(N==1) {
			bw.write(start+" "+end+"\n");
			return;
		}
		
		Hanoi(N-1,start,stopover,end);
		
		bw.write(start+" "+end+"\n");
		
		Hanoi(N-1,stopover,end,start);
	}
	
}
