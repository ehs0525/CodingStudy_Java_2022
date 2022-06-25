package java_0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G2_16565_NÆ÷Ä¿ {

	public static final int MOD = 10007;

	public static int N, ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		for (int i = 1; i <= N / 4; i++)
			ans = (ans + (int) Math.pow(-1, i - 1) * nCr(13, i) * nCr(52 - 4 * i, N - 4 * i) % MOD + MOD) % MOD;

		System.out.println(ans);
	}

	public static int nCr(int n, int r) {
		int[][] comb = new int[53][53];

		comb[0][0] = 1;
		for (int i = 1; i <= 52; i++) {
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
			}
		}

		return comb[n][r];
	}

}
