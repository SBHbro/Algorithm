package study_1025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_P_디스크컨트롤러 {

	public static void main(String[] args) {
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//		int[][] jobs = {{0, 5}, {7, 3}, {8, 1}};
		int[][] jobs = { { 0, 1000 }, { 1, 1000 } };
		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {
		int answer = 0;

		Arrays.sort(jobs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});

		// 우선순위큐에 모두넣는다.
		PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.endTime - o2.endTime;
			}
		});

		int now = jobs[0][0];
		int index = 1;
		pq.add(new Job(jobs[0][0], now + jobs[0][1], jobs[0][1]));

		Queue<Job> que = new LinkedList<Job>();

		while (!pq.isEmpty()) {
			// 작업을 꺼내고 이번 작업이 끝나는 시간을 계산한다.
			Job temp = pq.poll();
			now += temp.jobTime;
			answer += now - temp.startTime;
			// 이미 큐에있던애들을 꺼내서 endTime을 다시 계산해서 넣는다.
			while (!pq.isEmpty()) {
				que.add(pq.poll());
			}
			while (!que.isEmpty()) {
				Job tp = que.poll();
				tp.endTime = now + tp.jobTime;
				pq.add(tp);
			}

			// 끝나는 시간까지의 작업들을 끝나는시간이 작은 순서대로 pq에 넣는다.
			while (index < jobs.length && jobs[index][0] < now) {
				pq.add(new Job(jobs[index][0], now + jobs[index][1], jobs[index][1]));
				index++;
			}
			
			// 현재 큐에 작업이 없을경우
			if (index < jobs.length && pq.isEmpty()) {
				pq.add(new Job(jobs[index][0], jobs[index][0] + jobs[index][1], jobs[index][1]));
				now = jobs[index][0];
				index++;
			}

		}

		return answer / jobs.length;
	}

	public static class Job {
		int startTime;
		int endTime;
		int jobTime;

		public Job(int startTime, int endTime, int jobTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
			this.jobTime = jobTime;
		}
	}
}
