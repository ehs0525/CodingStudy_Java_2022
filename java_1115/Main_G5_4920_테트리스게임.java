package java_1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_4920_��Ʈ�������� {

	static int N;
	static int[][] tetris;

	static int[][] dx = { // dx[i][j] : i����� j��° ĭ�� dx��
			{ 0, 0, 0 }, { 1, 2, 3 }, // ���� 2����
			{ 0, 1, 1 }, { 1, 1, 2 }, // ���� 2����
			{ 0, 0, 1 }, { 1, 2, 2 }, { 0, 0, -1 }, { -1, -2, -2 }, // ���� 4����
			{ 0, 0, 1 }, { 1, 2, 1 }, { 0, 0, -1 }, { -1, -2, -1 }, // ���� 4����
			{ 0, 1, 1 } // ���� 1����
	};
	static int[][] dy = { // dy[i][j : i����� j��° ĭ�� dy��
			{ 1, 2, 3 }, { 0, 0, 0 }, // ���� 2����
			{ 1, 1, 2 }, { 0, -1, -1 }, // ���� 2����
			{ 1, 2, 2 }, { 0, 0, -1 }, { -1, -2, -2 }, { 0, 0, 1 }, // ���� 4����
			{ 1, 2, 1 }, { 0, 0, -1 }, { -1, -2, -1 }, { 0, 0, 1 }, // ���� 4����
			{ 1, 0, 1 } // ���� 1����
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1;; tc++) {
			if ((N = Integer.parseInt(in.readLine().trim())) == 0)
				break;

			int max = Integer.MIN_VALUE;
			tetris = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					tetris[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					outer: for (int k = 0; k < 13; k++) {
						int sum = tetris[i][j];
						for (int l = 0; l < 3; l++) {
							int nx = i + dx[k][l];
							int ny = j + dy[k][l];
							if (nx < 0 || nx >= N || ny < 0 || ny >= N)
								continue outer;

							sum += tetris[nx][ny];
						}

						max = Integer.max(max, sum);
					}
				}
			}

			sb.append(tc).append(". ").append(max).append("\n");
		}

		System.out.println(sb);
	}

}
