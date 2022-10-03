package java_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_15991_123더하기6 {

	static final int MOD = 1000000009;
	static int T, n;
	static int[] ns;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());
		ns = new int[T];
		int max = 0;
		for (int i = 0; i < T; i++) {
			ns[i] = Integer.parseInt(in.readLine());
			max = Integer.max(max, ns[i]);
		}

		dp = new long[max + 1][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 0;
		dp[3][1] = 2;

		for (int i = 4; i <= max; i++) {
			for (int j = 1; j <= 3; j++) { // 1 ~ 3을 추가하는 경우
				// 짝수 개수에 추가할 때
				dp[i][1] += dp[i - j][0];

				// 홀수 개수에 추가할 때
				int wing = i - j - j;
				if (wing == 0)
					dp[i][0]++;
				else if (wing > 0)
					dp[i][0] += dp[wing][0];

			}
			dp[i][0] %= MOD;
			dp[i][1] %= MOD;
		}

		for (int i = 0; i < T; i++)
			System.out.println((dp[ns[i]][0] + dp[ns[i]][1]) % MOD);
	}

}
