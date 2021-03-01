package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_13305_주유소 {

	static class City{
		int nextCity = 0;
		int fuel = 0;
		@Override
		public String toString() {
			return "City [nextCity=" + nextCity + ", fuel=" + fuel + "]";
		}
		
	}
	
	static int N;
	static City[] data;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		data = new City[N];
		for(int i = 0 ; i<N;i++) {
			data[i] = new City();
		}
		
		
		st = new StringTokenizer(in.readLine());
		StringTokenizer st2 = new StringTokenizer(in.readLine());
		
		List<long[]> cal = new ArrayList<long[]>();
		
		data[0].nextCity = Integer.parseInt(st.nextToken());
		data[0].fuel = Integer.parseInt(st2.nextToken());
		cal.add(new long[] {data[0].nextCity,data[0].fuel});
		
		for(int i = 1 ; i<N-1;i++) {
			data[i].nextCity = Integer.parseInt(st.nextToken());
			data[i].fuel = Integer.parseInt(st2.nextToken());
			
			
			//지금꺼랑 들어있는거 마지막거랑 비교해서 더 싸면 자기가격과 자기 거리 넣음
			//더 비쌀경우 마지막 싼 가격과 자기 거리 넣음
			long[] temp = cal.get(cal.size()-1);
			if(temp[1]<=data[i].fuel){
				temp[0]+=data[i].nextCity;
			}
			else {
				cal.add(new long[] {data[i].nextCity,data[i].fuel});
			}
		}
		for(long[] a : cal) {
			answer += a[0]*a[1];
		}
		System.out.println(answer);
		
		
	}
	
}
