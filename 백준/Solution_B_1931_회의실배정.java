package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_B_1931_회의실배정 {

	static int N;
	static List<int[]> input = new ArrayList<int[]>();
	static List<int[]> data = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());

		// end 기준 정렬
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			input.add(new int[] { start, end });
		}

		Collections.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]!=o2[1])
					return o1[1]-o2[1];
				else
					return o1[0]-o2[0];
			}
		});

		
		data.add(input.get(0));
		// end 값이 같을 때 -> 시작값이 큰것으로 변경
		// end 값이 다를 때 -> 시작값이 이전 end값보다 클때만 등록
		for (int i = 1; i < input.size(); i++) {
			int p = data.size() - 1;
			int[] temp = data.get(p);
			if (input.get(i)[1] == temp[1]) {
				if(input.get(i)[0] == temp[1])
					data.add(new int[] { input.get(i)[0], input.get(i)[1] });
				temp[0] = Math.max(temp[0], input.get(i)[0]);
			} else {
				if (temp[1] <= input.get(i)[0]) {
					data.add(new int[] { input.get(i)[0], input.get(i)[1] });
				}
			}
		}

		System.out.println(data.size());

	}

}
