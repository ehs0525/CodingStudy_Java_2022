package java_0614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 참고 : ddb8036631.github.io/boj/2151_거울-설치/ - 무성이의 공부 블로그

public class Main_G3_2151_거울설치 {

	public static int N, min = Integer.MAX_VALUE;
	public static char[][] house;
	public static Point[] doors = new Point[2];
	public static int[][][] visited; // 현재까지 거울의 누적 개수

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static class Point {
		int x, y, dir;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		house = new char[N][N];
		visited = new int[N][N][4];

		int doorIdx = 0;
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				house[i][j] = line.charAt(j);

				if (house[i][j] == '#')
					doors[doorIdx++] = new Point(i, j);
			}
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);

		bfs(doors[0]);
		for (int i = 0; i < 4; i++)
			min = Integer.min(min, visited[doors[1].x][doors[1].y][i]);

		System.out.println(min);
	}

	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < 4; i++) {
			q.offer(new Point(start.x, start.y, i));
			visited[start.x][start.y][i] = 0;
		}

		while (!q.isEmpty()) {
			Point curr = q.poll();

			int dir = curr.dir;
			int nx = curr.x + dx[dir];
			int ny = curr.y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (house[nx][ny] == '*')
				continue;

			if (house[nx][ny] == '#') {
				if (visited[nx][ny][dir] > visited[curr.x][curr.y][dir])
					visited[nx][ny][dir] = visited[curr.x][curr.y][dir];
			} else if (house[nx][ny] == '.') {
				if (visited[nx][ny][dir] > visited[curr.x][curr.y][dir]) {
					visited[nx][ny][dir] = visited[curr.x][curr.y][dir];
					q.offer(new Point(nx, ny, dir));
				}
			} else if (house[nx][ny] == '!') {
				// 거울 설치
				int[] nd = reflect(dir);

				for (int i = 0; i < 2; i++) {
					if (visited[nx][ny][nd[i]] > visited[curr.x][curr.y][dir] + 1) {
						visited[nx][ny][nd[i]] = visited[curr.x][curr.y][dir] + 1;
						q.offer(new Point(nx, ny, nd[i]));
					}
				}

				// 거울 설치 x
				if (visited[nx][ny][dir] > visited[curr.x][curr.y][dir]) {
					visited[nx][ny][dir] = visited[curr.x][curr.y][dir];
					q.offer(new Point(nx, ny, dir));
				}
			}
		}
	}

	public static int[] reflect(int dir) {
		if (dir == 0 || dir == 1)
			return new int[] { 2, 3 };
		else
			return new int[] { 0, 1 };
	}

}
