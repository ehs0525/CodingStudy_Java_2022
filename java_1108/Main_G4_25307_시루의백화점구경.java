package java_1108;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_25307_시루의백화점구경 {

	static int N, M, K;
	static int[][] map;
	static boolean[][] isNearMannequin;
	static Queue<Node> mannequins = new LinkedList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		Point p;
		int d;

		public Node(Point p, int d) {
			super();
			this.p = p;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isNearMannequin = new boolean[N][M];
		Point start = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 3) {
					mannequins.offer(new Node(new Point(i, j), 0));
					isNearMannequin[i][j] = true;
				} else if (map[i][j] == 4) {
					start = new Point(i, j);
				}
			}
		}

		setNearMannequin();
		System.out.println(bfs(new Node(start, 0)));

	}

	private static void setNearMannequin() {
		while (!mannequins.isEmpty()) {
			Node curr = mannequins.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.p.x + dx[i];
				int ny = curr.p.y + dy[i];
				int nd = curr.d + 1;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || isNearMannequin[nx][ny])
					continue;
				if (nd > K)
					continue;

				mannequins.offer(new Node(new Point(nx, ny), nd));
				isNearMannequin[nx][ny] = true;
			}
		}
	}

	private static int bfs(Node siru) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		q.offer(siru);
		visited[siru.p.x][siru.p.y] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (map[curr.p.x][curr.p.y] == 2)
				return curr.d;

			for (int i = 0; i < 4; i++) {
				int nx = curr.p.x + dx[i];
				int ny = curr.p.y + dy[i];
				int nd = curr.d + 1;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;
				if (map[nx][ny] == 1 || isNearMannequin[nx][ny])
					continue;

				q.offer(new Node(new Point(nx, ny), nd));
				visited[nx][ny] = true;
			}
		}

		return -1;
	}

}