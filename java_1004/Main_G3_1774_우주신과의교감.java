package java_1004;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G3_1774_우주신과의교감 {

	static int N, M;
	static int[] parent;
	static Point[] coords;
	static ArrayList<Edge> edgeList = new ArrayList<>();

	static class Edge implements Comparable<Edge> {
		int nodeA, nodeB;
		double dist;

		public Edge(int nodeA, int nodeB, double dist) {
			super();
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		coords = new Point[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;

			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			coords[i] = new Point(x, y);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;

				double dist = getDistance(coords[i], coords[j]);
				edgeList.add(new Edge(i, j, dist));
			}
		}
		Collections.sort(edgeList);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);
		}
		
		double ans = 0;
		for(int i=0;i<edgeList.size();i++) {
			Edge edge = edgeList.get(i);
			
			if(find(edge.nodeA) != find(edge.nodeB)) {
				union(edge.nodeA, edge.nodeB);
				ans += edge.dist;
			}
		}
		
		System.out.println(String.format("%.2f", ans));
	}

	private static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;

	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

}
