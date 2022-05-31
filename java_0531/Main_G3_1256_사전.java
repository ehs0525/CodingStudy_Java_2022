package java_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_1256_사전 {

	public static int N, M, K, idx = 0;
	public static char[] str;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		str = new char[N + M];
		for (int i = 0; i < N; i++)
			str[i] = 'a';
		for (int i = N; i < N + M; i++)
			str[i] = 'z';

//		if (nCr(N + M, N) < K) {
//			System.out.println(-1);
//			return;
//		}

		do {
			if (++idx == K) {
				System.out.println(str);
				return;
			}
		} while (np());

	}

	public static boolean np() {
		int N = str.length;

		// Step 1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && str[i - 1] >= str[i])
			i--;
		if (i == 0)
			return false;

		// Step 2. i-1 과 swap할 큰 값 찾기
		int j = N - 1;
		while (str[i - 1] >= str[j])
			j--;

		// Step 3. swap
		swap(i - 1, j);

		// Step 4. sort
		int k = N - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;

	}

}
