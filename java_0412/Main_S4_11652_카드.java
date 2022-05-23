package java_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_11652_카드 {

	public static int N, max, cnt;
	public static long ans;
	public static long[] card;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 계수 정렬을 쓰려 했으나 가능 value가 음수도 있고 범위가 너무 넓다.

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		card = new long[N];
		for (int i = 0; i < N; i++) {
			card[i] = Long.parseLong(in.readLine());
		}

		Arrays.sort(card);

		ans = card[0]; // 가장 많이 가지고 있는 정수
		max = 1; // 연속으로 나온 횟수 최대
		cnt = 1; // 현재 연속으로 나온 횟수
		for (int i = 1; i < N; i++) {
			if (card[i] == card[i - 1]) {
				if (++cnt > max) {
					max = cnt;
					ans = card[i];
				}
			} else {
				cnt = 1;
			}
		}

		System.out.println(ans);
	}

}
