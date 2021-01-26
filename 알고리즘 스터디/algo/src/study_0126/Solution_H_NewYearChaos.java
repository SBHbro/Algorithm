package study_0126;

public class Solution_H_NewYearChaos {

	public static void main(String[] args) {
		minimumBribes(new int[] {2,1,5,3,4});
		minimumBribes(new int[] {2,5,1,3,4});
	}

	static void minimumBribes(int[] q) {
		int answer = 0;
		for(int i = q.length-1; i>0;i--) {
			
			//while ���� �����ִ¾ְ� �־�ߵǴ� ���̾ƴѰ��
			//�־�ߵǴ� �ָ� ���������� �����ΰ���
			//������ �־�ߵǴ� ������ ������.
			if(q[i]!=i+1) {
				int temp = i;
				while(q[temp]!=i+1) {
					temp--;
				}
				if(2<i-temp) {
					System.out.println("Too chaotic");
					return;
				}
				
				for(int j = temp; j<i;j++) {
					swap(q,j,j+1);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

	private static void swap(int[] q, int j, int i) {
		int temp = q[i];
		q[i] = q[j];
		q[j] = temp;
	}
	
}