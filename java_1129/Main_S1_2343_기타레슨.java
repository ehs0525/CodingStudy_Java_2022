package java_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2343_±‚≈∏∑πΩº {

	static int N, M;
	static int[] lecture;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lecture = new int[N];
		int sum = 0;
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			sum += lecture[i];
		}

		int start = 1, end = sum, result = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (getNumOfBlurays(mid) > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
				result = mid;
			}
		}

		System.out.println(result);
	}

	private static int getNumOfBlurays(int size) {
		int sum = 0, cnt = 1;
		for (int i = 0; i < N; i++) {
			if (lecture[i] > size)
				return M + 1;
			if (sum + lecture[i] > size) {
				cnt++;
				sum = lecture[i];
			} else {
				sum += lecture[i];
			}
		}

		return cnt;
	}

}
