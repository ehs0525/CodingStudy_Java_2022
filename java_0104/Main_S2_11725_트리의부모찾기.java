package java_0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_11725_트리의부모찾기 {

	public static int N;
	public static ArrayList<Integer>[] tree;
	public static int[] parentOf;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		parentOf = new int[N + 1];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			tree[v1].add(v2);
			tree[v2].add(v1);
		}

		bfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(parentOf[i]);
		}
	}

	public static void bfs(int root) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(root);
		parentOf[root] = root;

		while (!q.isEmpty()) {
			int parent = q.poll();

			for (int i = 0; i < tree[parent].size(); i++) {
				int child = tree[parent].get(i);

				if (parentOf[child] == 0) {
					q.offer(child);
					parentOf[child] = parent;
				}
			}
		}
	}

}
