package java_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_19238_스타트택시 {

	public static int N, M, fuel;
	public static int R, C;
	public static int[][] map;
	public static Passenger[] passengers;
	public static PriorityQueue<Distance> pq;

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static class Passenger {
		int idx, sr, sc, dr, dc;
		boolean arrived;

		public Passenger(int idx, int sr, int sc, int dr, int dc, boolean arrived) {
			this.idx = idx;
			this.sr = sr;
			this.sc = sc;
			this.dr = dr;
			this.dc = dc;
			this.arrived = arrived;
		}
	}

	public static class Point {
		int r, c, dist;

		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	public static class Distance implements Comparable<Distance> {
		int idx, r, c, dist;

		public Distance(int idx, int r, int c, int dist) {
			this.idx = idx;
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Distance o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		passengers = new Passenger[M + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int dr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());
			passengers[i] = new Passenger(i, sr, sc, dr, dc, false);
		}

		for (int i = 0; i < M; i++) {
			pq = setDistancePQ();

			if (pq.size() == 0) {
				System.out.println(-1);
				return;
			}

			Distance passenger = pq.peek();

			fuel -= passenger.dist;
			R = passenger.r;
			C = passenger.c;

			int pdr = passengers[passenger.idx].dr;
			int pdc = passengers[passenger.idx].dc;
			int movedDist = movePassenger(pdr,pdc );

			if (movedDist == -1) {
				System.out.println(-1);
				return;
			}

			fuel -= movedDist;
//			R = passengers[passenger.idx].dr;
//			C = passengers[passenger.idx].dc;
			R = pdr;
			C = pdc;
			fuel += movedDist * 2;
			passengers[passenger.idx].arrived = true;
		}

		System.out.println(fuel);
	}

	public static int movePassenger(int destR, int destC) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		q.offer(new Point(R, C, 0));
		visited[R][C] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();

			if (fuel - curr.dist < 0)
				return -1;

			if (curr.r == destR && curr.c == destC)
				return curr.dist;

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				int ndist = curr.dist + 1;

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[nr][nc] == 1)
					continue;

				q.offer(new Point(nr, nc, ndist));
				visited[nr][nc] = true;
			}
		}

		return -1;

	}

	// bfs로 최단거리 구해서 Priority Queue에 삽입
	public static PriorityQueue<Distance> setDistancePQ() {
		PriorityQueue<Distance> result = new PriorityQueue<>();

		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		q.offer(new Point(R, C, 0));
		visited[R][C] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();

			if (fuel - curr.dist < 0)
				break;

			int passengerIdx = getPassengerIdx(curr.r, curr.c);
			if (passengerIdx > 0) // 승객이라면 result에 넣는다.
				result.offer(new Distance(passengerIdx, curr.r, curr.c, curr.dist));

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				int ndist = curr.dist + 1;

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[nr][nc] == 1)
					continue;

				q.offer(new Point(nr, nc, ndist));
				visited[nr][nc] = true;
			}
		}

		return result;
	}

	public static int getPassengerIdx(int r, int c) {
		for (int i = 1; i <= M; i++) {
			if (passengers[i].sr == r && passengers[i].sc == c && passengers[i].arrived == false)
				return passengers[i].idx;
		}
		return 0;
	}

}
