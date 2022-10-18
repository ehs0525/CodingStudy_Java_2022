package java_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2512_예산 {

	static int N, M;
	static int[] request;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		request = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int max = 0;
		for (int i = 0; i < N; i++) {
			request[i] = Integer.parseInt(st.nextToken());
			max = Integer.max(max, request[i]);
		}
		M = Integer.parseInt(in.readLine());

		int s = 1, e = max, result = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (distribute(mid) <= M) {	// 예산이 넉넉할 경우
				result = mid;	// 최대한 배정했을 때가 정답
				s = mid + 1;
			} else {	// 예산이 부족할 경우
				e = mid - 1;
			}
		}
		
		System.out.println(result);
	}

	private static int distribute(int upperLimit) {	// 상한액에 따른 배정액의 합
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += Integer.min(request[i], upperLimit);
		}

		return sum;
	}

}
