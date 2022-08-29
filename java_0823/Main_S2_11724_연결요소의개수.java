package java_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_11724_연결요소의개수 {

	public static int N, M, cnt = 0;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt++;
				bfs(i);
			}
		}
		
		System.out.println(cnt);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < graph[curr].size(); i++) {
				int next = graph[curr].get(i);

				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}

}
