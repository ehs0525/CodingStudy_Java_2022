package java_1227;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G1_17143_³¬½Ã¿Õ {

	static int R, C, M, sum = 0;
	static Shark[][] grid;
	static ArrayList<Shark> sharks = new ArrayList<>();

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	static class Shark {
		Point position;
		int speed, direction, size;

		public Shark(Point position, int speed, int direction, int size) {
			super();
			this.position = position;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(new Point(r, c), s, d, z);
			sharks.add(shark);
			grid[r][c] = shark;
		}

		int fishingKing = 0;
		while (true) {
			if (++fishingKing > C)
				break;

			catchClosestShark(fishingKing);
			move();
		}

		System.out.println(sum);
	}

	private static void move() {
		for (int i = 0; i < sharks.size(); i++) {
			Shark shark = sharks.get(i);
			int r = shark.position.x;
			int c = shark.position.y;
			int s = shark.speed;
			int d = shark.direction;

			while (s > 0) {
				if (d == 1) {
					if (r - s >= 1) {
						r -= s;
						s = 0;
					} else {
						s -= (r - 1);
						r = 1;
						d = 2;
					}
				} else if (d == 2) {
					if (r + s <= R) {
						r += s;
						s = 0;
					} else {
						s -= (R - r);
						r = R;
						d = 1;
					}
				} else if (d == 3) {
					if (c + s <= C) {
						c += s;
						s = 0;
					} else {
						s -= (C - c);
						c = C;
						d = 4;
					}
				} else {
					if (c - s >= 1) {
						c -= s;
						s = 0;
					} else {
						s -= (c - 1);
						c = 1;
						d = 3;
					}
				}
			}

			shark.position = new Point(r, c);
			shark.direction = d;
		}

		eatShark();
	}

	private static void eatShark() {
		grid = new Shark[R + 1][C + 1];

		for (int i = 0; i < sharks.size(); i++) {
			Shark shark = sharks.get(i);
			int r = shark.position.x;
			int c = shark.position.y;

			if (grid[r][c] == null) {
				grid[r][c] = shark;
			} else if (grid[r][c].size < shark.size) {
				sharks.remove(grid[r][c]);
				grid[r][c] = shark;
				i--;
			} else {
				sharks.remove(shark);
				i--;
			}
		}

	}

	private static void catchClosestShark(int col) {
		int row = 1;
		while (row <= R && grid[row][col] == null)
			row++;

		if (row <= R) {
			Shark target = grid[row][col];

			sum += target.size;
			sharks.remove(target);
			grid[row][col] = null;
		}
	}

}
