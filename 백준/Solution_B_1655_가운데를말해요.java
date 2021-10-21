package study_0308;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_B_1655_가운데를말해요 {

	//우선순위큐를 두개 만든다
	//하나는 맥스힙 하나는 민힙
	//맨 처음 값은 그 값을 중간값으로 하고 맥스힙에 넣는다
	//다음부터 들어오는 값은 중간값과 비교하여 왼쪽에 넣을지 오른쪽에 넣을지 선택한다
	//왼쪽과 오른쪽의 크기 차이가 2 이상이 되면 안된다.
	//크기 차이가 2 이상이 됐을 경우 크기가 더 큰쪽의 값을 빼서 반대쪽에 넣는다.
	//홀수일때의 중간값은 크기가 더 큰쪽의 맨 윗값이다.
	//짝수일때의 중간값은 둘중 더 작은것이다.
	
	static int N;
	static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> right = new PriorityQueue<>();
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(in.readLine());
		
		answer = Integer.parseInt(in.readLine());
		left.add(answer);
		
		out.write(answer+"\n");
		
		for(int i = 0 ; i<N-1;i++) {
			
			int input = Integer.parseInt(in.readLine());
			if(input<answer) {
				left.add(input);
			}
			else {
				right.add(input);
			}
			
				
			if(Math.abs(left.size()-right.size())==2) {
				if(left.size()<right.size()) {
					left.add(right.poll());
				}
				else {
					right.add(left.poll());
				}
			}
			
			if(left.size()<right.size()) {
				answer = right.peek();
			}
			else if(right.size()<left.size()) {
				answer = left.peek();
			}
			else {
				answer = Math.min(left.peek(), right.peek());
			}
			
			out.write(answer+"\n");
			
		}

		out.close();
		
	}
}
