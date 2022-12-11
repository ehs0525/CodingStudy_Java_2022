import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7562_나이트의이동 {

	static int T, l;

	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static class Knight {
		Point p;
		int dist;

		public Knight(Point p, int dist) {
			super();
			this.p = p;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			l = Integer.parseInt(in.readLine());

			st = new StringTokenizer(in.readLine(), " ");
			Point src = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(in.readLine(), " ");
			Point dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			sb.append(bfs(src, dest)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int bfs(Point src, Point dest) {
		Queue<Knight> q = new LinkedList<>();
		boolean[][] visited = new boolean[l][l];

		q.offer(new Knight(src, 0));
		visited[src.x][src.y] = true;

		while (!q.isEmpty()) {
			Knight curr = q.poll();

			if (curr.p.equals(dest))
				return curr.dist;

			for (int i = 0; i < 8; i++) {
				int nx = curr.p.x + dx[i];
				int ny = curr.p.y + dy[i];
				int nd = curr.dist + 1;

				if (nx < 0 || nx >= l || ny < 0 || ny >= l)
					continue;
				if (visited[nx][ny])
					continue;

				q.offer(new Knight(new Point(nx, ny), nd));
				visited[nx][ny] = true;
			}
		}
		
		return -1;
	}

}
