package java_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G3_11437_LCA {

	public static int N, M;
	public static ArrayList<Integer>[] tree;
	public static int[] parent, depth;
	public static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		tree = new ArrayList[N + 1];
		parent = new int[N + 1];
		depth = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			tree[v1].add(v2);
			tree[v2].add(v1);
		}

		dfs(1, 0);

		M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			System.out.println(lca(v1, v2));
		}
	}

	public static void dfs(int v, int d) {
		depth[v] = d;
		visited[v] = true;

		for (int i = 0; i < tree[v].size(); i++) {
			int nv = tree[v].get(i);

			if (visited[nv])
				continue;

			parent[nv] = v;
			dfs(nv, d + 1);
		}
	}

	public static int lca(int v1, int v2) {
		while (depth[v1] != depth[v2]) {
			if (depth[v1] > depth[v2])
				v1 = parent[v1];
			else
				v2 = parent[v2];
		}

		while (v1 != v2) {
			v1 = parent[v1];
			v2 = parent[v2];
		}

		return v1;
	}

}
