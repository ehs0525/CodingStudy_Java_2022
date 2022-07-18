package java_0719;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G3_4577_¼ÒÄÚ¹Ý {

	public static int R, C;
	public static char[][] sokoban;
	public static Point character;
	public static ArrayList<Point> targets;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int game = 1;; game++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (R == 0 && C == 0)
				break;

			sokoban = new char[R][C];
			targets = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				sokoban[i] = in.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					if (sokoban[i][j] == '+' || sokoban[i][j] == 'B') {
						targets.add(new Point(i, j));
					} else if (sokoban[i][j] == 'w') {
						character = new Point(i, j);
						sokoban[i][j] = '.';
					} else if (sokoban[i][j] == 'W') {
						character = new Point(i, j);
						targets.add(new Point(i, j));
						sokoban[i][j] = '+';
					}
				}
			}
			String command = in.readLine();

			String result = play(command);
			sokoban[character.x][character.y] = sokoban[character.x][character.y] == '.' ? 'w' : 'W';

			sb.append("Game ").append(game).append(": ").append(result).append("\n");
			for (int i = 0; i < R; i++)
				sb.append(sokoban[i]).append("\n");
		}

		System.out.println(sb);
	}

	public static boolean isComplete() {
		for (Point target : targets) {
			if (sokoban[target.x][target.y] == '+')
				return false;
		}

		return true;
	}

	public static String play(String command) {
		for (int i = 0; i < command.length(); i++) {

			int dir = 0;
			switch (command.charAt(i)) {
			case 'U':
				dir = 0;
				break;
			case 'D':
				dir = 1;
				break;
			case 'L':
				dir = 2;
				break;
			case 'R':
				dir = 3;
				break;
			default:
				break;
			}

			int nx = character.x + dx[dir];
			int ny = character.y + dy[dir];

			if (nx <= 0 || nx >= R - 1 || ny <= 0 || ny >= C - 1)
				continue;

			if (sokoban[nx][ny] == '.' || sokoban[nx][ny] == '+') {
				character = new Point(nx, ny);
			} else if (sokoban[nx][ny] == 'b' || sokoban[nx][ny] == 'B') {
				int nnx = nx + dx[dir];
				int nny = ny + dy[dir];

				if (sokoban[nnx][nny] == '.' || sokoban[nnx][nny] == '+') {
					character = new Point(nx, ny);

					if (sokoban[nx][ny] == 'b') {
						if (sokoban[nnx][nny] == '.') {
							sokoban[nx][ny] = '.';
							sokoban[nnx][nny] = 'b';
						} else if (sokoban[nnx][nny] == '+') {
							sokoban[nx][ny] = '.';
							sokoban[nnx][nny] = 'B';
						}
					} else if (sokoban[nx][ny] == 'B') {
						if (sokoban[nnx][nny] == '.') {
							sokoban[nx][ny] = '+';
							sokoban[nnx][nny] = 'b';
						} else if (sokoban[nnx][nny] == '+') {
							sokoban[nx][ny] = '+';
							sokoban[nnx][nny] = 'B';
						}
					}
				}
			}

			if (isComplete())
				return "complete";
		}

		return "incomplete";
	}

}
