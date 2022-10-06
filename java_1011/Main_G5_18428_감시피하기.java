package java_1011;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.sound.midi.SysexMessage;

public class Main_G5_18428_감시피하기 {

	static int N, numOfS;
	static char[][] corridor;
	static boolean[] isSelected;
	static ArrayList<Point> teachers = new ArrayList<>();
	static ArrayList<Point> blanks = new ArrayList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		corridor = new char[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				corridor[i][j] = st.nextToken().charAt(0);

				if (corridor[i][j] == 'T')
					teachers.add(new Point(i, j));
				else if (corridor[i][j] == 'S')
					numOfS++;
				else if (corridor[i][j] == 'X')
					blanks.add(new Point(i, j));
			}
		}

		isSelected = new boolean[blanks.size()];
		comb(0, 0);
		System.out.println("NO");
	}

	private static void comb(int start, int cnt) {
		if (cnt >= 3) {
			if (isPossible()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < blanks.size(); i++) {
			Point blank = blanks.get(i);

			corridor[blank.x][blank.y] = 'O';
			isSelected[i] = true;
			comb(i + 1, cnt + 1);
			corridor[blank.x][blank.y] = 'X';
			isSelected[i] = false;
		}
	}

	private static boolean isPossible() {
		for (Point t : teachers) {
			for (int i = 0; i < 4; i++) {
				int nx = t.x;
				int ny = t.y;

				while (nx >= 1 && nx <= N && ny >= 1 && ny <= N && corridor[nx][ny] != 'O') {
					if (corridor[nx][ny] == 'S')
						return false;
					nx += dx[i];
					ny += dy[i];
				}
			}
		}

		return true;
	}

}
