package java_1018;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_15573_Ã¤±¼ {

	static int N, M, K;
	static int[][] S;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		S = new int[N + 1][M + 1];
		int max = 1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
				max = Integer.max(max, S[i][j]);
			}
		}

		int s = 1, e = max;
		while (s < e) {
			int mid = (s + e) / 2;
			if (mine(mid) < K)
				s = mid + 1;
			else
				e = mid;
		}

		System.out.println(s);
	}

	public static int mine(int perf) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				for (int j = 1; j <= M; j++) {
					if (S[i][j] <= perf) {
						q.offer(new Point(i, j));
						visited[i][j] = true;
					}
				}
			} else {
				if (S[i][1] <= perf) {
					q.offer(new Point(i, 1));
					visited[i][1] = true;
				}
				if (M > 1 && S[i][M] <= perf) {
					q.offer(new Point(i, M));
					visited[i][M] = true;
				}
			}
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			Point curr = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 1 || nx > N || ny < 1 || ny > M)
					continue;
				if (visited[nx][ny])
					continue;
				if (S[nx][ny] > perf)
					continue;

				q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}

		return cnt;
	}

}
