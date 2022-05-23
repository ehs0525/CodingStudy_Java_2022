package java_0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_5582_공통부분문자열 {

	public static char[] s1, s2;
	public static int[][] dp;
	public static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		s1 = in.readLine().toCharArray();
		s2 = in.readLine().toCharArray();

		int len1 = s1.length;
		int len2 = s2.length;

		dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s1[i - 1] == s2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Integer.max(max, dp[i][j]);
				}
			}
		}

		System.out.println(max);
	}

}
