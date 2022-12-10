package java_1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_G4_16472_∞Ì≥…¿Ã {

	static int N;
	static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		str = in.readLine();

		HashMap<Character, Integer> map = new HashMap<>();
		int s = 0, e = 0, max = 1;
		map.put(str.charAt(e), 1);

		while (++e < str.length()) {
			char tail = str.charAt(e);
			if (map.containsKey(tail)) {
				map.put(tail, map.get(tail) + 1);
			} else {
				map.put(tail, 1);
			}

			while (map.size() > N && s < e) {
				char head = str.charAt(s);
				if (map.get(head) > 1) {
					map.put(head, map.get(head) - 1);
				} else {
					map.remove(head);
				}
				s++;
			}

			max = Integer.max(max, e - s + 1);
		}
		
		System.out.println(max);
	}

}
