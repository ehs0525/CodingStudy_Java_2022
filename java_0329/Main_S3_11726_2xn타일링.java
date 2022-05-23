package java_0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_11726_2xnÅ¸ÀÏ¸µ {

	public static int n;
	public static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		dp = new int[n + 1];

		dp[1] = 1;
		if (n > 1)
			dp[2] = 2;
		if (n > 2) {
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
			}
		}

		System.out.println(dp[n]);
	}

}
