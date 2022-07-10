package java_0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G2_1079_마피아 {

	public static int N, Eunjin, max = 0;
	public static int[] guilt;
	public static boolean[] isAlive;
	public static int[][] R;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		guilt = new int[N];
		isAlive = new boolean[N];
		R = new int[N][N];

		Arrays.fill(isAlive, true);

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			guilt[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Eunjin = Integer.parseInt(in.readLine());

		play(N, 0);
		System.out.println(max);
	}

	public static void play(int alive, int night) {
		if (!isAlive[Eunjin] || alive <= 1) {
			max = Integer.max(max, night);
			return;
		}

		// 밤에는
		if (alive % 2 == 0) {

			// 마피아가 죽일 사람을 한 명 고른다.
			for (int i = 0; i < N; i++) {
				if (i == Eunjin || !isAlive[i])
					continue;

				isAlive[i] = false;
				// 각 사람의 유죄 지수가 바뀐다.
				for (int j = 0; j < N; j++) {
					if (!isAlive[j])
						continue;
					guilt[j] += R[i][j];
				}

				play(alive - 1, night + 1);

				for (int j = 0; j < N; j++) {
					if (!isAlive[j])
						continue;
					guilt[j] -= R[i][j];
				}
				isAlive[i] = true;
			}
		} else { // 낮에는
			int guiltiest = getGuiltiestPlayer();

			isAlive[guiltiest] = false;
			play(alive - 1, night);
			isAlive[guiltiest] = true;
		}
	}

	public static int getGuiltiestPlayer() {
		int max = 299, idx = 0;

		for (int i = 0; i < N; i++) {
			if (!isAlive[i])
				continue;

			if (guilt[i] > max) {
				max = guilt[i];
				idx = i;
			}
		}

		return idx;
	}

}
