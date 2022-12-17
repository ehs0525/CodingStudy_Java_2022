package java_1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G3_1238_ÆÄÆ¼ {

	static final int INF = (int) 1e9;
	static int N, M, X;
	static ArrayList<Road>[] graph1, graph2;
	static int[] d1, d2;

	static class Road implements Comparable<Road> {
		int end, time;

		public Road(int end, int time) {
			super();
			this.end = end;
			this.time = time;
		}

		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		graph1 = new ArrayList[N + 1];
		graph2 = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph1[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}

		d1 = new int[N + 1];
		d2 = new int[N + 1];
		Arrays.fill(d1, INF);
		Arrays.fill(d2, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			graph1[A].add(new Road(B, T));
			graph2[B].add(new Road(A, T));
		}

		dijkstra(X, graph1, d1);
		dijkstra(X, graph2, d2);

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Integer.max(max, d1[i] + d2[i]);
		}

		System.out.println(max);
	}

	private static void dijkstra(int start, ArrayList<Road>[] graph, int[] d) {
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.offer(new Road(start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) {
			Road curr = pq.poll();

			if (curr.time > d[curr.end])
				continue;
			for (int i = 0; i < graph[curr.end].size(); i++) {
				int ne = graph[curr.end].get(i).end;
				int nt = d[curr.end] + graph[curr.end].get(i).time;

				if (nt < d[ne]) {
					pq.offer(new Road(ne, nt));
					d[ne] = nt;
				}
			}
		}
	}

}
