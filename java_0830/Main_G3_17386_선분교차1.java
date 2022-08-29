package java_0830;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_17386_선분교차1 {

	public static Line[] L = new Line[3];

	public static class Line {
		Point s, e;

		public Line(Point s, Point e) {
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 2; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			L[i] = new Line(new Point(x1, y1), new Point(x2, y2));
		}

		if (intersect())
			System.out.println(1);
		else
			System.out.println(0);
	}

	public static boolean intersect() {
		return ccw(L[1].s, L[1].e, L[2].s) * ccw(L[1].s, L[1].e, L[2].e) < 0
				&& ccw(L[2].s, L[2].e, L[1].s) * ccw(L[2].s, L[2].e, L[1].e) < 0;
	}

	public static long ccw(Point p1, Point p2, Point p3) {
		long a = p2.x - p1.x;
		long b = p2.y - p1.y;
		long c = p3.x - p1.x;
		long d = p3.y - p1.y;

		// return a * d - b * c; 로 하니 intersect()에서 overflow
		if (a * d - b * c > 0)
			return 1;
		else
			return -1;
	}
}
