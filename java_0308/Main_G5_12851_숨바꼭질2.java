package java_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_12851_¼û¹Ù²ÀÁú2 {

	public static int N, K, min = Integer.MAX_VALUE, cnt = 0;
	public static int[] visited = new int[100001];
	public static int[] dx = { -1, 1, 2 };

	public static class Soobin {
		int position, time;

		public Soobin(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(visited, Integer.MAX_VALUE);

		hideAndSeek(new Soobin(N, 0));
		System.out.println(min + "\n" + cnt);
	}

	public static void hideAndSeek(Soobin start) {
		Queue<Soobin> q = new LinkedList<>();

		q.offer(start);
		visited[start.position] = 0;

		while (!q.isEmpty()) {
			Soobin curr = q.poll();

			if (curr.position == K) {
				if (curr.time < min) {
					min = curr.time;
					cnt = 1;
				} else {
					cnt++;
				}
			}

			for (int i = 0; i < 3; i++) {
				int nextP = i < 2 ? curr.position + dx[i] : curr.position * dx[i];
				int nextT = curr.time + 1;

				if (nextP >= 0 && nextP <= 100000 && nextT <= visited[nextP]) {
					q.offer(new Soobin(nextP, nextT));
					visited[nextP] = nextT;
				}
			}
		}

	}

}
