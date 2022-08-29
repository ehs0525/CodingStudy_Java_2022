package java_0719;

import java.util.HashMap;
import java.util.Map.Entry;

public class Main2 {

	public static int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			map1.put(want[i], number[i]);
		}

		int s = 0, e = 9;
		for (int i = s; i <= e; i++) {
			if (map2.containsKey(discount[i])) {
				map2.replace(discount[i], map2.get(discount[i]) + 1);
				continue;
			}

			map2.put(discount[i], 1);
		}

		while (e < discount.length) {
			boolean match = true;
			for (Entry<String, Integer> el : map2.entrySet()) {
				String key = el.getKey();
				if (!map1.containsKey(key) || el.getValue() != map1.get(key)) {
					match = false;
					break;
				}
			}

			if (match) {
				answer++;
			} else {
				if (e == discount.length - 1)
					break;

				if (map2.get(discount[s]) > 1)
					map2.replace(discount[s], map2.get(discount[s]) - 1);
				else
					map2.remove(discount[s]);

				if (map2.containsKey(discount[e + 1]))
					map2.replace(discount[e + 1], map2.get(discount[e + 1]) + 1);
				else
					map2.put(discount[e + 1], 1);
			}
			s++;
			e++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "banana", "apple", "rice", "pork", "pot" },
				new int[] { 3, 2, 2, 2, 1 }, new String[] { "chicken", "apple", "apple", "banana", "rice", "apple",
						"pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" }));

		System.out.println(solution(new String[] { "apple" }, new int[] { 10 }, new String[] { "banana", "banana",
				"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana" }));
	}
}
