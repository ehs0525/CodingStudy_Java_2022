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
		// 1. ���������� 0�� ������ ť�� �����Ѵ�.
		// 2. ť���� ���Ҹ� ���� ����� ��� ������ �����Ѵ�.
		// 3. ���� ���� ���Ŀ� ���������� 0�� �� ������ ť�� �����Ѵ�.
		// 4. ť�� �� ������ 2~3�� ������ �ݺ��Ѵ�. ��� ���Ҹ� �湮�ϱ� ���� ť�� ��ٸ�
		// ����Ŭ�� �����ϴ� ���̰�, ��� ���Ҹ� �湮�ߴٸ� ť���� ���� ������ ���� ������ ����̴�.

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
