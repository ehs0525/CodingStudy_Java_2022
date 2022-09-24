package java_0927;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_4179_불 {

	public static int R, C;
	public static char[][] maze;
	public static Queue<Point> fire = new LinkedList<>();

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static class Jihoon {
		Point p;
		int dist;

		public Jihoon(Point p, int dist) {
			super();
			this.p = p;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new char[R][C];

		Point jihoon = null;
		for (int i = 0; i < R; i++) {
			maze[i] = in.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (maze[i][j] == 'J') {
					jihoon = new Point(i, j);
				} else if (maze[i][j] == 'F') {
					fire.add(new Point(i, j));
				}
			}
		}

		System.out.println(bfs(jihoon));
	}

	public static String bfs(Point start) {
		Queue<Jihoon> jihoonQ = new LinkedList<>();
		jihoonQ.offer(new Jihoon(start, 0));

		while (!jihoonQ.isEmpty()) {
			// 불 확산
			fireSpreads();

			int size = jihoonQ.size();
			for (int i = 0; i < size; i++) {
				Jihoon curr = jihoonQ.poll();
				if (curr.p.x == 0 || curr.p.x == R - 1 || curr.p.y == 0 || curr.p.y == C - 1)
					return String.valueOf(curr.dist + 1);

				for (int j = 0; j < 4; j++) {
					int nx = curr.p.x + dx[j];
					int ny = curr.p.y + dy[j];

					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if (maze[nx][ny] == '#' || maze[nx][ny] == 'J' || maze[nx][ny] == 'F')
						continue;

					jihoonQ.offer(new Jihoon(new Point(nx, ny), curr.dist + 1));
					maze[nx][ny] = 'J';
				}
			}
		}

		return "IMPOSSIBLE";
	}

	public static void fireSpreads() {
		int size = fire.size();
		for (int i = 0; i < size; i++) {
			Point f = fire.poll();

			for (int j = 0; j < 4; j++) {
				int nx = f.x + dx[j];
				int ny = f.y + dy[j];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;
				if (maze[nx][ny] == '#' || maze[nx][ny] == 'F')
					continue;

				fire.add(new Point(nx, ny));
				maze[nx][ny] = 'F';
			}
		}

	}

}
