package java_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15649_N°úM1 {

	public static int N, M;
	public static boolean[] isSelected;
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		isSelected = new boolean[N + 1];
		num = new int[M];
		perm(0);

	}

	private static void perm(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				num[idx] = i;
				perm(idx + 1);
				isSelected[i] = false;
			}
		}
	}

}
