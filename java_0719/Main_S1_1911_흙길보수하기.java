package java_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1911_흙길보수하기 {

	public static int N, L;
	public static Puddle[] puddles;

	public static class Puddle implements Comparable<Puddle> {
		int start, end;

		public Puddle(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Puddle o) {
			if (this.start == o.start)
				return Integer.compare(this.end, o.end);
			return Integer.compare(this.start, o.start);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		puddles = new Puddle[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			puddles[i] = new Puddle(start, end);
		}

		Arrays.sort(puddles);

		int cnt = 0, max = 0;
		for (int i = 0; i < N; i++) {
			if (puddles[i].start > max)
				max = puddles[i].start;

			while (max < puddles[i].end) {
				max += L;
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
