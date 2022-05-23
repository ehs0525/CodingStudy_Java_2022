package java_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S4_17626_FourSquares {

	public static int n;
	public static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}

		System.out.println(dp[n]);
	}

}
