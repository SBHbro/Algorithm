package study_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_11053_가장긴증가하는부분수열_NlogN {

	static int N;
	static int[] data;
	static List<Integer> dp = new ArrayList<Integer>();
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N];
		dp.add(0);
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i<N;i++) {
			int temp = 0;
			boolean flag= false;
			for(int j = 0 ; j<dp.size();j++) {
				if(data[i]<=dp.get(j)) {
					temp = j;
					flag = true;
					break;
				}
			}
			if(!flag)
				dp.add(data[i]);
			else 
				dp.set(temp, data[i]);
		}
		System.out.println(dp.size()-1);
		
	}
	
}
