package java_0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_10836_¿©¿Õ¹ú {

	public static int M, N;
	public static int[][] hive, grow, grown;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		hive = new int[M][M];
		for (int i = 0; i < M; i++)
			Arrays.fill(hive[i], 1);

		grow = new int[N + 1][2 * M - 1];
		for (int i = 1; i <= N; i++) {
			int idx = 0;
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int cnt = Integer.parseInt(st.nextToken());
				while (cnt-- > 0) {
					grow[i][idx++] = j;
				}
			}
		}

		grown = new int[M][M];
		for (int i = 1; i <= N; i++) {
			setGrown(i);
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					hive[j][k] += grown[j][k];

					if (i == N) {
						sb.append(hive[j][k]).append(" ");
						if (k == M - 1) {
							sb.append("\n");
						}
					}
				}
			}
		}

		System.out.println(sb);
	}

	public static void setGrown(int day) {
		int idx = 0;
		for (int i = M - 1; i >= 0; i--) {
			grown[i][0] = grow[day][idx++];
		}
		for (int i = 1; i <= M - 1; i++) {
			grown[0][i] = grow[day][idx++];
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
				grown[i][j] = Integer.max(Integer.max(grown[i][j - 1], grown[i - 1][j - 1]), grown[i - 1][j]);
			}
		}
	}

}
