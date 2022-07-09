package java_0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15652_N°úM4 {

	public static int N, M;
	public static int[] choosed;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		choosed = new int[M];

		choose(1, 0);
	}

	public static void choose(int num, int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(choosed[i] + " ");
			}
			System.out.println();

			return;
		}

		for (int i = num; i <= N; i++) {
			choosed[idx] = i;
			choose(i, idx + 1);
		}

	}

}
