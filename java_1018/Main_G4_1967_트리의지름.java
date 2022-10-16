package java_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1967_트리의지름 {

	static int n;
	static int[] d;
	static ArrayList<Node>[] tree;

	static class Node {
		int num, weight;

		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			tree[parent].add(new Node(child, weight));
			tree[child].add(new Node(parent, weight));
		}

		int endPoint1 = bfs(1);
		int endPoint2 = bfs(endPoint1);
		System.out.println(d[endPoint2]);
	}

	private static int bfs(int root) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		d = new int[n + 1];

		q.offer(new Node(root, 0));
		visited[root] = true;

		int max = 0;
		int maxIdx = root;
		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int i = 0; i < tree[curr.num].size(); i++) {
				Node next = tree[curr.num].get(i);

				if (!visited[next.num]) {
					q.offer(next);
					visited[next.num] = true;

					d[next.num] = d[curr.num] + next.weight;
					if (d[next.num] > max) {
						max = d[next.num];
						maxIdx = next.num;
					}
				}
			}
		}

		return maxIdx;
	}

}
