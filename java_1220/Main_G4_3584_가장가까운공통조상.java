package java_1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_3584_가장가까운공통조상 {

	static int T, N;
	static ArrayList<Integer>[] tree;
	static int[] depth, parent;
	static boolean[] visited, isRoot;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(in.readLine());
			tree = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				tree[i] = new ArrayList<>();
			}
			depth = new int[N + 1];
			parent = new int[N + 1];
			visited = new boolean[N + 1];
			isRoot = new boolean[N + 1];
			Arrays.fill(isRoot, true);

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				tree[A].add(B);
//				tree[B].add(A);
				isRoot[B] = false;
			}

			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int root = 0;
			for (int i = 1; i <= N; i++) {
				if (isRoot[i]) {
					root = i;
					break;
				}
			}

			dfs(root, 0);
			sb.append(ncs(a, b)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int ncs(int a, int b) {
		while (depth[a] != depth[b]) {
			if (depth[a] > depth[b]) {
				a = parent[a];
			} else {
				b = parent[b];
			}
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}

	private static void dfs(int x, int d) {
		depth[x] = d;
		for (int i = 0; i < tree[x].size(); i++) {
			int child = tree[x].get(i);
			parent[child] = x;

			dfs(child, d + 1);
		}
	}

}
