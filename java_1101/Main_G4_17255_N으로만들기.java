package java_1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_G4_17255_N으로만들기 {

	static String N;
	static Set<String> pathSet = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = in.readLine();
		for (int i = 0; i < N.length(); i++) {
			String c = String.valueOf(N.charAt(i));
			dfs(i, i + 1, c);
		}

		System.out.println(pathSet.size());
	}

	private static void dfs(int s, int e, String path) {
		if (s == 0 && e == N.length()) {
			pathSet.add(path);
			return;
		}

		if (s - 1 >= 0)
			dfs(s - 1, e, path + " " + N.substring(s - 1, e));
		if (e + 1 <= N.length())
			dfs(s, e + 1, path + " " + N.substring(s, e + 1));
	}

}
