package java_0913;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_23288_¡÷ªÁ¿ß±º∏Æ±‚2 {

	public static int N, M, K, sum = 0;
	public static int[][] map;
	public static int[][] dice = { { 0, 2, 0, 0 }, { 4, 1, 3, 6 }, { 0, 5, 0, 0 }, { 0, 6, 0, 0 } };
	public static int r = 1, c = 1, d = 0;

	// µø, ≥≤, º≠, ∫œ
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (K-- > 0) {
			rollDice();
			score();
			determineDirection();
		}

		System.out.println(sum);
	}

	public static void determineDirection() {
		int A = dice[3][1];
		int B = map[r][c];

		if (A > B)
			d = (d + 1) % 4;
		else if (A < B)
			d = (d + 3) % 4;
	}

	public static void score() {
		int B = map[r][c];
		int C = 0;
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][M + 1];

		q.offer(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			C++;

			for (int i = 0; i < 4; i++) {
				Point next = new Point(curr.x + dr[i], curr.y + dc[i]);
				int nr = next.x;
				int nc = next.y;

				if (nr < 1 || nr > N || nc < 1 || nc > M)
					continue;
				if (visited[nr][nc] || map[nr][nc] != B)
					continue;

				q.offer(next);
				visited[nr][nc] = true;
			}
		}

		sum += B * C;
	}

	public static void rollDice() {
		r += dr[d];
		c += dc[d];
		if (r < 1 || r > N || c < 1 || c > M) {
			d = (d + 2) % 4;
			r += 2 * dr[d];
			c += 2 * dc[d];
		}

		int temp;
		switch (d) {
		case 0: // µø
			temp = dice[1][3];
			for (int i = 3; i > 0; i--)
				dice[1][i] = dice[1][i - 1];
			dice[1][0] = temp;
			dice[3][1] = dice[1][3];
			break;
		case 1: // ≥≤
			temp = dice[3][1];
			for (int i = 3; i > 0; i--)
				dice[i][1] = dice[i - 1][1];
			dice[0][1] = temp;
			dice[1][3] = dice[3][1];
			break;
		case 2: // º≠
			temp = dice[1][0];
			for (int i = 0; i < 3; i++)
				dice[1][i] = dice[1][i + 1];
			dice[1][3] = temp;
			dice[3][1] = dice[1][3];
			break;
		case 3: // ∫œ
			temp = dice[0][1];
			for (int i = 0; i < 3; i++)
				dice[i][1] = dice[i + 1][1];
			dice[3][1] = temp;
			dice[1][3] = dice[3][1];
			break;
		}
	}

}
