package java_1220;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_18188_다오의데이트 {

	static int H, W, N;
	static char[][] bubbleHill, interference;
	static Point dizni = null;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static class Dao {
		Point p;
		int moved;
		String path;

		public Dao(Point p, int moved, String path) {
			super();
			this.p = p;
			this.moved = moved;
			this.path = path;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		bubbleHill = new char[H + 1][W + 1];
		Point dao = null;
		for (int i = 1; i <= H; i++) {
			String line = in.readLine();
			for (int j = 1; j <= W; j++) {
				bubbleHill[i][j] = line.charAt(j - 1);
				if (bubbleHill[i][j] == 'D')
					dao = new Point(i, j);
				else if (bubbleHill[i][j] == 'Z')
					dizni = new Point(i, j);
			}
		}

		N = Integer.parseInt(in.readLine());
		interference = new char[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			char B = st.nextToken().charAt(0);
			char C = st.nextToken().charAt(0);

			interference[i][0] = B;
			interference[i][1] = C;
		}

		bfs(new Dao(dao, 0, ""));
	}

	private static void bfs(Dao dao) {
		Queue<Dao> q = new LinkedList<>();

		q.offer(dao);

		while (!q.isEmpty()) {
			Dao curr = q.poll();

			if (curr.p.equals(dizni)) {
				System.out.println("YES");
				System.out.println(curr.path);
				return;
			}

			for (int i = 0; i < 2; i++) {
				int nm = curr.moved + 1;
				if (nm > N)
					continue;
				int dir = getDirection(interference[nm][i]);
				int nx = curr.p.x + dx[dir];
				int ny = curr.p.y + dy[dir];
				String np = curr.path + interference[nm][i];

				if (nx < 1 || nx > H || ny < 1 || ny > W)
					continue;

				if (bubbleHill[nx][ny] != '@')
					q.offer(new Dao(new Point(nx, ny), nm, np));
			}
		}

		System.out.println("NO");
	}

	private static int getDirection(char dir) {
		switch (dir) {
		case 'W':
			return 0;
		case 'A':
			return 1;
		case 'S':
			return 2;
		case 'D':
			return 3;
		default:
			return -1;
		}
	}

}
