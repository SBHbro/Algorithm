package study_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_B_1197_�ּҽ��д�Ʈ�� {
	//ũ�罺Į �˰������� Ǯ��
	//�������� �������� ����ġ�� ��� �Է¹޴´�.
	//[��������].����[0,1,2]
	
	//������ ���� �ƴϱٵ� ������ ������ ������ �����˰����� ����鼭 �� ũ�罺Į��Ǯ��
	//���Ͽ����ε��ؾ���
	//�迭[�����ǰ���]
	//priority que�� ����ؼ� ������ ���̰� ª�� ������ �Է¹޴´�.
	//���� ª������ ���� ���� ��Ʈ�� ������ �ִ��� Ȯ���ϰ� 
	//�ٸ� ��Ʈ�� ���� ��� ���Ͽ� ������ �Ѵ�.
	//n-1���� ������ ���õɶ����� �ݺ�
	
	static int[] unionArray;
	static int V,E;
	static PriorityQueue<int[]> pq;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		unionArray = new int[V+1];
		for(int i = 1; i<V+1;i++) {
			unionArray[i] = i;
		}
		
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		for(int i = 0 ;i<E;i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new int[] {start,end,weight});
		}
		
		int count = 0;
		while(count<V-1) {
			int[] temp = pq.poll();
			if(find(temp[0])==find(temp[1])) {
				continue;
			}
			else {
				union(temp[0],temp[1]);
				answer+=temp[2];
				count++;
			}
		}
		
		System.out.println(answer);
		
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		unionArray[b] = a;
	}

	private static int find(int input) {
		
		if(unionArray[input] == input) {
			return input;
		}
		
		return unionArray[input]=find(unionArray[input]);
	}
}
