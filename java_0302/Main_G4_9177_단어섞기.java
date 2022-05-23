package java_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_G4_9177_´Ü¾î¼¯±â {

	public static int n;
	public static boolean canForm;
	public static String[] words = new String[3];
	public static HashSet<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			canForm = false;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				words[j] = st.nextToken();
			}

			mixWords(0, 0, 0);
			sb.append("Data set ").append(i).append(": ").append(canForm ? "yes" : "no").append("\n");
		}

		System.out.println(sb);
	}

	public static void mixWords(int idx1, int idx2, int idx3) {
		if (idx1 + idx2 == words[2].length()) {
			canForm = true;
			return;
		}

		if (idx1 < words[0].length() && words[0].charAt(idx1) == words[2].charAt(idx3)) {
			mixWords(idx1 + 1, idx2, idx3 + 1);
		}
		if (idx2 < words[1].length() && words[1].charAt(idx2) == words[2].charAt(idx3)) {
			mixWords(idx1, idx2 + 1, idx3 + 1);
		}

	}

}
