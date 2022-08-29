package java_0809;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_16933_벽부수고이동하기3 {

	public static int N, M, K;
	public static int[][] map;
	public static boolean[][][] visited;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static class Coords {
		Point p;
		int passed, broken;
		boolean isDay;

		public Coords(Point p, int passed, int broken, boolean isDay) {
			this.p = p;
			this.passed = passed;
			this.broken = broken;
			this.isDay = isDay;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line[j - 1] - '0';
			}
		}

		System.out.println(bfs(new Coords(new Point(1, 1), 1, 0, true)));
	}

	public static int bfs(Coords src) {
		Queue<Coords> q = new LinkedList<>();

		q.offer(src);
		visited[src.p.x][src.p.y][src.broken] = true;

		while (!q.isEmpty()) {
			Coords curr = q.poll();

			if (curr.p.x == N && curr.p.y == M)
				return curr.passed;

			for (int i = 0; i < 4; i++) {
				Point np = new Point(curr.p.x + dx[i], curr.p.y + dy[i]);
				int npassed = curr.passed + 1;
				boolean nisDay = !curr.isDay;

				if (np.x < 1 || np.x > N || np.y < 1 || np.y > M)
					continue;

				// 벽이 아닌 경우
				if (map[np.x][np.y] == 0 && !visited[np.x][np.y][curr.broken]) {
					q.offer(new Coords(np, npassed, curr.broken, nisDay));
					visited[np.x][np.y][curr.broken] = true;
				}

				if (map[np.x][np.y] == 1 && curr.broken < K && !visited[np.x][np.y][curr.broken + 1]) {
					// 벽이고 낮인 경우
					if (curr.isDay) {
						q.offer(new Coords(np, npassed, curr.broken + 1, nisDay));
						visited[np.x][np.y][curr.broken + 1] = true;
					} else { // 벽이고 밤인 경우(낮이 된 후 부숨)
						q.offer(new Coords(curr.p, npassed, curr.broken, nisDay));
//						visited[np.x][np.y][curr.broken] = true;
					}

				}

			}
		}

		return -1;
	}

}
