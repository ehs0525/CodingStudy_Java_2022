package java_0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_5014_스타트링크 {

	public static int F, S, G, U, D;
	public static int[] pressed;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		pressed = new int[F + 1];

		bfs();
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		pressed[S] = 1;

		while (!q.isEmpty()) {
			int curr = q.poll();

			if (curr == G) {
				System.out.println(pressed[curr] - 1);
				return;
			}

			int[] ds = { U, -D };
			for (int i = 0; i < 2; i++) {
				int next = curr + ds[i];

				if (1 <= next && next <= F && pressed[next] == 0) {
					q.offer(next);
					pressed[next] = pressed[curr] + 1;
				}
			}

		}

		System.out.println("use the stairs");
	}

}
