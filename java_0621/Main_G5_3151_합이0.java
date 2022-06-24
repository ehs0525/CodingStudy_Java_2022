package java_0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_3151_гуюл0 {

	public static int N;
	public static long ans = 0L;
	public static int[] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		for (int first = 0; first < N; first++) {
			if (A[first] > 0)
				break;
			int second = first + 1;
			int third = N - 1;

			while (second < third) {
				int sum = A[first] + A[second] + A[third];

				if (sum == 0) {
					if (A[second] == A[third]) {
						ans += (third - second + 1) * (third - second) / 2;
						break;
					}

					int tempSecond = second, tempThird = third;
					while (second + 1 < third && A[second] == A[second + 1])
						second++;
					while (second < third - 1 && A[third - 1] == A[third])
						third--;

					ans += (second - tempSecond + 1) * (tempThird - third + 1);
				}

				if (sum < 0) {
					second++;
				} else {
					third--;
				}
			}
		}

		System.out.println(ans);
	}

}
