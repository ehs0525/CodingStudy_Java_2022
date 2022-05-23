package java_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_21608_상어초등학교 {

	public static int N;
	public static int[][] seat;
	public static ArrayList<Integer>[] favorite;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		seat = new int[N + 1][N + 1];
		favorite = new ArrayList[N * N + 1];
		for (int i = 1; i <= N * N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			int student = Integer.parseInt(st.nextToken());
			favorite[student] = new ArrayList<>();
			for (int j = 0; j < 4; j++)
				favorite[student].add(Integer.parseInt(st.nextToken()));

			int maxFavor = -1, maxBlank = -1;
			int x = 0, y = 0;
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (seat[j][k] != 0)
						continue;
					int favor = 0, blank = 0;

					for (int l = 0; l < 4; l++) {
						int nx = j + dx[l];
						int ny = k + dy[l];

						if (nx < 1 || nx > N || ny < 1 || ny > N)
							continue;

						if (seat[nx][ny] == 0)
							blank++;
						else if (favorite[student].contains(seat[nx][ny]))
							favor++;

					}

//					if (favor > maxFavor) {
//						maxFavor = favor;
//						x = j;
//						y = k;
//					} else if (favor == maxFavor && blank > maxBlank) {
//						maxBlank = blank;
//						x = j;
//						y = k;
//					} else if(blank > maxBlank) {
//						maxBlank = blank;
//					}

					if (favor > maxFavor && blank > maxBlank) {
						maxFavor = favor;
						maxBlank = blank;
						x = j;
						y = k;
					} else if (favor > maxFavor && blank <= maxBlank) {
						maxFavor = favor;

						x = j;
						y = k;
					} else if (favor == maxFavor && blank > maxBlank) {
						maxBlank = blank;
						x = j;
						y = k;
					} else if (favor < maxFavor && blank > maxBlank) {
						maxBlank = blank;
					}
				}
			}

			seat[x][y] = student;
		}

		System.out.println(getSatisfaction());

	}

	public static int getSatisfaction() {
		int sum = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				int favor = 0;

				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 1 || nx > N || ny < 1 || ny > N)
						continue;

//					System.out.println(seat[i][j]);
					if (favorite[seat[i][j]].contains(seat[nx][ny]))
						favor++;
				}

				if (favor > 0)
					sum += (int) Math.pow(10, favor - 1);
			}
		}

		return sum;
	}

}
