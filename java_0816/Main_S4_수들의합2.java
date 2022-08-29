package java_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_수들의합2 {

	public static int N, M;
	public static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		int s = 1, e = 1, sum = 0, cnt = 0;
		while (true) {
			if (sum >= M) {
				sum -= A[s++];
			} else {
				if (e > N)
					break;
				sum += A[e++];
			}

			if (sum == M)
				cnt++;
		}
		System.out.println(cnt);
	}

}
