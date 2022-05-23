package java_0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_17609_È¸¹® {

	public static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String str = in.readLine();
			System.out.println(determineString(str, 0, str.length() - 1, 0));
		}
	}

	public static int determineString(String str, int s, int e, int cnt) {
		if (cnt >= 2)
			return 2;

		while (s <= e) {
			if (str.charAt(s) != str.charAt(e))
				return Integer.min(determineString(str, s + 1, e, cnt + 1), determineString(str, s, e - 1, cnt + 1));
			s++;
			e--;
		}

		return cnt;
	}

}
