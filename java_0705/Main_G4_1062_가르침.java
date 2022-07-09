package java_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1062_°¡¸£Ä§ {

	public static int K, N, max = 0;
	public static String[] words;
	public static boolean[] isSelected = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];

		for (int i = 0; i < N; i++)
			words[i] = in.readLine();

		teach('a', 0);
		System.out.println(max);
	}

	public static void teach(char letter, int index) {
		if (index == K) {
			updateMax();
			return;
		}

		for (char ch = letter; ch <= 'z'; ch++) {
			if (!isSelected[ch - 'a']) {
				isSelected[ch - 'a'] = true;
				teach(ch, index + 1);
				isSelected[ch - 'a'] = false;
			}
		}
	}

	public static void updateMax() {
		int canRead = 0;

		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char ch = words[i].charAt(j);

				if (!isSelected[ch - 'a'])
					continue outer;
			}
			canRead++;
		}

		max = Integer.max(max, canRead);
	}

}
