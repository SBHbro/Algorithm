package study_1019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_P_모의고사 {

	public static void main(String[] args) {
//		int[] answer = {1,2,3,4,5};
		int[] answer = {1,3,2,4,2};
		System.out.println(Arrays.toString(solution(answer)));
	}

	public static int[] solution(int[] answers) {
		int[] answer = new int[3];

		// 1번,2번,3번의 큐를 만든다.
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

		// 정답배열에서 하나를 뽑아 각 큐에서 뽑아서 나온것과 대조하여
		// 맞는 번호의 정답 배열을 올린다.
		// 정답배열을 리스트<인트[2]> 로 변환한다.
		// 맞은 개수로 정렬을 한 후 맨처음걸 정답 배열에 넣고 두번쨰부터 비교하며 넣는다.

		return answer;
	}
}
