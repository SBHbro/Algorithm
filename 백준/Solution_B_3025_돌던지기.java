package study_0203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_B_3025_�������� {

	static char[][] map;
	static int R, C;
	static int N;

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		//���� ��ġ�� ����Ѵ�.
		//C���� ����Ʈ�� ����� �ű⿡ ���� �ִ´�(������ �������� ����).
		//����߸� ��ġ�� �ް� ���� �ε������� �����̿� �ε������� �ε����°� ������ Ȯ���Ѵ�.
		//Ȯ���� ����� ���� �����̸� ���� ����Ʈ�� �������� ��ġ�� �ִ´�.(��������)

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			drop(Integer.parseInt(in.readLine()) - 1, 0);
		}
		print();

		out.close();

	}

	private static void print() throws IOException {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				out.write(map[i][j] + " ");
			}
			out.write("\n");
		}
		out.write("\n");
		out.write("\n");
	}

	private static void drop(int x, int y) throws IOException {

		for (int i = y; i < R; i++) {
			if (i == R - 1) {
				map[i][x] = 'O';
				return;
			}
			if (map[i + 1][x] == 'X') {
				map[i][x] = 'O';
				return;
			}
			if (map[i + 1][x] == 'O') {
				if (isSafe(i, x - 1) && isSafe(i + 1, x - 1) && map[i][x - 1] == '.' && map[i + 1][x - 1] == '.') {
					drop(x - 1, i);
					return;
				}
				if (isSafe(i, x + 1) && isSafe(i + 1, x + 1) && map[i][x + 1] == '.' && map[i + 1][x + 1] == '.') {
					drop(x + 1, i);
					return;
				}
				map[i][x] = 'O';
				return;
			}

		}

	}

	private static boolean isSafe(int y, int x) {
		// TODO Auto-generated method stub
		return 0 <= y && y < R && 0 <= x && x < C;
	}

}
