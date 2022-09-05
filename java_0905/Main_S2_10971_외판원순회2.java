package java_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_10971_외판원순회2 {

	public static int N, min = Integer.MAX_VALUE;
	public static int[][] W;
	public static boolean[] visited, isStart;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		W = new int[N][N];
		visited = new boolean[N];
		isStart = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isStart[0] = true;
//		visited[0] = true;
		dfs(0, 0, 0);

		System.out.println(min);
	}

	public static void dfs(int city, int cnt, int cost) {
		if (cnt >= N && isStart[city]) {
			min = Integer.min(min, cost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[city] && W[city][i] > 0) {
				visited[city] = true;
				dfs(i, cnt + 1, cost + W[city][i]);
				visited[city] = false;
			}
		}
	}

}
