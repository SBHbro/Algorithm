package study_1019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_P_���ǰ�� {

	public static void main(String[] args) {
//		int[] answer = {1,2,3,4,5};
		int[] answer = {1,3,2,4,2};
		System.out.println(Arrays.toString(solution(answer)));
	}

	public static int[] solution(int[] answers) {
		int[] answer = new int[3];

		// 1��,2��,3���� ť�� �����.
		Queue<Integer>[] student = new Queue[3];

		for (int i = 0; i < 3; i++) {
			student[i] = new LinkedList<Integer>();
		}

		for (int i = 1; i < 6; i++) {
			student[0].add(i);
		}

		for (int i = 0, j = 1; i < 8; i++) {
			if (i % 2 == 1) {
				student[1].add(j);
				j++;
				j = j==2?3:j;
			} else {
				student[1].add(2);
			}
		}
		
		int[] temp = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		for (int i = 0; i < 10; i++) {
			student[2].add(temp[i]);
		}

		for (int ans : answers) {
			for (int i = 0; i < 3; i++) {
				int stuAns = student[i].poll();
				if (stuAns == ans) {
					answer[i]++;
				}
				student[i].add(stuAns);
			}
		}
		
		List<int[]> answerTemp = new ArrayList<int[]>();
		for (int i = 0; i < 3; i++) {
			answerTemp.add(new int[] {answer[i],i});
		}
		
		Collections.sort(answerTemp, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[0]-o1[0];
			}
		});
		
		int size = 1;
		for(int i = 1; i < answerTemp.size();i++) {
			if(answerTemp.get(i-1)[0]==answerTemp.get(i)[0]) {
				size++;
			}
			else {
				break;
			}
		}
		
		answer = new int[size];
		
		for(int i = 0 ; i<size; i++) {
			answer[i] = answerTemp.get(i)[1]+1;
		}
		
		Arrays.sort(answer);

		// ����迭���� �ϳ��� �̾� �� ť���� �̾Ƽ� ���°Ͱ� �����Ͽ�
		// �´� ��ȣ�� ���� �迭�� �ø���.
		// ����迭�� ����Ʈ<��Ʈ[2]> �� ��ȯ�Ѵ�.
		// ���� ������ ������ �� �� ��ó���� ���� �迭�� �ְ� �ι������� ���ϸ� �ִ´�.

		return answer;
	}
}
