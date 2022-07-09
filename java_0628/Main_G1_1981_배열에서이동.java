package java_0628;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1981_배열에서이동 {

	public static int n, max = 201, min = -1, ans = Integer.MAX_VALUE;
	public static int[][] arr;
	public static ArrayList<Integer> nums = new ArrayList<>();

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (!nums.contains(arr[i][j]))
					nums.add(arr[i][j]);
			}
		}

		Collections.sort(nums);

		int minIdx = 0, maxIdx = 0;
		while (minIdx < nums.size() && maxIdx < nums.size()) {
			if (bfs(nums.get(minIdx), nums.get(maxIdx))) {
				int diff = nums.get(maxIdx) - nums.get(minIdx);
				ans = Integer.min(ans, diff);
				minIdx++;
			} else {
				maxIdx++;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean bfs(int min, int max) {
		if (arr[1][1] < min || arr[1][1] > max)
			return false;

		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[n + 1][n + 1];

		q.offer(new Point(1, 1));
		visited[1][1] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();

			if (curr.x == n && curr.y == n)
				return true;

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 1 || nx > n || ny < 1 || ny > n)
					continue;
				if (visited[nx][ny])
					continue;

				if (min <= arr[nx][ny] && arr[nx][ny] <= max) {
					q.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		return false;
	}

}
