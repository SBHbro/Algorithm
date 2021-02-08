package study_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_2565_ภüฑ๊มู {

	static List<Integer> LIS = new ArrayList<Integer>();
	static int N;
	static int answer;
	static int[] data;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		data = new int[501];
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int tempA = Integer.parseInt(st.nextToken());
			int tempB = Integer.parseInt(st.nextToken());
			data[tempA] = tempB;
		}
		
		for(int i = 1;i<501;i++) {
			
			if(data[i] != 0) {
				if(LIS.isEmpty()) {
					LIS.add(data[i]);
				}
				else {
					int temp = 0;
					boolean check= false;
					for(int j =0;j<LIS.size();j++) {
						if(data[i]<LIS.get(j)) {
							check = true;
							temp = j;
							break;
						}
					}
					if(check)
						LIS.set(temp, data[i]);
					else
						LIS.add(data[i]);
				}
			}
			
		}
		
		System.out.println(N-LIS.size());
	}
	
}
