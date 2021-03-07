package study_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_12738_가장긴증가하는부분수열3 {

	static int N;
	static List<Integer> data = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		data.add(Integer.parseInt(st.nextToken()));
		
		for(int i = 0 ;i<N-1;i++) {
			int input = Integer.parseInt(st.nextToken());
			boolean check = false;
			for(int j = 0 ;j<data.size();j++) {
				if(input<=data.get(j)) {
					data.set(j, input);
					check = true;
					break;
				}
			}
			if(!check) {
				data.add(input);
			}
		}
		
		System.out.println(data.size());
	}
	
}
