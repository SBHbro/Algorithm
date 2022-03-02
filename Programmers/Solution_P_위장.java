package study_0302;

import java.util.*;

public class Solution_P_위장 {
	public int solution(String[][] clothes) {
		int answer = 1;

		Map<String, Integer> data = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			String clothesName = clothes[i][1];
			if (data.containsKey(clothesName)) {
				data.put(clothesName, data.get(clothesName) + 1);
			} else {
				data.put(clothesName, 1);
			}
		}

		int size = data.size();

		int[] datas = new int[size];

		Iterator<String> keys = data.keySet().iterator();
		int index = 0;

		while (keys.hasNext()) {
			String key = keys.next();
			datas[index++] = data.get(key);
		}

		if (size == 1)
			answer = datas[0];
		else {
			for (int i = 0; i < size; i++) {
				answer *= datas[i] + 1;
			}
			answer -= 1;
		}

		return answer;
	}
}
