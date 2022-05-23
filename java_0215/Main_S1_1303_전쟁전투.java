package java_0215;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1303_¿¸¿Ô¿¸≈ı {

	public static int N, M, W, B, friend, foe;
	public static char color;
	public static char[][] battlefield;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		battlefield = new char[M][N];

		for (int i = 0; i < M; i++) {
			battlefield[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				color = battlefield[i][j];
				if (color != 'X') {
					W = B = 0;
					bfs(new Point(i, j), color);
					if (color == 'W') {
						friend += W * W;
					} else {
						foe += B * B;
					}
				}
			}
		}

		System.out.println(friend + " " + foe);
	}

	public static void bfs(Point p, char color) {
		Queue<Point> q = new LinkedList<>();

		q.offer(p);
		battlefield[p.x][p.y] = 'X';
		if (color == 'W') {
			W++;
		} else {
			B++;
		}

		while (!q.isEmpty()) {
			Point curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N && battlefield[nx][ny] == color) {
					q.offer(new Point(nx, ny));
					battlefield[nx][ny] = 'X';
					if (color == 'W') {
						W++;
					} else {
						B++;
					}
				}
			}
		}
	}

}
