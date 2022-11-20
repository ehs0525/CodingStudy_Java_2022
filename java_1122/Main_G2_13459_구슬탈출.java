package java_1122;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_13459_구슬탈출 {

	static int N, M;
	static char[][] board;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Location {
		Point red, blue;
		int tiltCnt;

		public Location(Point red, Point blue, int tiltCnt) {
			super();
			this.red = red;
			this.blue = blue;
			this.tiltCnt = tiltCnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		Point red = null, blue = null;
		for (int i = 0; i < N; i++) {
			board[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') {
					red = new Point(i, j);
				} else if (board[i][j] == 'B') {
					blue = new Point(i, j);
				}
			}
		}

		System.out.println(bfs(red, blue, 0));
	}

	private static int bfs(Point red, Point blue, int tiltCnt) {
		Queue<Location> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[N][M][N][M];

		q.offer(new Location(red, blue, tiltCnt));
		visited[red.x][red.y][blue.x][blue.y] = true;

		while (!q.isEmpty()) {
			Location curr = q.poll();

			if (curr.tiltCnt >= 10)
				return 0;

			for (int i = 0; i < 4; i++) {
				Point nRed = roll(curr.red, i), nBlue = roll(curr.blue, i);
				int nTiltCnt = curr.tiltCnt + 1;

				if (visited[nRed.x][nRed.y][nBlue.x][nBlue.y])
					continue;

				// 파란 구슬이 빠지는 경우
				if (board[nBlue.x][nBlue.y] == 'O')
					continue;
				// 빨간 구슬만 빠지는 경우
				if (board[nRed.x][nRed.y] == 'O')
					return 1;
				// 모두 안 빠지는 경우
				// 같은 위치일 경우 더 많이 이동한 구슬을 한 칸 반대로 이동
				if (nRed.equals(nBlue)) {
					int redRolled = Math.abs((nRed.x - curr.red.x) + (nRed.y - curr.red.y));
					int blueRolled = Math.abs((nBlue.x - curr.blue.x) + (nBlue.y - curr.blue.y));

					if (redRolled > blueRolled) {
						nRed.x -= dx[i];
						nRed.y -= dy[i];
					} else if (redRolled < blueRolled) {
						nBlue.x -= dx[i];
						nBlue.y -= dy[i];
					}
				}

				q.offer(new Location(nRed, nBlue, nTiltCnt));
				visited[nRed.x][nRed.y][nBlue.x][nBlue.y] = true;
			}
		}

		return 0;
	}

	private static Point roll(Point bead, int dir) {
		Point temp = (Point) bead.clone();
		while (board[temp.x + dx[dir]][temp.y + dy[dir]] != '#' && board[temp.x][temp.y] != 'O') {
			temp.x += dx[dir];
			temp.y += dy[dir];
		}

		return temp;
	}

}
