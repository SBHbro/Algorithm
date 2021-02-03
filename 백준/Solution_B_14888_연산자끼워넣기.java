package study_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_14888_�����ڳ����ֱ� {

	static int N;
	static int[] data;
	static int[] cal;
	static int Max,Min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//dfs
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N];
		cal = new int[4];
		Max = Integer.MIN_VALUE;
		Min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i<N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i<4;i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,data[0]);
		
		System.out.println(Max);
		System.out.println(Min);
		
	}

	private static void dfs(int depth,int now) {
		//���ڹ迭�� depth�� N�϶� �ּҰ��� �ִ밪�� ã�´�.
		if(depth==N) {
			Max = Math.max(now, Max);
			Min = Math.min(now, Min);
			return;
		}
		
		//0~4���� ���鼭 ���� ���� cal�迭�� �����ִٸ� ����ؼ� ���� depth�� �ѱ��.
		for(int i = 0 ; i<4;i++) {
			int temp = now;
			if(0<cal[i]) {
				if(i==0) {
					temp+=data[depth];
				}
				else if(i==1) {
					temp-=data[depth];
				}
				else if(i==2) {
					temp*=data[depth];
				}
				else if(i==3) {
					if(temp>0) {
						temp/=data[depth];
					}
					else {
						temp *= -1;
						temp /=data[depth];
						temp *= -1;
					}
				}
				cal[i]--;
				dfs(depth+1,temp);
				cal[i]++;
			}
		}
	}
	
	
}
