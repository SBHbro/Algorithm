package study_0907;

import java.util.PriorityQueue;

public class Solution_P_´õ¸Ê°Ô {

	public static void main(String[] args) {

		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int k = 7;

		System.out.println(solution(scoville, k));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			heap.add(scoville[i]);
		}
		
		while(heap.peek()<K) {
			heap.add(heap.poll() + (heap.poll()*2));
			answer++;
			if(heap.size()==1 && heap.peek()<K) {
				return -1;
			}
		}

		return answer;
	}
}
