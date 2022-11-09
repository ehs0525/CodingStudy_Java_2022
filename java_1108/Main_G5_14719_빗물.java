package java_1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14719_ºø¹° {

	static int H, W;
	static boolean[][] blocks;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		blocks = new boolean[H + 1][W];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < W; i++) {
			int height = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= height; j++) {
				blocks[j][i] = true;
			}
		}

		int total = 0;
		for (int i = 1; i <= H; i++) {
			int idx = 0;
			while (idx < W) {
				if (blocks[i][idx]) {
					int leftWall = idx;
					while (++idx < W && !blocks[i][idx])
						;
					if (idx < W)
						total += idx - leftWall - 1;
				} else {
					idx++;
				}
			}
		}

		System.out.println(total);
	}

}
