package java_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_24884_장작넣기 {

	public static int N, W, T, K, ans = 0;
	public static int[] F;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		F = new int[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			F[i] = Integer.parseInt(st.nextToken());

		putFirewood(1, W);

		System.out.println(ans);
	}

	public static void putFirewood(int time, int idx) {

		int[] adjFires = new int[N];

		// 화력 감소
		for (int i = 0; i < N; i++) {
			if (time > 1 && i == idx) {
				adjFires[i] = 3;
				continue;
			}

			adjFires[i] = countAdjFires(i);
		}

		for (int i = 0; i < N; i++)
			F[i] -= 3 - adjFires[i];

		// 놀이 종료
		if (time >= T) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (F[i] > 0)
					cnt++;
			}

			if (cnt >= K)
				ans++;

			for (int i = 0; i < N; i++)
				F[i] += 3 - adjFires[i];
			return;
		}

		if (idx - 1 >= 0)
			putFirewood(time + 1, idx - 1);
		putFirewood(time + 1, idx);
		if (idx + 1 < N)
			putFirewood(time + 1, idx + 1);

		for (int i = 0; i < N; i++)
			F[i] += 3 - adjFires[i];
	}

	public static int countAdjFires(int idx) {
		int cnt = 0;
		if (idx - 1 >= 0 && F[idx - 1] > 0)
			cnt++;
		if (idx + 1 < N && F[idx + 1] > 0)
			cnt++;
		return cnt;
	}
}
