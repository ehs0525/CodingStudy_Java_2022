package java_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_9084_µ¿Àü {

	public static int T, N, M;
	public static int[] coin, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(in.readLine());

			coin = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}

			M = Integer.parseInt(in.readLine());
			dp = new int[M+1];

			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}

			System.out.println(dp[M]);
		}

	}

}
