package study_0127;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_H_LuckBalance {

	//100개의 시험이있따
	//k만큼 질 수 있다.
	//10000까지의 럭이있다.
	//중요한것과 중요하지 않은 것이 있다.
	
	//6개의 시험, 3번 질수있음 - 지는건 중요한 시험에서만 
	//0부터 5까지 가장높은 점수 하나골라서 진다.
	//인트형 배열 세개 만듬
	//값이 들어오면 1번과 비교해서 크면 넣고 안크면 2번으로 넘어가고 비교해서 크면 넣고 3번
	//넣은것들의 값은 0 으로 변경
	//첨부터 끝까지 다 더함
	//지면 + 이기면 -데 진지 이긴지 모름
	//0인애들은 더하고 1인애들은 뺀다.
	//마지막에 3개배열합*2를 더해주면 답.
	
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
//		int[][] a = {{5,1},{2,1},{1,1},{8,1},{10,0},{5,0}};
//		System.out.println(luckBalance(3, a));
		
	}
	
	static int luckBalance(int k, int[][] contests) {
		int answer = 0;
		
		List<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0 ; i<contests.length;i++) {
//			System.out.println("?");
			if(contests[i][1] == 1) {
				for(int j = 0 ; j<k;j++) {
					if(temp.size()<j+1) {
						temp.add(j,contests[i][0]);
						break;
					}
					else {
						if(temp.get(j)<contests[i][0]) {
							temp.add(j,contests[i][0]);
							if(k<temp.size())
								temp.remove(temp.size()-1);
							break;
						}
					}
				}
				answer-=contests[i][0];
			}
			
			else {
				answer+=contests[i][0];
			}
		}
		
		System.out.println(temp);
		if(!temp.isEmpty()) {
			int value =0;
			
			for(int i = 0;i<temp.size();i++) {
				value+=temp.get(i);
			}
			answer+= value*2;
		}
		
		
		return answer;
		
    }

	
}
