package java_1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1253_¡¡¥Ÿ {

	static int N;
	static int[] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int l = 0, r = N - 1;

			while (l < r) {
				if (l == i) {
					l++;
					continue;
				}
				if (r == i) {
					r--;
					continue;
				}

				if (A[l] + A[r] < A[i]) {
					l++;
				} else if (A[l] + A[r] > A[i]) {
					r--;
				} else {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
