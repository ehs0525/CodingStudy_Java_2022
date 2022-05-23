package java_0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1976_여행가자 {

	public static int N, M, A, B;
	public static int[] parentOf, travelPlan;
	public static int[][] connected;

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parentOf[b] = a;
		} else {
			parentOf[a] = b;
		}
	}

	public static int find(int x) {
		if (x == parentOf[x])
			return x;
		return parentOf[x] = find(parentOf[x]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		parentOf = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parentOf[i] = i;
		}
		travelPlan = new int[M];
		connected = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				connected[i][j] = Integer.parseInt(st.nextToken());
				if (connected[i][j] == 1) {
					union(i, j);
				}
			}
		}

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			travelPlan[i] = Integer.parseInt(st.nextToken());
		}

		int parent = find(travelPlan[0]);
		for (int i = 1; i < M; i++) {
			if (parent != find(travelPlan[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
