package java_0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_3273_두수의합 {

	public static int n, x, s, e, cnt = 0;
	public static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		a = new int[n + 1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(in.readLine());
		s = 1;
		e = n;

		Arrays.sort(a);
		while (s < e) {
			int sum = a[s] + a[e];

			if (sum == x) {
				cnt++;
				s++;
				e--;
			} else if (sum < x)
				s++;
			else if (sum > x)
				e--;
		}

		System.out.println(cnt);
	}

}
