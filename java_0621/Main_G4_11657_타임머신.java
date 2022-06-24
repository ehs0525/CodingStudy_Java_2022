package java_0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_11657_Ÿ�Ӹӽ� {

	public static final long INF = (long) 1e9;

	public static int N, M, A, B, C;
	public static Route[] routes;
	public static long[] d; // �ִ� �Ÿ� ���̺�

	public static class Route {
		int src, dest, time;

		public Route(int src, int dest, int time) {
			this.src = src;
			this.dest = dest;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		routes = new Route[M];
		// ��� �뼱 ���� �Է¹ޱ�
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			// ���� A���� ���� B�� ������ Ÿ�� �̵��ϴµ� �ɸ��� �ð��� C
			routes[i] = new Route(A, B, C);
		}

		d = new long[N + 1];
		Arrays.fill(d, INF); // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ

		// ���� ���� �˰���
		boolean negative_cycle = bf(1);

		// �ð��� ������ ���� ������ �ǵ��� �� �ִٸ�
		if (negative_cycle) {
			System.out.println(-1);
			return;
		}

		// 1�� ���ø� ������ �ٸ� ��� ���÷� ���� ���� �ִ� �Ÿ��� ���
		for (int i = 2; i <= N; i++) {
			// �ش� ���÷� ���� ��ΰ� ���ٸ�
			if (d[i] == INF) {
				System.out.println(-1);
			} else {
				System.out.println(d[i]);
			}
		}
	}

	public static boolean bf(int start) {
		// ���۵��ÿ� ���ؼ� �ʱ�ȭ
		d[start] = 0L;

		// ��ü N - 1���� ����(round)�� �ݺ�
		for (int i = 0; i < N; i++) {
			// �� �ݺ����� "��� �뼱"�� Ȯ���ϸ�
			for (int j = 0; j < M; j++) {
				int curr = routes[j].src;
				int next = routes[j].dest;
				int time = routes[j].time;

				// ���� ������ ���ļ� �ٸ� ���÷� �̵��ϴ� �ð��� �� ª�� ���
				if (d[curr] != INF && d[next] > d[curr] + time) {
					d[next] = d[curr] + time;
					// ������ ���忡���� ���� ���ŵȴٸ� ���� ��ȯ�� ����
					if (i == N - 1)
						return true;
				}
			}
		}
		return false;
	}

}
