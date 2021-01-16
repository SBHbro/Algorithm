package study_1203;


public class Solution_Go_3 {

	
	public static void main(String[] args) {
//		Dictionary fruits = new Dictionary(new String[] {"cherry", "pineapple", "melon", "strawberry", "raspberry"});
//		Dictionary fruits = new Dictionary(new String[] {"javascript", "java", "ruby", "php", "python", "coffeescript"});
		Dictionary fruits = new Dictionary(new String[] {"ajajava","java"});
		System.out.println(fruits.findMostSimilar("a"));
	}
	public static class Dictionary{
		String[] data;

		public Dictionary(String[] data) {
			super();
			this.data = data;
		}

		public String findMostSimilar(String input) {
			
			//data�� ���̸�ŭ ����
			//data�� ���ҿ� �Է����� ���� ��Ʈ���� ���絵�� �˻��Ѵ�.
			//���絵�� ���峷�� ��Ʈ���� �����Ѵ�.
			int answer = Integer.MAX_VALUE;
			int answerIndex = 0;
			for(int i = 0 ; i<this.data.length;i++) {
				
				int[][] map = new int[input.length()+1][this.data[i].length()+1];
				String first = this.data[i];
				
				for(int j=0;j<=first.length();j++) {
					map[0][j] = j;
				}
				
				for(int j = 0 ; j<=input.length();j++) {
					map[j][0] = j;
				}
				
				for(int a = 1 ; a<=input.length();a++) {
					for(int b= 1; b<=first.length();b++) {
						//������ ���ʴ밢���� 
						if(first.charAt(b-1)==input.charAt(a-1)) {
							map[a][b] = map[a-1][b-1];
						}
						//�ٸ��� ���� �밢�������� �� �� ���� ������ +1
						else {
							int temp = Math.min(map[a][b-1], map[a-1][b-1]);
							temp = Math.min(temp, map[a-1][b])+1;
							map[a][b] = temp;
						}
					}
				}
				
				if(answer>=map[input.length()][first.length()]) {
					answer = map[input.length()][first.length()];
					answerIndex = i;
				}
				
			}
			return this.data[answerIndex];
		}
		
	}
}
