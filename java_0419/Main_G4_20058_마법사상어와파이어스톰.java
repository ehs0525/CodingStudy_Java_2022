package java_0419;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_20058_마법사상어와파이어스톰 {

	public static int N, Q, M, max = 0;
	public static int[][] A;
	public static int[] L;

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		M = (int) Math.pow(2, N);

		A = new int[M][M];
		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < M; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine(), " ");
		L = new int[Q + 1];
		for (int i = 1; i <= Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		castSpells();

		System.out.println(getRemainingIce());

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < M; c++) {
				if (A[r][c] != 0) {
					max = Math.max(max, bfs(new Point(r, c)));
				}
			}
		}
		System.out.println(max);
	}

	private static int bfs(Point p) {
		int size = 0;

		Queue<Point> q = new LinkedList<Point>();

		q.offer(p);
		A[p.x][p.y] = 0;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			size++;

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dr[i];
				int ny = curr.y + dc[i];

				if (nx < 0 || nx >= M || ny < 0 || ny >= M)
					continue;
				if (A[nx][ny] == 0)
					continue;

				q.offer(new Point(nx, ny));
				A[nx][ny] = 0;
			}
		}

		return size;
	}

	public static int getRemainingIce() {
		int sum = 0;

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < M; c++) {
				sum += A[r][c];
			}
		}

		return sum;
	}

	public static void castSpells() {
		for (int i = 1; i <= Q; i++) {
			int size = (int) Math.pow(2, L[i]);
			for (int r = 0; r < M; r += size) {
				for (int c = 0; c < M; c += size) {
					rotate(r, c, size);
				}
			}

			meltIce();
		}

	}

	public static void meltIce() {
		ArrayList<Point> ices = new ArrayList<>();

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < M; c++) {
				int cnt = 0; // 얼음 없는 곳을 세기 위한 변수
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= M || nc < 0 || nc >= M || A[nr][nc] == 0) {
						if (++cnt >= 2 && A[r][c] > 0) {
							ices.add(new Point(r, c));
							break;
						}
					}
				}
			}
		}

		for (int i = 0; i < ices.size(); i++) {
			Point ice = ices.get(i);
			A[ice.x][ice.y]--;
		}
	}

	public static void rotate(int x, int y, int size) {
		if (size <= 0)
			return;

		// 좌측 -> temp
		int[] temp = new int[size - 1];
		for (int i = 0; i < size - 1; i++)
			temp[i] = A[x + i][y];

		// 하단 -> 좌측
//		(3,0),(2,1),(1,2)
		for (int i = 0; i < size - 1; i++) {
			A[x + i][y] = A[x + size - 1][y + i];
		}

		// 우측 -> 하단
		for (int i = 0; i < size - 1; i++) {
			A[x + size - 1][y + i] = A[x + size - 1 - i][y + size - 1];
		}

		// 상단 -> 우측
		for (int i = 0; i < size - 1; i++) {
			A[x + size - 1 - i][y + size - 1] = A[x][y + size - 1 - i];
		}

		// temp -> 상단
		for (int i = 0; i < size - 1; i++) {
			A[x][y + size - 1 - i] = temp[i];
		}

		rotate(x + 1, y + 1, size - 2);
	}

}
