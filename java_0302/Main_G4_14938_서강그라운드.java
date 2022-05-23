package java_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_14938_서강그라운드 {

	public static final int INF = (int) 1e9;
	public static int n, m, r, a, b, l, result = Integer.MIN_VALUE;
	public static int[] t, d;
	public static ArrayList<Region>[] regionList;

	public static class Region implements Comparable<Region> {
		int index, dist;

		public Region(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}

		@Override
		public int compareTo(Region o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		t = new int[n + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		regionList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			regionList[i] = new ArrayList<>();
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			regionList[a].add(new Region(b, l));
			regionList[b].add(new Region(a, l));
		}

		d = new int[n + 1];

		// 이 때 느꼈다.. 플로이드-와샬로 풀 걸..
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d, INF);
			result = Integer.max(result, dijkstra(i));
		}

		System.out.println(result);
	}

	public static int dijkstra(int droppedArea) {
		PriorityQueue<Region> pq = new PriorityQueue<>();

		pq.offer(new Region(droppedArea, 0));
		d[droppedArea] = 0;

		while (!pq.isEmpty()) {
			Region curr = pq.poll();

			if (curr.dist <= d[curr.index]) {
				for (Region next : regionList[curr.index]) {
					int nextD = d[curr.index] + next.dist;

					if (nextD < d[next.index]) {
						pq.offer(new Region(next.index, nextD));
						d[next.index] = nextD;
					}
				}
			}
		}

		int item = 0;
		for (int i = 1; i <= n; i++) {
			if (d[i] <= m) {
				item += t[i];
			}
		}
		return item;
	}

}
