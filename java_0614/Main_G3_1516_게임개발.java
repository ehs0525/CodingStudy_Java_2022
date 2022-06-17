package java_0614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_1516_���Ӱ��� {

	public static int N;
	public static int[] indegree, time, result;
	public static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		indegree = new int[N + 1];
		time = new int[N + 1];
		result = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			time[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int building = Integer.parseInt(st.nextToken());

				if (building == -1)
					break;

				graph[building].add(i);
				indegree[i]++;
			}
		}

		topologySort();
		for (int i = 1; i <= N; i++)
			System.out.println(result[i]);

	}

	// ���� ����
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<Integer>();

		// �ʱ� ���� : �������� 0�� ��� ť�� ����
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				result[i] = time[i];

				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < graph[curr].size(); i++) {
				int next = graph[curr].get(i);

				result[next] = Integer.max(result[next], result[curr] + time[next]);

				if (--indegree[next] == 0)
					q.offer(next);
			}
		}
	}

}
