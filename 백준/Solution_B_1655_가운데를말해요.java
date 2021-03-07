package study_0308;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_B_1655_��������ؿ� {

	//�켱����ť�� �ΰ� �����
	//�ϳ��� �ƽ��� �ϳ��� ����
	//�� ó�� ���� �� ���� �߰������� �ϰ� �ƽ����� �ִ´�
	//�������� ������ ���� �߰����� ���Ͽ� ���ʿ� ������ �����ʿ� ������ �����Ѵ�
	//���ʰ� �������� ũ�� ���̰� 2 �̻��� �Ǹ� �ȵȴ�.
	//ũ�� ���̰� 2 �̻��� ���� ��� ũ�Ⱑ �� ū���� ���� ���� �ݴ��ʿ� �ִ´�.
	//Ȧ���϶��� �߰����� ũ�Ⱑ �� ū���� �� �����̴�.
	//¦���϶��� �߰����� ���� �� �������̴�.
	
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
