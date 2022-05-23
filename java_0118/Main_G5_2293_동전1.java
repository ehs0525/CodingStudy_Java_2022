package java_0118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_2293_µ¿Àü1 {

	public static int n, k;
	public static int[] coin, d;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		d = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		d[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j - coin[i] >= 0)

					d[j] += d[j - coin[i]];
			}
		}

		System.out.println(d[k]);
	}

}
