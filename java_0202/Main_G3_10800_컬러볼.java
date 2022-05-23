package java_0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_10800_ÄÃ·¯º¼ {

	public static int N;
	public static int[] sumOfColor, result;
	public static Ball[] balls;

	public static class Ball implements Comparable<Ball> {
		int no, C, S;

		public Ball(int no, int C, int S) {
			this.no = no;
			this.C = C;
			this.S = S;
		}

		@Override
		public int compareTo(Ball o) {
			return Integer.compare(this.S, o.S);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		sumOfColor = new int[N + 1];
		balls = new Ball[N];
		result = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int C = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(i + 1, C, S);
		}
		Arrays.sort(balls);

		int index = 0, accumSize = 0;
		for (int i = 0; i < N; i++) {
			Ball ball = balls[i];

			while (balls[index].S < ball.S) {
				accumSize += balls[index].S;
				sumOfColor[balls[index].C] += balls[index].S;
				index++;
			}
			result[ball.no] = accumSize - sumOfColor[ball.C];
		}

		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append("\n");
		}

		System.out.println(sb);
	}

}
