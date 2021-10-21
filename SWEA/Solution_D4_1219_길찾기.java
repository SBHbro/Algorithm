import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1219_湲몄갼湲?{

	static int T; // ??ㅽ몄??댁?
	static int N; // 媛?? 媛?
	static int[] data;// 媛??蹂?
	static int[] data2;// 媛??蹂?
	static Queue<int[]> que;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			T = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			data = new int[100];
			data2 = new int[100];
			que = new LinkedList<int[]>();
			ans = 0;

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (data[start] != 0) {// ?대?媛???ㅼ댁 ??寃쎌?
					data2[start] = end;
				} else {
					data[start] = end;
				}
			}

			if (data[0] != 0) {
				que.add(new int[] { 0, data[0] });
				if (data2[0] != 0) {
					que.add(new int[] { 0, data2[0] });
				}

				while (!que.isEmpty() && ans == 0) {
					int[] temp = que.poll();
					int start = temp[0];
					int end = temp[1];
//					System.out.println(Arrays.toString(temp));

					// data[end] ? 媛???? 寃쎌곗留
					if (data[end] != 0) {
						que.add(new int[] { end, data[end] });
						// data2[end] ? 媛???? 寃쎌곗留
						if (data2[end] != 0) {
							que.add(new int[] { end, data2[end] });
						}
					}

					if (data[end] == 99) {
						ans = 1;
						break;
					}
					if (data2[end] == 99) {
						ans = 1;
						break;
					}

				}

				System.out.println("#" + T + " " + ans);

			} else {
				System.out.println("#" + T + " " + 0);
			}

		}

	}
}
