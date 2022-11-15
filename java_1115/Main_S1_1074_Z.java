package java_1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1074_Z {

	static int N, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(z((int) Math.pow(2, N), r, c));
	}

	private static int z(int n, int x, int y) {
		if (n == 1)
			return 0;

		int mid = n / 2;
		if (x < mid && y < mid) { // ÁÂ»ó
			return z(mid, x, y);
		} else if (x < mid && y >= mid) { // ¿ì»ó
			return mid * mid + z(mid, x, y - mid);
		} else if (x >= mid && y < mid) { // ÁÂÇÏ
			return 2 * mid * mid + z(mid, x - mid, y);
		} else { // ¿ìÇÏ
			return 3 * mid * mid + z(mid, x - mid, y - mid);
		}
	}

}
