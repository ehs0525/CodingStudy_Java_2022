package java_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_G4_2631_줄세우기 {

	static int N;
	static int[] line, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		line = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(in.readLine());
		}

		for (int i = 0; i < N; i++) {
			dp[i] = 1;

			for (int j = i; j >= 0; j--) {
				if (line[j] < line[i]) {
					dp[i] = Integer.max(dp[j] + 1, dp[i]);
				}
			}
		}

		System.out.println(N - Arrays.stream(dp).max().getAsInt());
	}

}
