package java_0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1806_ºÎºÐÇÕ {

	public static int N, S;
	public static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		seq = new int[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int e = 0, sum = 0, min = N + 1;
		for (int s = 1; s <= N; s++) {
			sum -= seq[s - 1];

			while (e + 1 <= N && sum < S) {
				sum += seq[++e];
			}

			if (sum >= S) {
				min = Integer.min(min, e - s + 1);
			}
		}

		System.out.println(min);

	}

}
