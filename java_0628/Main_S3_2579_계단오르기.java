package java_0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_2579_��ܿ����� {

	public static int N;
	public static int[] score;
	public static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		score = new int[N + 1];

		for (int i = 1; i <= N; i++)
			score[i] = Integer.parseInt(in.readLine());

//		dp[i][0] : (i - 1)��° ����� ���� �ʰ� i��° ��ܿ��� ��� �ְ� ����
//		dp[i][1] : (i - 1)��° ����� ��� i��° ��ܿ��� ��� �ְ� ����
		dp = new int[N + 1][2];
		dp[1][0] = score[1];
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Integer.max(dp[i - 2][0] + score[i], dp[i - 2][1] + score[i]);
			dp[i][1] = dp[i - 1][0] + score[i];
		}

		System.out.println(Integer.max(dp[N][0], dp[N][1]));
	}

}
