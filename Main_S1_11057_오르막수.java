import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S1_11057_오르막수 {

	static final int MOD = 10007;

	static int N;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		dp = new int[10][N + 1]; // dp[i][j] : i로 끝나는 j자리수 오르막 수의 개수

		for (int i = 0; i <= 9; i++) {
			dp[i][1] = 1;
		}
		Arrays.fill(dp[0], 1); // 0으로 끝나는 가지 수는 항상 1개

		int cnt = dp[0][N];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				dp[j][i] = (dp[j - 1][i] + dp[j][i - 1]) % MOD;
				if (i == N)
					cnt = (cnt + dp[j][i]) % MOD;
			}
		}
		
		System.out.println(cnt);
	}

}
