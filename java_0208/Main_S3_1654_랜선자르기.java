package java_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_1654_랜선자르기 {

	public static int K, N;
	public static long left, right, mid, count, max = 0;
	public static long[] lan;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new long[K];
		for (int i = 0; i < K; i++) {
			lan[i] = Long.parseLong(in.readLine());
		}
		Arrays.sort(lan);

		left = 1L;
		right = lan[lan.length - 1];
		while (left <= right) {
			mid = (left + right) / 2;
			count = 0;
			for (long l : lan) {
				count += l / mid;
			}

			if (count >= N) {
				left = mid + 1;
				max = Long.max(max, mid);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(max);
	}

}
