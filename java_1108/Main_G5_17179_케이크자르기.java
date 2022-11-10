package java_1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17179_케이크자르기 {

	static int N, M, L;
	static int[] S, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		S = new int[M];
		for (int i = 0; i < M; i++) {
			S[i] = Integer.parseInt(in.readLine());
		}

		Q = new int[N];
		for (int i = 0; i < N; i++) {
			Q[i] = Integer.parseInt(in.readLine());
		}

		for (int i = 0; i < N; i++) {
			int s = 0, e = L, max = 0;
			while (s <= e) {
				int mid = (s + e) / 2;

				if (isPromising(mid, Q[i])) { // 모든 조각의 길이가 mid 이상이 되도록 자를 수 있으면
					s = mid + 1;
					max = Integer.max(max, mid);
				} else {
					e = mid - 1;
				}
			}

			System.out.println(max);
		}
	}

	private static boolean isPromising(int min, int cnt) {
		int prev = 0, cutCnt = 0;
		for (int i = 0; i < M; i++) {
			if (S[i] - prev >= min) { // 최대한 많이 잘라본다.
				cutCnt++;
				prev = S[i];
			}
		}

		if (L - prev >= min) {
			if (cutCnt >= cnt)
				return true;
			else
				return false;
		} else if (cutCnt - 1 >= cnt) {
			return true;
		} else
			return false;
	}

}
