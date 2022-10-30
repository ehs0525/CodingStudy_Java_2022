package java_1101;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_G3_2234_¼º°û {

	static int N, M, ans1 = 0, ans2 = 0, ans3 = 0;
	static int[][] castle, roomNum;
	static ArrayList<Integer> sizeOfRoom = new ArrayList<>();
	static HashMap<Integer, Set<Integer>> adjRooms = new HashMap<>();

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		castle = new int[M + 1][N + 1];
		roomNum = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= M; i++) {
			Arrays.fill(roomNum[i], -1);
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (roomNum[i][j] == -1) {
					bfs(new Point(i, j), ans1++);
				}
			}
		}

		for (int i = 0; i < ans1; i++) {
			int size1 = sizeOfRoom.get(i);
			for (int room : adjRooms.get(i)) {
//				System.out.println("KK "+ room);
				int size2 = sizeOfRoom.get(room);
				ans3 = Integer.max(ans3, size1 + size2);
			}
		}

		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
	}

	private static void bfs(Point p, int num) {
		Queue<Point> q = new LinkedList<>();
		int cnt = 0;
		adjRooms.put(num, new HashSet<>());

		q.offer(p);
		roomNum[p.x][p.y] = num;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 1 || nx > M || ny < 1 || ny > N || roomNum[nx][ny] == num)
					continue;
				if (roomNum[nx][ny] != -1) {
					adjRooms.get(num).add(roomNum[nx][ny]);
					continue;
				}
				if ((castle[curr.x][curr.y] & (1 << i)) == 1 << i)
					continue;

				q.offer(new Point(nx, ny));
				roomNum[nx][ny] = num;
			}
		}

		sizeOfRoom.add(cnt);
		ans2 = Integer.max(ans2, cnt);
	}

}
