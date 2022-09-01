package java_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_15681_Æ®¸®¿ÍÄõ¸® {

	public static int N, R, Q;
	public static ArrayList<Integer>[] tree;
	public static int[] childCnt;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();
		childCnt = new int[N + 1];
		Arrays.fill(childCnt, 1);
		visited = new boolean[N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			tree[u].add(v);
			tree[v].add(u);
		}

		visited[R] = true;
		dfs(R);
		for (int i = 0; i < Q; i++) {
			int u = Integer.parseInt(in.readLine());
			System.out.println(childCnt[u]);
		}
	}

	public static void dfs(int v) {
		for (int next : tree[v]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next);

				childCnt[v] += childCnt[next];
			}
		}
	}

}
