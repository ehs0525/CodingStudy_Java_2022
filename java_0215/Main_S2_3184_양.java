package java_0215;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_3184_¾ç {

	public static int R, C, sheep = 0, wolf = 0;
	public static char[][] yard;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		yard = new char[R][C];
		for (int i = 0; i < R; i++) {
			yard[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (yard[i][j] != '#') {
					bfs(i, j);
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	public static void bfs(int x, int y) {
		int o = 0, v = 0;
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(x, y));
		if (yard[x][y] == 'o')
			o++;
		else if (yard[x][y] == 'v')
			v++;
		yard[x][y] = '#';

		while (!q.isEmpty()) {
			Point curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || yard[nx][ny] == '#')
					continue;

				q.add(new Point(nx, ny));
				if (yard[nx][ny] == 'o')
					o++;
				else if (yard[nx][ny] == 'v')
					v++;
				yard[nx][ny] = '#';
			}
		}

		if (o > v)
			sheep += o;
		else
			wolf += v;
	}

}
