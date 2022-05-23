package java_0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_1005_ACMCraft {

	public static int T, N, K, X, Y, W;
	public static int[] D, indegree, dp;
	public static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 진입차수가 0인 정점을 큐에 삽입한다.
		// 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거한다.
		// 3. 간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입한다.
		// 4. 큐가 빌 때까지 2~3번 과정을 반복한다. 모든 원소를 방문하기 전에 큐가 빈다면
		// 사이클이 존재하는 것이고, 모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상 정렬의 결과이다.

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			D = new int[N + 1];
			indegree = new int[N + 1];
			dp = new int[N + 1];
			graph = new ArrayList[N + 1];

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());

				graph[X].add(Y);
				indegree[Y]++;
			}

			W = Integer.parseInt(in.readLine());

			construct();
			sb.append(dp[W]).append("\n");
		}

		System.out.println(sb);
	}

	public static void construct() {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				dp[i] = D[i];
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : graph[curr]) {
				if (--indegree[next] == 0) {
					q.offer(next);
					dp[next] = Integer.max(dp[next], dp[curr] + D[next]);
				}
			}
		}
	}

}
