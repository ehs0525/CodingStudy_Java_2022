package java_1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_1865_��Ȧ {

	static final int INF = (int) 1e9;

	static int TC, N, M, W, S, E, T;
	static ArrayList<Edge> edges;
	static long[] d;

	static class Edge {
		int s, e, t;

		public Edge(int s, int e, int t) {
			super();
			this.s = s;
			this.e = e;
			this.t = t;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(in.readLine());
		while (TC-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			edges = new ArrayList<>();
			d = new long[N + 1];

			// ���� �Է¹ޱ�(�����)
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());

				edges.add(new Edge(S, E, T));
				edges.add(new Edge(E, S, T));
			}

			// ��Ȧ �Է¹ޱ�(�ܹ���)
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());

				edges.add(new Edge(S, E, -T));
			}

			String ans = "NO";
			for (int i = 1; i <= N; i++) {
				Arrays.fill(d, INF);
				if (bf(i)) {
					ans = "YES";
					break;
				}
			}
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

	private static boolean bf(int start) {
		d[start] = 0;

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < edges.size(); j++) { // ��ü ������ �ϳ��� Ȯ��
//				int s = edges.get(j).s;
//				int e = edges.get(j).e;
//				int t = edges.get(j).t;
//
//				// �� ������ ���� �ٸ� ���� ���� ����� ����Ͽ� �ִ� �Ÿ� ���̺� ����
//				if (d[s] < INF && d[e] > d[s] + t) {
//					d[e] = d[s] + t;
//					if (i == N - 1) // ���������� ���ŵƴٴ� ���� ���� ����Ŭ�� �����Ѵٴ� ��
//						return true;
//				}
//			}
//		}
//
//		return false;

		for (int i = 0; i < N; i++) {
			boolean isUpdated = false;
			for (int j = 0; j < edges.size(); j++) { // ��ü ������ �ϳ��� Ȯ��
				int s = edges.get(j).s;
				int e = edges.get(j).e;
				int t = edges.get(j).t;

				// �� ������ ���� �ٸ� ���� ���� ����� ����Ͽ� �ִ� �Ÿ� ���̺� ����
				if (d[s] < INF && d[e] > d[s] + t) {
					d[e] = d[s] + t;
					isUpdated = true;
					if (i == N - 1)
						return true;
				}
			}

			if (!isUpdated)
				return false;
		}

		return false;
	}

}
