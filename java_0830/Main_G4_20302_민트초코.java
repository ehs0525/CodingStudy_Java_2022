package java_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_20302_¹ÎÆ®ÃÊÄÚ {

	public static int N;
	public static int[] primeCnt = new int[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int num = Integer.parseInt(st.nextToken());
		if (num == 0) {
			System.out.println("mint chocolate");
			return;
		}
		countPrimes(Math.abs(num));

		for (int i = 0; i < N - 1; i++) {
			char op = st.nextToken().charAt(0);
			int j = Integer.parseInt(st.nextToken());

			if (op == '*') {
				if (j == 0) {
					System.out.println("mint chocolate");
					return;
				}
				countPrimes(Math.abs(j));
			} else if (op == '/') {
				subtractPrimes(Math.abs(j));
			}
		}

		for (int i = 2; i < primeCnt.length; i++) {
			if (primeCnt[i] < 0) {
				System.out.println("toothpaste");
				return;
			}
		}
		System.out.println("mint chocolate");
	}

	public static void subtractPrimes(int n) {
		int m = (int) Math.sqrt(n);
		for (int i = 2; i <= m; i++) {
			while (n % i == 0) {
				primeCnt[i]--;
				n /= i;
			}
		}
		if (n > 1)
			primeCnt[n]--;
	}

	public static void countPrimes(int n) {
		int m = (int) Math.sqrt(n);
		for (int i = 2; i <= m; i++) {
			while (n % i == 0) {
				primeCnt[i]++;
				n /= i;
			}
		}
		if (n > 1)
			primeCnt[n]++;
	}

}
