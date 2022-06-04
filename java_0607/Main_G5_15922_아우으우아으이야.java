package java_0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_15922_아우으우아으이야 {

	public static int N, x, y, maxY = Integer.MIN_VALUE, len = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (x <= maxY && y <= maxY)
				continue;
			if (x <= maxY && maxY < y) {
				len += y - maxY;
			} else if (maxY < x) {
				len += y - x;
			}

			maxY = y;
		}

		System.out.println(len);
	}

}
