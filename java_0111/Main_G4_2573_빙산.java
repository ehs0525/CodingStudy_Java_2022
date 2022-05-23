package java_0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_2573_ºù»ê {

	public static int N, M, year = 0;
	public static int[][] iceberg, temp;
	public static boolean[][] visited;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iceberg = new int[N][M];
//		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				iceberg[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		copyIceberg();
		melt();

		boolean completelyMelted = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (iceberg[i][j] > 0) {
					completelyMelted = false;
				}
			}
		}
		if (!completelyMelted)
			System.out.println(year);
		else
			System.out.println(0);
	}

	public static void melt() {
		while (!separate()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int k = 0; k < 4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];

						if (ni >= 0 && ni < N && nj >= 0 && nj < M && temp[ni][nj] == 0) {
							if (iceberg[i][j] > 0) {
								iceberg[i][j]--;
							}
						}
					}
//					if(temp[i][j] > 0) {
//						for (int k = 0; k < 4; k++) {
//							int ni = i + dx[k];
//							int nj = j + dy[k];
//	
//							if (ni >= 0 && ni < N && nj >= 0 && nj < M && temp[ni][nj] == 0) {
//								if (iceberg[i][j] > 0) {
//									iceberg[i][j]--;
//								}
//							}
//						}
//					}
				}
			}
			copyIceberg();
			year++;
		}
	}

	public static boolean separate() {
		int chunk = 0;
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dfs(i, j)) {

					if (++chunk >= 2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean dfs(int x, int y) {
//		System.out.println("DFS!!");
		if (x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}

		if (!visited[x][y] && iceberg[x][y] > 0) {
			visited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				dfs(nx, ny);
			}
			return true;
		}
		return false;
	}

	public static void copyIceberg() {
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = iceberg[i][j];
			}
		}
	}

}
