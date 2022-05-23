package java_0419;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_10655_∏∂∂Û≈Ê1 {

	public static int N, dist = 0, maxDiff = 0;
	public static Point[] checkpoints;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		checkpoints = new Point[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			checkpoints[i] = new Point(x, y);
		}

		for (int i = 2; i < N; i++) {
			int diff = getManhattanDistance(checkpoints[i - 1], checkpoints[i])
					+ getManhattanDistance(checkpoints[i], checkpoints[i + 1])
					- getManhattanDistance(checkpoints[i - 1], checkpoints[i + 1]);
			maxDiff = Integer.max(maxDiff, diff);
		}

		for (int i = 1; i < N; i++)
			dist += getManhattanDistance(checkpoints[i], checkpoints[i + 1]);
		dist -= maxDiff;
		
		System.out.println(dist);
	}

	public static int getManhattanDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}
