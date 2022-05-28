package java_0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Âü°í: lotuslee.tistory.com/108
 * */
public class Main_G5_3020_°³¶Ë¹ú·¹ {

	public static int N, H;
	public static int[] up, down;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		up = new int[H + 2];
		down = new int[H + 2];

		for (int i = 0; i < N; i++) {
			int obstacle = Integer.parseInt(in.readLine());

			if (i % 2 == 0) {
				up[obstacle]++;
			} else {
				down[H - obstacle + 1]++;
			}
		}

		for (int i = H; i >= 1; i--)
			up[i] += up[i + 1];

		for (int i = 1; i <= H; i++)
			down[i] += down[i - 1];

		int min = N, cnt = 0;
		for (int i = 1; i <= H; i++) {
			int num = up[i] + down[i];

			if (min > num) {
				min = num;
				cnt = 1;
			} else if (min == num) {
				cnt++;
			}
		}

		System.out.println(min + " " + cnt);
	}

}
