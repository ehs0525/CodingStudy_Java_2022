package java_0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1043_°ÅÁþ¸» {

	public static int N, M;
	public static boolean[] knows;
	public static boolean[][] comes;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		knows = new boolean[N + 1];
		comes = new boolean[M][N + 1];

		st = new StringTokenizer(in.readLine(), " ");
		int num1 = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num1; i++) {
			knows[Integer.parseInt(st.nextToken())] = true;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int num2 = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num2; j++) {
				comes[i][Integer.parseInt(st.nextToken())] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (knows[i]) {
				dfs(i);
			}
		}

		int ans = M;
		for (int i = 0; i < M; i++) {
			for (int j = 1; j <= N; j++) {
				if (comes[i][j] && knows[j]) {
					ans--;
					break;
				}
			}
		}

		System.out.println(ans);
	}

	public static void dfs(int x) {
		for (int i = 0; i < M; i++) {
			if (comes[i][x]) {
				for (int j = 1; j <= N; j++) {
					if (j == x)
						continue;

					if (comes[i][j] && !knows[j]) {
						knows[j] = true;
						dfs(j);
					}
				}
			}
		}

	}

}
