package java_0913;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_18500_미네랄2 {

	public static int R, C, N;
	public static char[][] cave;
	public static boolean[][] visited;
	public static ArrayList<Point> cluster;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cave = new char[R][C];
		for (int i = 0; i < R; i++) {
			cave[i] = in.readLine().toCharArray();
		}

		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int height = R - Integer.parseInt(st.nextToken());

			destroyMineral(i, height);
			checkFloor(); // 바닥에 있는 클러스터면 visited가 true
			checkAir(); // 떠 있는 클러스터의 경우, 바닥으로 떨어트림
		}

		for (int i = 0; i < R; i++) {
			System.out.println(String.valueOf(cave[i]));
		}
	}

	public static void checkAir() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (cave[i][j] == 'x' && !visited[i][j]) {
					bfs(new Point(i, j));
					clusterFalls();
					return;
				}
			}
		}
	}

	public static void clusterFalls() {
		int fallingHeight = getFallingHeight();

		for (int i = 0; i < cluster.size(); i++) {
			Point mineral = cluster.get(i);
			cave[mineral.x][mineral.y] = '.';
		}
		for (int i = 0; i < cluster.size(); i++) {
			Point mineral = cluster.get(i);
			cave[mineral.x + fallingHeight][mineral.y] = 'x';
		}
	}

	public static int getFallingHeight() {
		int h;
		for (h = 1; h < R; h++) {
			for (int i = 0; i < cluster.size(); i++) {
				Point p = cluster.get(i);
				if (p.x + h >= R || (!cluster.contains(new Point(p.x + h, p.y)) && cave[p.x + h][p.y] == 'x'))
					return h - 1;
			}
		}
		return 0;
	}

	public static void checkFloor() {
		visited = new boolean[R][C];
		for (int i = 0; i < C; i++) {
			if (cave[R - 1][i] == 'x' && !visited[R - 1][i]) {
				bfs(new Point(R - 1, i));
			}
		}
	}

	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		cluster = new ArrayList<>();

		q.offer(start);
		visited[start.x][start.y] = true;
		cluster.add(start);

		while (!q.isEmpty()) {
			Point curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;
				if (cave[nx][ny] == '.' || visited[nx][ny])
					continue;

				q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
				cluster.add(new Point(nx, ny));
			}
		}
	}

	public static void destroyMineral(int turn, int height) {
		int bar;

		if (turn % 2 == 0) {
			bar = 0;
			while (bar < C && cave[height][bar] == '.')
				bar++;
		} else {
			bar = C - 1;
			while (bar >= 0 && cave[height][bar] == '.')
				bar--;
		}

		if (bar >= 0 && bar < C)
			cave[height][bar] = '.';
	}

}
