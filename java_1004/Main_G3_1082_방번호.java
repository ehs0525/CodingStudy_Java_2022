package java_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_1082_���ȣ {

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

		// 1. ���ڸ� �ִ��� ��� �����.
		// => �� ���ڸ� ���� ���. 0�̸� �� ��°�� �� ���ڸ� �ϳ� ��� 0���� ä���.
		// 2. ū ���ϼ��� �տ� �־�� �Ѵ�.
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

		// ū ������ �ٲ� �� ������ �ٲ۴�.
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
