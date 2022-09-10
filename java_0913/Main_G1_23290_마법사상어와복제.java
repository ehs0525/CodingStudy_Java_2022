package java_0913;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_23290_마법사상어와복제 {

	public static int M, S, max;
	public static ArrayList<Integer>[][] grid = new ArrayList[5][5];
	public static Queue<Fish> fishList = new LinkedList<>();
	public static ArrayList<Integer> sharkPathList;
	public static int[][] smell = new int[5][5];
	public static Point s;

	public static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dx2 = { 0, -1, 0, 1, 0 };
	public static int[] dy2 = { 0, 0, -1, 0, 1 };

	public static class Fish {
		Point f;
		int d;

		public Fish(Point f, int d) {
			super();
			this.f = f;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 4; i++) {
			grid[i] = new ArrayList[5];
			for (int j = 1; j <= 4; j++) {
				grid[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			grid[x][y].add(d);
		}

		st = new StringTokenizer(in.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		s = new Point(x, y);

		while (S-- > 0) {
			useCloningMagic();
			moveFish();
			moveShark();
			smellDisappears();
			completeCloningMagic();
		}

		System.out.println(countFish());
	}

	public static int countFish() {
		int cnt = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				cnt += grid[i][j].size();
			}
		}

		return cnt;
	}

	public static void completeCloningMagic() {
		while (!fishList.isEmpty()) {
			Fish fish = fishList.poll();
			grid[fish.f.x][fish.f.y].add(fish.d);
		}
	}

	public static void smellDisappears() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (smell[i][j] > 0) {
					smell[i][j]--;
				}
			}
		}
	}

	public static void moveShark() {
		max = 0;
		sharkPathList = new ArrayList<>();
		dfs(0, new int[3]);
		Collections.sort(sharkPathList);
		int bestPath = sharkPathList.get(0);
		for (int i = 0; i < 3; i++) {
			int d = String.valueOf(bestPath).charAt(i) - '0';
			s.x += dx2[d];
			s.y += dy2[d];

			if (grid[s.x][s.y].size() > 0) {
				grid[s.x][s.y].clear();
				smell[s.x][s.y] = 2;
			}
		}
	}

	public static void dfs(int cnt, int[] path) {
		if (cnt >= 3) {
			int pathNum = 0;
			for (int i = 2; i >= 0; i--)
				pathNum = pathNum * 10 + path[i];

			int excludedFish = countExcludedFish(pathNum);
			if (excludedFish > max) {
				sharkPathList.clear();
				sharkPathList.add(pathNum);
				max = excludedFish;
			} else if (excludedFish == max) {
				sharkPathList.add(pathNum);
			}

			return;
		}

		for (int i = 1; i <= 4; i++) {
			path[cnt] = i;
			dfs(cnt + 1, path);
		}
	}

	public static int countExcludedFish(int path) {
		int cnt = 0;
		boolean[][] visited = new boolean[5][5];

		int x = s.x;
		int y = s.y;
		for (int i = 0; i < 3; i++) {
			int d = String.valueOf(path).charAt(i) - '0';
			x += dx2[d];
			y += dy2[d];

			if (x < 1 || x > 4 || y < 1 || y > 4)
				return -1;
			if (visited[x][y])
				continue;

			cnt += grid[x][y].size();
			visited[x][y] = true;
		}

		return cnt;
	}

	public static void moveFish() {
		ArrayList<Integer>[][] temp = new ArrayList[5][5];
		for (int i = 1; i <= 4; i++) {
			temp[i] = new ArrayList[5];
			for (int j = 1; j <= 4; j++) {
				temp[i][j] = new ArrayList<>();
			}
		}

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				ArrayList<Integer> list = grid[i][j];
				for (int k = 0; k < list.size(); k++) {
					int d = list.get(k);

					boolean movable = false;
					for (int l = 0; l < 8; l++) {
						int nd = d - l;
						if (nd < 1)
							nd += 8;
						int nx = i + dx[nd];
						int ny = j + dy[nd];

						if (nx < 1 || nx > 4 || ny < 1 || ny > 4)
							continue;
						if (nx == s.x && ny == s.y)
							continue;
						if (smell[nx][ny] > 0)
							continue;

						temp[nx][ny].add(nd);
						movable = true;
						break;
					}

					if (!movable)
						temp[i][j].add(d);
				}
			}
		}

		grid = temp;
	}

	public static void useCloningMagic() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				ArrayList<Integer> list = grid[i][j];
				for (int k = 0; k < list.size(); k++) {
					fishList.offer(new Fish(new Point(i, j), list.get(k)));
				}
			}
		}
	}

}
