package java_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_12865_Æò¹üÇÑ¹è³¶ {

	public static int N, K;
	public static int[][] dp;
	public static Item[] items;

	public static class Item {
		int W, V;

		public Item(int W, int V) {
			this.W = W;
			this.V = V;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][K + 1];
		items = new Item[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			items[i] = new Item(W, V);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j < items[i].W) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i].W] + items[i].V);
				}
			}
		}

		System.out.println(dp[N][K]);

	}

}
