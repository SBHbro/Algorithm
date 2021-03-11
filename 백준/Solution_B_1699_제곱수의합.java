package study_0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_1699_���������� {

	//��Ʈ�� ���� ���� ū ���� ã��
	//�Է°����� ã�Ƴ� ���� ������ �� �� �ݺ�
	static int N;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(Math.sqrt(99999));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		answer = Integer.MAX_VALUE;
		dfs(N,0);
		
		System.out.println(answer);
		
	}
	
	public static void dfs(int input,int depth) {
//		System.out.println(input+ " " +depth);
		if(input == 0) {
			answer = Math.min(answer, depth);
			return;
		}
		if(answer<=depth)
			return;
		//�Է°��� ��Ʈ ������ ����ã��
		//�Է°� - ã�Ƴ���^2 == 0�ϰ�� depth+1 ����
		//�Է°� - ã�Ƴ���^2�� �Է����� �ְ� depth+1
		
		int rootedInput = (int)Math.sqrt(input);
		for(int i = rootedInput;i>0;i--) {
			if(depth+1<answer)
			dfs(input - (int)Math.pow(i, 2),depth+1);
		}
		
	}
	
}
