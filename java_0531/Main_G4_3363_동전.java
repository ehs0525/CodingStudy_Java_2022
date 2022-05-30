package java_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_3363_µ¿Àü {

	public static int[] coin = new int[13];
	public static int[] left = new int[4];
	public static int[] right = new int[4];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			for (int j = 0; j < 4; j++)
				left[j] = Integer.parseInt(st.nextToken());
			char ineq = st.nextToken().charAt(0);
			for (int j = 0; j < 4; j++)
				right[j] = Integer.parseInt(st.nextToken());

			if (ineq == '>') {
				for (int j = 0; j < 4; j++) {
					coin[left[j]]++;
					coin[right[j]]--;
				}
			} else if (ineq == '<') {
				for (int j = 0; j < 4; j++) {
					coin[left[j]]--;
					coin[right[j]]++;
				}
			}
		}

		findImitation();
		System.out.println(sb);
	}

	public static void findImitation() {
		int max = 0, cnt = 0, idx = 0;

		for (int i = 1; i <= 12; i++) {
			if (max < Math.abs(coin[i])) {
				max = Math.abs(coin[i]);
				cnt = 1;
				idx = i;
			} else if (max == Math.abs(coin[i])) {
				cnt++;
			}
		}

		if (cnt == 1) {
			sb.append(idx);
			if (coin[idx] > 0) {
				sb.append("+");
			} else {
				sb.append("-");
			}
		} else {
			if (max == 0) {
				sb.append("impossible");
			} else {
				sb.append("indefinite");
			}
		}
	}

}
