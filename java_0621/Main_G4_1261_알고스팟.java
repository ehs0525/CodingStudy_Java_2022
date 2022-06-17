package java_0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1261_¾Ë°í½ºÆÌ {

	public static int M, N;
	public static int[][] maze;

	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static class Room implements Comparable<Room> {
		int x, y, broken;

		public Room(int x, int y, int broken) {
			this.x = x;
			this.y = y;
			this.broken = broken;
		}

		@Override
		public int compareTo(Room o) {
			return Integer.compare(this.broken, o.broken);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String line = in.readLine();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = line.charAt(j - 1) - '0';
			}
		}

		bfs(new Room(1, 1, 0));
	}

	public static void bfs(Room start) {
		PriorityQueue<Room> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N + 1][M + 1];

		pq.offer(start);
		visited[start.x][start.y] = true;

		while (!pq.isEmpty()) {
			Room curr = pq.poll();

			if (curr.x == N && curr.y == M) {
				System.out.println(curr.broken);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 1 || nx > N || ny < 1 || ny > M)
					continue;
				if (visited[nx][ny])
					continue;

				if (maze[nx][ny] == 0) {
					pq.offer(new Room(nx, ny, curr.broken));
				} else {
					pq.offer(new Room(nx, ny, curr.broken + 1));
				}
				visited[nx][ny] = true;
			}
		}
	}

}
