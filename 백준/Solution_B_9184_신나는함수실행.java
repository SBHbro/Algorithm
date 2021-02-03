package study_0203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_B_9184_신나는함수실행 {
	
	static int[][][] data;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		data = new int[51][51][51];
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1&&b==-1&&c==-1)
				break;
			
			int answer = w(a,b,c);
			
			out.write("w("+a+", "+b+", "+c+") = "+answer+"\n");			
		}
		
		out.close();
		
	}

	private static int w(int a, int b, int c) {
		
		if(a<=0 || b<=0 || c<=0) {
			return 1;
		}
		
		if(20<a || 20<b || 20<c) {
//			data[a][b][c] = w(20,20,20);
//			return data[a][b][c];
			return w(20,20,20);
		}
		
		
		if(a<b && b<c) {
			if(data[a][b][c-1]==0)
				data[a][b][c-1] = w(a,b,c-1);
			
			if(data[a][b-1][c-1]==0)
				data[a][b-1][c-1] = w(a,b-1,c-1);
			
			if(data[a][b-1][c] ==0)
				data[a][b-1][c] = w(a,b-1,c);
	
			return data[a][b][c-1] + data[a][b-1][c-1] - data[a][b-1][c];
		}
		else {
			
			if(data[a-1][b][c]==0)
				data[a-1][b][c] = w(a-1,b,c);
			
			if(data[a-1][b-1][c]==0)
				data[a-1][b-1][c] = w(a-1,b-1,c);
			
			if(data[a-1][b][c-1]==0)
				data[a-1][b][c-1] = w(a-1,b,c-1);
			
			if(data[a-1][b-1][c-1]==0)
				data[a-1][b-1][c-1] = w(a-1,b-1,c-1);
			
			return data[a-1][b][c] + data[a-1][b-1][c] + data[a-1][b][c-1] - data[a-1][b-1][c-1];
		}
			
			
		
	}
	
}
