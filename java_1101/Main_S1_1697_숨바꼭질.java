package java_1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S1_1697_¼û¹Ù²ÀÁú {

	static final int INF = (int) 1e9;

	static int N, K;
	static int[] d = new int[100001];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int idx, dist;

		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Arrays.fill(d, INF);
		for (int i = 0; i <= 100000; i++) {
			graph.add(new ArrayList<Node>());
			if (i - 1 >= 0)
				graph.get(i).add(new Node(i - 1, 1));
			if (i + 1 <= 100000)
				graph.get(i).add(new Node(i + 1, 1));
			if (2 * i <= 100000)
				graph.get(i).add(new Node(2 * i, 1));
		}

		dijkstra(new Node(N, 0));
		System.out.println(d[K]);
	}

	private static void dijkstra(Node start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(start);
		d[start.idx] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (curr.dist > d[curr.idx])
				continue;

			for (int i = 0; i < graph.get(curr.idx).size(); i++) {
				Node next = graph.get(curr.idx).get(i);

				int nd = d[curr.idx] + next.dist;
				if (nd < d[next.idx]) {
					pq.offer(new Node(next.idx, nd));
					d[next.idx] = nd;
				}
			}
		}
	}

}
