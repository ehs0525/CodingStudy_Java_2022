package java_0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 초과

public class Main_G3_14442_벽부수고이동하기2 {

	public static int N, M, K, min = Integer.MAX_VALUE;
	public static char[][] map;
	public static int[][] visited;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static class Space {
		int x, y, dist, broke;

		public Space(int x, int y, int dist, int broke) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.broke = broke;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N + 1][M + 1];
		visited = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line[j - 1];
			}
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}

		bfs(new Space(1, 1, 1, 0));

		if (min < Integer.MAX_VALUE) {
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs(Space start) {
		Queue<Space> q = new LinkedList<>();

		q.offer(start);
		visited[start.x][start.y] = start.broke;

		while (!q.isEmpty()) {
			Space curr = q.poll();

			if (curr.x == N && curr.y == M) {
				min = curr.dist;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				int nd = curr.dist + 1;

				if (nx < 1 || nx > N || ny < 1 || ny > M)
					continue;
				if (curr.broke == K && map[nx][ny] == '1')
					continue;

				if (map[nx][ny] == '0') {
					q.offer(new Space(nx, ny, nd, curr.broke));
					visited[nx][ny] = curr.broke;
				} else {
					q.offer(new Space(nx, ny, nd, curr.broke + 1));
					visited[nx][ny] = curr.broke + 1;
				}
			}
		}

	}

}
