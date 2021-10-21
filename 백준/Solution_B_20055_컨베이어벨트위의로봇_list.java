package study_1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_20055_컨베이어벨트위의로봇_list {

	static int N, K;
	static int answer = 1;
	static List<Integer> map= new ArrayList<>();
	static List<Boolean> isRobot= new ArrayList<>();

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int max = 2 * N;

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < max; i++) {
			map.add(Integer.parseInt(st.nextToken()));
			isRobot.add(false);
		}

		int count = 0;
		while (true) {
			
			// 돌리기
			map.add(0, map.get(map.size()-1));
			map.remove(map.size()-1);
			isRobot.add(0, isRobot.get(isRobot.size()-1));
			isRobot.remove(isRobot.size()-1);
			isRobot.set(N-1, false);
			
			// 로봇 이동
			for (int i = N; i > 1; i--) {
				// 이동할 수 있다면
				if (count == K)
					break;
				if (isRobot.get(i-1) && !isRobot.get(i) && 0 < map.get(i)) {
					map.set(i,map.get(i)-1);
					isRobot.set(i, true);
					isRobot.set(i-1, false);
					if (map.get(i) == 0)
						count++;
				}
			}
			isRobot.set(N-1, false);

			// 로봇 올리기
			if (map.get(0) > 0 && !isRobot.get(0)) {
				map.set(0, map.get(0)-1);
				isRobot.set(0,true);
				if (map.get(0) == 0)
					count++;
			}

			if (count >= K)
				break;

			answer++;
		}
		System.out.println(answer);

	}
}
