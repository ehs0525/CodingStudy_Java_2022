package java_0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1753_최단경로 {

	public static final int INF = (int) 1e9;

	public static int V, E, K;
	public static ArrayList<Node>[] graph;
	public static int[] d;

	public static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		d = new int[V + 1];
		Arrays.fill(d, INF);

		K = Integer.parseInt(in.readLine());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}

		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if (d[i] < INF) {
				System.out.println(d[i]);
			} else {
				System.out.println("INF");
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (curr.w > d[curr.v])
				continue;

			for (int i = 0; i < graph[curr.v].size(); i++) {
				int nv = graph[curr.v].get(i).v;
				int nw = curr.w + graph[curr.v].get(i).w;

				if (nw < d[nv]) {
					pq.offer(new Node(nv, nw));
					d[nv] = nw;
				}
			}
		}
	}

}
