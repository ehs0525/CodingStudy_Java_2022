package java_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2251_물통 {

	public static int[] capacity = new int[3];
	public static boolean[][][] visited;
	public static ArrayList<Integer> answer = new ArrayList<>();

	public static class Bottle {
		int[] contained;

		public Bottle(int[] amount) {
			this.contained = new int[3];
			for (int i = 0; i < 3; i++) {
				this.contained[i] = amount[i];
			}
		}

		Bottle pourWater(int from, int to, int[] capacity) {
			int[] result = new int[] { this.contained[0], this.contained[1], this.contained[2] };

			// from 물통이 비는 경우
			if (this.contained[from] + this.contained[to] <= capacity[to]) {
				result[from] = 0;
				result[to] = this.contained[from] + this.contained[to];
			} else { // to 물통이 가득 차는 경우
				result[from] = this.contained[from] + this.contained[to] - capacity[to];
				result[to] = capacity[to];
			}

			return new Bottle(result);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		for (int i = 0; i < 3; i++) {
			capacity[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[capacity[2] + 1][capacity[2] + 1][capacity[2] + 1];

		bfs(new Bottle(new int[] { 0, 0, capacity[2] }));
		Collections.sort(answer);

		for (int ans : answer) {
			System.out.print(ans + " ");
		}
	}

	public static void bfs(Bottle start) {
		Queue<Bottle> q = new LinkedList<>();

		q.offer(start);
		visited[start.contained[0]][start.contained[1]][start.contained[2]] = true;

		while (!q.isEmpty()) {
			Bottle curr = q.poll();

			if (curr.contained[0] == 0)
				answer.add(curr.contained[2]);

			for (int from = 0; from < 3; from++) {
				for (int to = 0; to < 3; to++) {
					if (from == to)
						continue;

					Bottle next = curr.pourWater(from, to, capacity);

					if (!visited[next.contained[0]][next.contained[1]][next.contained[2]]) {
						q.offer(next);
						visited[next.contained[0]][next.contained[1]][next.contained[2]] = true;
					}
				}
			}
		}
	}

}
