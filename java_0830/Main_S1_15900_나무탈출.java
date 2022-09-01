package java_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S1_15900_³ª¹«Å»Ãâ {

	public static int N, depthSum = 0;
	public static boolean[] visited;
	public static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		getDepthSum(1, 0);
		if (depthSum % 2 == 0)
			System.out.println("No");
		else
			System.out.println("Yes");
	}

	public static void getDepthSum(int x, int depth) {
		if (x != 1 && tree[x].size() == 1) {
			depthSum += depth;
			return;
		}

		visited[x] = true;
		for (int i = 0; i < tree[x].size(); i++) {
			int y = tree[x].get(i);

			if (visited[y])
				continue;
			getDepthSum(y, depth + 1);
		}
	}
}
