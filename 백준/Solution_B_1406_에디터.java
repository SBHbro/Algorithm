package study_0208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Solution_B_1406_¿¡µðÅÍ {

	static int N;
	static List<Character> data = new LinkedList<Character>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = in.readLine();
		for (int i = 0; i < input.length(); i++) {
			data.add(input.charAt(i));
		}

		N = Integer.parseInt(in.readLine());

		ListIterator<Character> pointer = data.listIterator();
		while(pointer.hasNext()) {
			pointer.next();
		}
		
		while (0 < N--) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			char type = st.nextToken().charAt(0);

			switch (type) {
			case 'L':
				if(pointer.hasPrevious())
					pointer.previous();
				break;
			case 'D':
				if(pointer.hasNext())
					pointer.next();
				break;
			case 'B':
				if (pointer.hasPrevious()) {
					pointer.previous();
					pointer.remove();
				}
				break;
			case 'P':
				String temp = st.nextToken();
				pointer.add(temp.charAt(0));
				break;

			default:
				break;
			}
		}

		for (Character a : data) {
			out.write(a);
		}
		out.close();

	}

}
