package java_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_P5_23291_어항정리 {

	public static int N, K, cnt = 0;
	public static int[][] fishbowl;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		fishbowl = new int[N][N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			fishbowl[N - 1][i] = Integer.parseInt(st.nextToken());

		while (true) {
			if (getDiff() <= K) {
				System.out.println(cnt);
				break;
			}

			putFish();

			pileUp();

			adjustFish();
			putInARow();

			foldTwice();

			adjustFish();
			putInARow();

			cnt++;
		}
	}

	public static int getDiff() {
		int max = 0, min = 10001;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (fishbowl[i][j] == 0)
					continue;

				max = Integer.max(max, fishbowl[i][j]);
				min = Integer.min(min, fishbowl[i][j]);
			}
		}

		return max - min;
	}

	public static void foldTwice() {
		int idx = 0, h = 1, w = N / 2;

		for (int i = 0; i < 2; i++) {
			for (int j = N - 1; j > N - 1 - h; j--) {
				for (int k = idx; k < idx + w; k++) {
					int nx = j - (2 * (j - (N - h)) + 1);
					int ny = k + (2 * ((idx + w - 1) - k) + 1);

					fishbowl[nx][ny] = fishbowl[j][k];
					fishbowl[j][k] = 0;
				}
			}

			idx += w;
			w /= 2;
			h *= 2;
		}

	}

	public static void putInARow() {
		ArrayList<Integer> fishbowls = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (fishbowl[j][i] == 0)
					break;

				fishbowls.add(fishbowl[j][i]);
				fishbowl[j][i] = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			fishbowl[N - 1][i] = fishbowls.get(i);
		}

	}

	public static void adjustFish() {
		int[][] send = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (fishbowl[i][j] == 0)
					continue;

				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (fishbowl[nx][ny] == 0)
						continue;
					if (visited[nx][ny])
						continue;

					int d = Math.abs(fishbowl[i][j] - fishbowl[nx][ny]) / 5;
					if (d > 0) {
						if (fishbowl[i][j] > fishbowl[nx][ny]) {
							send[i][j] -= d;
							send[nx][ny] += d;
						} else {
							send[nx][ny] -= d;
							send[i][j] += d;
						}
					}
				}
				visited[i][j] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (fishbowl[i][j] == 0)
					continue;
				fishbowl[i][j] += send[i][j];
			}
		}

	}

	public static void pileUp() {
		int idx = 0, h = 1, w = 1;

		while (true) {
			if (idx + w + h - 1 >= N)
				break;

			for (int i = idx; i < idx + w; i++) {
				for (int j = N - 1; j > N - 1 - h; j--) {
					int nx = N - 1 - (idx + w - i);
					int ny = idx + w + (N - 1 - j);

					fishbowl[nx][ny] = fishbowl[j][i];
					fishbowl[j][i] = 0;
				}
			}

			int temp = w;
			idx += temp;
			w = h;
			h = temp + 1;
		}

	}

	public static void putFish() {
		ArrayList<Integer> least = new ArrayList<>();

		int min = 10001;
		for (int i = 0; i < N; i++) {
			if (fishbowl[N - 1][i] < min) {
				min = fishbowl[N - 1][i];

				least.clear();
				least.add(i);
			} else if (fishbowl[N - 1][i] == min) {
				least.add(i);
			}
		}

		for (int idx : least)
			fishbowl[N - 1][idx]++;
	}

}
