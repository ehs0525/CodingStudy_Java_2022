package java_0628;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_8982_¼öÁ·°ü1 {

	public static int N, A, K, water = 0;
	public static int[] surface = new int[40000];
	public static int[] floor = new int[40000];
	public static Point[] holes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());

		in.readLine();
		for (int i = 0; i < (N - 2) / 2; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());

			for (int j = a; j < c; j++)
				floor[j] = b;
		}
		st = new StringTokenizer(in.readLine(), " ");
		A = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(in.readLine());
		holes = new Point[K];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			holes[i] = new Point(a, b);
		}

		for (int i = 0; i < K; i++) {
			drainLeft(holes[i]);
			drainRight(holes[i]);
		}

		for (int i = 0; i < A; i++)
			water += floor[i] - surface[i];

		System.out.println(water);
	}

	private static void drainLeft(Point hole) {
		int shallowest = hole.y;

		for (int i = hole.x; i >= 0; i--) {
			shallowest = Integer.min(shallowest, floor[i]);
			if (surface[i] < shallowest)
				surface[i] = shallowest;
		}
	}

	private static void drainRight(Point hole) {
		int shallowest = hole.y;

		for (int i = hole.x; i < A; i++) {
			shallowest = Integer.min(shallowest, floor[i]);
			if (surface[i] < shallowest)
				surface[i] = shallowest;
		}
	}

}
