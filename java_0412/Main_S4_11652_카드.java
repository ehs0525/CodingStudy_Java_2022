package java_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_11652_ī�� {

	public static int N, max, cnt;
	public static long ans;
	public static long[] card;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ��� ������ ���� ������ ���� value�� ������ �ְ� ������ �ʹ� �д�.

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		card = new long[N];
		for (int i = 0; i < N; i++) {
			card[i] = Long.parseLong(in.readLine());
		}

		Arrays.sort(card);

		ans = card[0]; // ���� ���� ������ �ִ� ����
		max = 1; // �������� ���� Ƚ�� �ִ�
		cnt = 1; // ���� �������� ���� Ƚ��
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
