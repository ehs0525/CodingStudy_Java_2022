package java_0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_1916_�ּҺ�뱸�ϱ� {

	public static int INF = (int) 1e9;
	public static int N, M, A, B;
	public static ArrayList<Route>[] routes;
	public static int[] d;

	public static class Route implements Comparable<Route> {
		int dest, fare;

		public Route(int dest, int fare) {
			this.dest = dest;
			this.fare = fare;
		}

		@Override
		public int compareTo(Route o) {
			return Integer.compare(this.fare, o.fare);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		routes = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			routes[i] = new ArrayList<>();
		}
		d = new int[N + 1];
		Arrays.fill(d, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			routes[from].add(new Route(to, cost));
		}

		st = new StringTokenizer(in.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		dijkstra(A);
		System.out.println(d[B]);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Route> pq = new PriorityQueue<>();
		// ���� ���� ���� ���� �ִ� ��δ� 0���� ���� �� �켱���� ť�� ����
		pq.add(new Route(start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) { // ť�� �� ������
			Route curr = pq.poll();
			int dest = curr.dest;
			int fare = curr.fare;

			if (d[dest] < fare)
				continue; // ���� ��尡 �̹� ó���� ���� �ִ� ����� ����

			for (Route route : routes[dest]) {
				int cost = d[dest] + route.fare;

				if (cost < d[route.dest]) {
					d[route.dest] = cost;
					pq.offer(new Route(route.dest, cost));
				}
			}
		}
	}

}
