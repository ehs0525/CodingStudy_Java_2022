package java_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_16202_MST∞‘¿” {

	static int N, M, K, cnt;
	static int[] parent;
	static ArrayList<Edge> edges = new ArrayList<>();

	static class Edge implements Comparable<Edge> {
		int x, y, weight;

		public Edge(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			edges.add(new Edge(x, y, i));
		}

		Collections.sort(edges);

		for (int i = 0; i < K; i++) {
			cnt = 0;
			int cost = kruskal();

			if (cnt == N - 1) {
				System.out.print(cost + " ");
				edges.remove(0);
			} else {
				for (int j = 0; j < K - i; j++) {
					System.out.print("0 ");
				}
				break;
			}
		}
	}

	private static int kruskal() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int sum = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			int x = edge.x;
			int y = edge.y;
			int w = edge.weight;

			if (findParent(x) != findParent(y)) {
				unionParent(x, y);
				sum += w;
				cnt++;
			}
		}

		return sum;
	}

	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	private static int findParent(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findParent(parent[x]);
	}

}
