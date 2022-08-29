package java_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static String solution(String X, String Y) {
		String answer = "";

		long[] cntX = new long[10];
		long[] cntY = new long[10];

		for (int i = 0; i < Math.max(X.length(), Y.length()); i++) {
			if (i < X.length())
				cntX[X.charAt(i) - '0']++;
			if (i < Y.length())
				cntY[Y.charAt(i) - '0']++;
		}

		for (int i = 9; i >= 0; i--) {
			if (cntX[i] > 0 && cntY[i] > 0) {
				long min = Math.min(cntX[i], cntY[i]);
				for (int j = 0; j < min; j++) {
					answer += String.valueOf(i);
				}
			}
		}

		if (answer == "")
			return "-1";
		answer = String.valueOf(Long.parseLong(answer));

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//
//		String str1 = st.nextToken();
//		String str2 = st.nextToken();

		System.out.println(solution("100", "2345"));
		System.out.println(solution("100", "203045"));
		System.out.println(solution("100", "123450"));
		System.out.println(solution("12321", "42531"));
		System.out.println(solution("5525", "1255"));
	}

}
