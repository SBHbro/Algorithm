package study_0127;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_H_LuckBalance {

	//100���� �������ֵ�
	//k��ŭ �� �� �ִ�.
	//10000������ �����ִ�.
	//�߿��ѰͰ� �߿����� ���� ���� �ִ�.
	
	//6���� ����, 3�� �������� - ���°� �߿��� ���迡���� 
	//0���� 5���� ������� ���� �ϳ���� ����.
	//��Ʈ�� �迭 ���� ����
	//���� ������ 1���� ���ؼ� ũ�� �ְ� ��ũ�� 2������ �Ѿ�� ���ؼ� ũ�� �ְ� 3��
	//�����͵��� ���� 0 ���� ����
	//÷���� ������ �� ����
	//���� + �̱�� -�� ���� �̱��� ��
	//0�ξֵ��� ���ϰ� 1�ξֵ��� ����.
	//�������� 3���迭��*2�� �����ָ� ��.
	
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
//		int[][] a = {{5,1},{2,1},{1,1},{8,1},{10,0},{5,0}};
//		System.out.println(luckBalance(3, a));
		
	}
	
	static int luckBalance(int k, int[][] contests) {
		int answer = 0;
		
		List<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0 ; i<contests.length;i++) {
//			System.out.println("?");
			if(contests[i][1] == 1) {
				for(int j = 0 ; j<k;j++) {
					if(temp.size()<j+1) {
						temp.add(j,contests[i][0]);
						break;
					}
					else {
						if(temp.get(j)<contests[i][0]) {
							temp.add(j,contests[i][0]);
							if(k<temp.size())
								temp.remove(temp.size()-1);
							break;
						}
					}
				}
				answer-=contests[i][0];
			}
			
			else {
				answer+=contests[i][0];
			}
		}
		
		System.out.println(temp);
		if(!temp.isEmpty()) {
			int value =0;
			
			for(int i = 0;i<temp.size();i++) {
				value+=temp.get(i);
			}
			answer+= value*2;
		}
		
		
		return answer;
		
    }

	
}
