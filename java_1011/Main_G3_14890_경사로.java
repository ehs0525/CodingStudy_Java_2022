package java_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_14890_경사로 {

	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int[] horiz = new int[N];
			int[] vert = new int[N];

			for (int j = 0; j < N; j++) {
				horiz[j] = map[i][j];
				vert[j] = map[j][i];
			}

			if (canPass(horiz))
				cnt++;
			if (canPass(vert))
				cnt++;
		}

		System.out.println(cnt);
	}

	private static boolean canPass(int[] road) {
		boolean[] ramp = new boolean[road.length];

		int currHeight = road[0];
		for (int i = 1; i < road.length; i++) {
			if (road[i] == currHeight)
				continue;
			if (Math.abs(currHeight - road[i]) >= 2)
				return false;

			// 내리막길
			if (currHeight - road[i] == 1) {
				for (int j = 0; j < L; j++) {
					int ni = i + j;

					if (ni >= road.length || currHeight - road[ni] != 1)
						return false;
					ramp[ni] = true;
				}
				i += L - 1;
			} else if (currHeight - road[i] == -1) { // 오르막길
				for (int j = 1; j <= L; j++) {
					int ni = i - j;

					if (ni < 0 || currHeight != road[ni] || ramp[ni])
						return false;
					ramp[ni] = true;
				}
			}
			currHeight = road[i];
		}

		return true;
	}

}
