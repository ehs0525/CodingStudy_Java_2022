package java_1025;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2589_º¸¹°¼¶ {

	static int N, M, max = 0;
	static char[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Land {
		Point p;
		int d;

		public Land(Point p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					bfs(new Land(new Point(i, j), 0));
				}
			}
		}

		System.out.println(max);
	}

	private static void bfs(Land start) {
		Queue<Land> q = new LinkedList<>();
		visited = new boolean[N][M];

		q.offer(start);
		visited[start.p.x][start.p.y] = true;

		while (!q.isEmpty()) {
			Land curr = q.poll();
			max = Integer.max(max, curr.d);

			for (int i = 0; i < 4; i++) {
				int nx = curr.p.x + dx[i];
				int ny = curr.p.y + dy[i];
				int nd = curr.d + 1;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] == 'W' || visited[nx][ny])
					continue;

				q.offer(new Land(new Point(nx, ny), nd));
				visited[nx][ny] = true;
			}
		}
	}

}
