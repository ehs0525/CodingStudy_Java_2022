package java_0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G3_2143_두배열의합 {

	public static int T, n, m;
	public static int[] A, B;
	public static ArrayList<Integer> subASum = new ArrayList<>();
	public static ArrayList<Integer> subBSum = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(in.readLine());
		n = Integer.parseInt(in.readLine());
		A = new int[n + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(in.readLine());
		B = new int[m + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = i; j <= n; j++) {
				sum += A[j];
				subASum.add(sum);
			}
		}
		for (int i = 1; i <= m; i++) {
			int sum = 0;
			for (int j = i; j <= m; j++) {
				sum += B[j];
				subBSum.add(sum);
			}
		}

		Collections.sort(subASum);
		Collections.sort(subBSum);

		System.out.println(countPairs());
	}

	public static long countPairs() {
		long cnt = 0;

		int p1 = 0, p2 = subBSum.size() - 1;
		while (p1 < subASum.size() && p2 >= 0) {
			long a = subASum.get(p1);
			long b = subBSum.get(p2);

			
			if (a + b < T) {
				p1++;
			} else if (a + b == T) {
				long temp1 = p1, temp2 = p2;
				while (p1 < subASum.size() && subASum.get(p1) == a)
					p1++;
				while (p2 >= 0 && subBSum.get(p2) == b)
					p2--;

				cnt += (p1 - temp1) * (temp2 - p2);
			} else if (a + b > T) {
				p2--;
			}
		}

		return cnt;
	}

}
