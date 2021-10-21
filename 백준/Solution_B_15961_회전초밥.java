package study_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_15961_회전초밥 {

	static int N,D,K,C;//접시의 수, 초밥의 가지수, 연속해서 먹는 접시의 수, 쿠폰번호
	static int[] input;//초밥이 놓여있는 순서
	static int[] data;//초밥의 개수
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		data = new int[D+1];
		
		for(int i = 0 ; i<N;i++) {
			input[i] = Integer.parseInt(in.readLine());
		}
		
		
		for(int i = 0 ; i<K;i++) {
			if(data[input[i]]==0) {
				answer++;
			}
			data[input[i]]++;
		}
//		System.out.println(Arrays.toString(data));
		
		int nowMax = answer;
		int last = K;
		for(int i = 1; i<N;i++) {
//			System.out.println(i-1 + " " +last);
//			System.out.println(input[i-1]);
//			System.out.println(data[input[i-1]]);
			data[input[i-1]]--;
			if(data[input[i-1]]==0) {
				nowMax--;
			}
//			System.out.println(data[input[i-1]]);
			
			if(data[input[last]]==0) {
				nowMax++;
			}
			data[input[last]]++;
			
			int temp = nowMax;
			if(data[C]==0)
				temp++;
			
			answer = Math.max(answer, temp);
			last = last+1==N?0:last+1;
//			System.out.println(Arrays.toString(data));
//			System.out.println(answer);
		}
		System.out.println(answer);
		
	}
}
