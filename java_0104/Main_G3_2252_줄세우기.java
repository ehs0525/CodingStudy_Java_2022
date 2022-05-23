package java_0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_2252_�ټ���� {

	public static int N, M, A, B;
	public static int[] indegree;
	public static ArrayList<Integer>[] shorterThan;

	public static void main(String[] args) throws IOException {
		// 1. ���������� 0�� ������ ť�� �����Ѵ�.
		// 2. ť���� ���Ҹ� ���� ����� ��� ������ �����Ѵ�.
		// 3. ���� ���� ���Ŀ� ���������� 0�� �� ������ ť�� �����Ѵ�.
		// 4. ť�� �� ������ 2~3�� ������ �ݺ��Ѵ�. ��� ���Ҹ� �湮�ϱ� ���� ť�� ��ٸ�
		// ����Ŭ�� �����ϴ� ���̰�, ��� ���Ҹ� �湮�ߴٸ� ť���� ���� ������ ���� ������ ����̴�.

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N + 1];
		shorterThan = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			shorterThan[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			shorterThan[A].add(B);
			indegree[B]++;
		}

		lineUp();
	}

	public static void lineUp() { // topology sort
		Queue<Integer> q = new LinkedList<Integer>();

		// 1. ���������� 0�� ������ ť�� �����Ѵ�.
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			// 2. ť���� ���Ҹ� ���� ����� ��� ������ �����Ѵ�.
			int curr = q.poll();
			System.out.print(curr + " ");

			// 3. ���� ���� ���Ŀ� ���������� 0�� �� ������ ť�� �����Ѵ�.
			for (int i = 0; i < shorterThan[curr].size(); i++) {
				int next = shorterThan[curr].get(i);
				if (--indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}

}
