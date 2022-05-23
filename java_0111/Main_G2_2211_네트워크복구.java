package java_0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G2_2211_네트워크복구 {

	public static class Edge implements Comparable<Edge> {
		int src, dest, time;

		public Edge(int src, int dest, int time) {
			this.src = src;
			this.dest = dest;
			this.time = time;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static int INF = (int) 1e9;
	public static int N, M, A, B, C;
	public static ArrayList<Edge>[] edges;
	public static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		d = new int[N + 1];
		Arrays.fill(d, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			edges[A].add(new Edge(A, B, C));
			edges[B].add(new Edge(B, A, C));
		}

		System.out.println(N - 1);
		dijkstra(1);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int prev = edge.src;
			int curr = edge.dest;
			int dist = edge.time;

			if (d[curr] < dist)
				continue;

			if (prev != 0) {
				System.out.println(prev + " " + curr);
			}

			for (Edge e : edges[curr]) {
				int cost = d[curr] + e.time;

				if (cost < d[e.dest]) {
					d[e.dest] = cost;
					pq.offer(new Edge(curr, e.dest, cost));
				}
			}
		}
	}

}
