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
			
			//data의 길이만큼 진행
			//data의 원소와 입력으로 들어온 스트링의 유사도를 검사한다.
			//유사도가 가장낮은 스트링을 리턴한다.
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
						//같으면 왼쪽대각선위 
						if(first.charAt(b-1)==input.charAt(a-1)) {
							map[a][b] = map[a-1][b-1];
						}
						//다르면 왼쪽 대각선왼쪽위 위 중 가장 작은값 +1
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
