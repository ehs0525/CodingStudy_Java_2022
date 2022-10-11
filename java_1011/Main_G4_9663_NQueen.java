package java_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G4_9663_NQueen {

	static int N, cnt = 0;
	static boolean[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		board = new boolean[N][N];

		NQueen(0);
		System.out.println(cnt);
	}

	private static void NQueen(int idx) {
		if (idx >= N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!canAttack(idx, i)) {
				board[idx][i] = true;
				NQueen(idx + 1);
				board[idx][i] = false;
			}
		}
	}

	private static boolean canAttack(int x, int y) {
		// 위로만 체크
		// \ 대각선
		int tx = x;
		int ty = y;
		while (tx - 1 >= 0 && ty - 1 >= 0) {
			if (board[--tx][--ty])
				return true;
		}

		// 열
		tx = x;
		ty = y;
		while (tx - 1 >= 0) {
			if (board[--tx][ty])
				return true;
		}

		// / 대각선
		tx = x;
		ty = y;
		while (tx - 1 >= 0 && ty + 1 < N) {
			if (board[--tx][++ty])
				return true;
		}

		return false;
	}

}
