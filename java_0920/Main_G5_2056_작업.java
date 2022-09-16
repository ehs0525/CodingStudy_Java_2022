package java_0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2056_작업 {

	public static int N;
	public static ArrayList<Integer>[] graph;
	public static int[] time, indegree, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		time = new int[N + 1];
		indegree = new int[N + 1];
		dp = new int[N + 1]; // dp[i] : i번 작업을 끝내기까지 걸리는 시간
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			time[i] = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				graph[Integer.parseInt(st.nextToken())].add(i);
				indegree[i]++;
			}
		}

		topologySort();

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Integer.max(max, dp[i]);
		}

		System.out.println(max);
	}

	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				dp[i] = time[i];
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : graph[curr]) {
				dp[next] = Integer.max(dp[next], dp[curr] + time[next]);

				if (--indegree[next] == 0) {
					q.offer(next);
//					dp[next] = dp[curr] + time[next];
				}
			}
		}
	}

}
