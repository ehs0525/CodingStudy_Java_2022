package java_0426;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_Gold5_21610_마법사상어와비바라기 {

	public static int N, M;
	public static int[][] A;
	public static int[] d, s;
	public static ArrayList<Point> clouds = new ArrayList<>();

	public static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d = new int[M];
		s = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			d[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}

		clouds.add(new Point(N, 1));
		clouds.add(new Point(N, 2));
		clouds.add(new Point(N - 1, 1));
		clouds.add(new Point(N - 1, 2));

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < clouds.size(); j++) {
				// 1. 모든 구름이 di 방향으로 si칸 이동한다.
				int nx = (clouds.get(j).x + dx[d[i]] * s[i]) % N;
				if (nx <= 0)
					nx += N;

				int ny = (clouds.get(j).y + dy[d[i]] * s[i]) % N;
				if (ny <= 0)
					ny += N;

				clouds.get(j).x = nx;
				clouds.get(j).y = ny;
				// 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
				A[nx][ny]++;
			}

			// 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
			for (int j = 0; j < clouds.size(); j++) {
				int cnt = 0;
				for (int k = 2; k <= 8; k += 2) {
					int nx = clouds.get(j).x + dx[k];
					int ny = clouds.get(j).y + dy[k];

					if (nx <= 0 || nx > N || ny <= 0 || ny > N)
						continue;

					if (A[nx][ny] > 0)
						cnt++;
				}

				A[clouds.get(j).x][clouds.get(j).y] += cnt;
			}

			// 3. 구름이 모두 사라진다.
			ArrayList<Point> temp = new ArrayList<>();
			while (!clouds.isEmpty())
				temp.add(clouds.remove(0));

			// 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이
			// 사라진 칸이 아니어야 한다.
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (A[j][k] >= 2 && !temp.contains(new Point(j, k))) {
						clouds.add(new Point(j, k));
						A[j][k] -= 2;
					}
				}
			}
		}

		System.out.println(getSum());
	}

	public static int getSum() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum += A[i][j];
			}
		}

		return sum;
	}

}
