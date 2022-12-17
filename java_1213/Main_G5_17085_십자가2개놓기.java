package java_1213;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17085_십자가2개놓기 {

	static int N, M;
	static char[][] grid;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			grid[i] = in.readLine().toCharArray();
		}

		int max = 0;
		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < M; j1++) {
				if (grid[i1][j1] == '#') {
					int s1 = getSize(i1, j1);
//					placeCross(i1, j1, s1, '*');
					placeCross(i1, j1, s1, true);
					for (int i2 = 0; i2 < N; i2++) {
						for (int j2 = 0; j2 < M; j2++) {
							if (grid[i2][j2] == '#') {
								int s2 = getSize(i2, j2);
								max = Integer.max(max, (4 * s1 + 1) * (4 * s2 + 1));
							}
						}
					}
//					placeCross(i1, j1, s1, '#');
					placeCross(i1, j1, s1, false);
				}
			}
		}
		
		System.out.println(max);
	}

//	private static void placeCross(int x, int y, int size, char c) {
//		grid[x][y] = c;
//		for (int i = 1; i <= size; i++) {
//			for (int j = 0; j < 4; j++) {
//				int nx = x + dx[j] * i;
//				int ny = y + dy[j] * i;
//
//				grid[nx][ny] = c;
//			}
//		}
//	}
	private static void placeCross(int x, int y, int size, boolean b) {
		visited[x][y] = b;
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j] * i;
				int ny = y + dy[j] * i;
				
				visited[nx][ny] = b;
			}
		}
	}

	private static int getSize(int x, int y) {
		for (int i = 0;; i++) {
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j] * i;
				int ny = y + dy[j] * i;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || grid[nx][ny] != '#' || visited[nx][ny])
					return i - 1;
			}
		}
	}

}
