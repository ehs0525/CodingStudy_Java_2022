package java_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_G5_1662_æ–√‡ {

	public static String S;
	public static int[] pair;
	public static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		S = in.readLine();
		pair = new int[S.length()];

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(')
				s.push(i);
			else if (c == ')')
				pair[s.pop()] = i;
		}

		System.out.println(getLength(0, S.length()));
	}

	public static int getLength(int start, int end) {
		int len = 0;

		for (int i = start; i < end; i++) {
			if (S.charAt(i) == '(') {
				len += (S.charAt(i - 1) - '0') * getLength(i + 1, pair[i]) - 1;
				i = pair[i];
			} else {
				len++;
			}
		}

		return len;
	}

}
