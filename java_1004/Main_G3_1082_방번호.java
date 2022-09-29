package java_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_1082_방번호 {

	static int N, M;
	static int[] P;
	static Num[] nums;

	static class Num implements Comparable<Num> {
		int n, p;

		public Num(int n, int p) {
			super();
			this.n = n;
			this.p = p;
		}

		@Override
		public int compareTo(Num o) {
			if (this.p == o.p)
				return o.p - this.p;
			return Integer.compare(this.p, o.p);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] roomNum = new char[50];
		int len = 0;

		N = Integer.parseInt(in.readLine());
		P = new int[N];
		nums = new Num[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			nums[i] = new Num(i, P[i]);
		}
		M = Integer.parseInt(in.readLine());

		// 1. 숫자를 최대한 길게 만든다.
		// => 싼 숫자를 많이 산다. 0이면 두 번째로 싼 숫자를 하나 사고 0으로 채운다.
		// 2. 큰 수일수록 앞에 있어야 한다.
		Arrays.sort(nums);
		if (nums[0].n == 0) {
			if (N == 1 || nums[1].p > M) {
				System.out.println(0);
				return;
			}
			roomNum[len++] = Character.forDigit(nums[1].n, 10);
			M -= nums[1].p;
		}
		while (M - nums[0].p >= 0) {
			roomNum[len++] = Character.forDigit(nums[0].n, 10);
			M -= nums[0].p;
		}

		// 큰 수부터 바꿀 수 있으면 바꾼다.
		for (int i = 0; i < len; i++) {
			int n = roomNum[i] - '0';
			for (int j = N - 1; j >= 0; j--) {
				if (i == 0 && j == 0)
					continue;
				int m = M + P[n] - P[j];
				if (m >= 0) {
					roomNum[i] = Character.forDigit(j, 10);
					M = m;
					break;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			System.out.print(roomNum[i]);
		}
	}

}
