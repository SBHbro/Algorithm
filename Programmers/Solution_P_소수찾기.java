package study_1229;

import java.util.*;

public class Solution_P_소수찾기 {
	public static void main(String[] args) {
		System.out.println(Solution("011"));
	}
	
	public static int Solution(String numbers) {
		int[] numbersConv = new int[numbers.length()];
		for (int i = 0; i < numbersConv.length; i++) {
			numbersConv[i] = numbers.charAt(i) - '0';
		}
		Set<Integer> answer = new HashSet<Integer>();
		boolean[] isVisit = new boolean[numbersConv.length];
		int maxSize = 10000000;
		int[] primes = new int[maxSize];
		for (int i = 2; i < maxSize; i++) {
			primes[i] = i;
		}
		MakePrimeNumber(primes, maxSize);
		dfs("", numbersConv, answer, primes, isVisit);
		return answer.size();
	}

	static void MakePrimeNumber(int[] primes, int maxSize) {

		for (int i = 2; i < maxSize; i++) {
			if (primes[i] == 0)
				continue;
			for (int j = i * 2; j < maxSize; j += i) {
				primes[j] = 0;
			}
		}
	}

	static void dfs(String now, int[] numbers, Set<Integer> answer, int[] primes, boolean[] isVisit) {
		if(!now.equals("")) {
			
			int temp = Integer.parseInt(now);
			if (primes[temp] != 0) {
				answer.add(temp);
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				dfs(now + numbers[i] + "", numbers, answer, primes, isVisit);
				isVisit[i] = false;
			}

		}

	}
}
