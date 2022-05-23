package java_0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_2252_줄세우기 {

	public static int N, M, A, B;
	public static int[] indegree;
	public static ArrayList<Integer>[] shorterThan;

	public static void main(String[] args) throws IOException {
		// 1. 진입차수가 0인 정점을 큐에 삽입한다.
		// 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거한다.
		// 3. 간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입한다.
		// 4. 큐가 빌 때까지 2~3번 과정을 반복한다. 모든 원소를 방문하기 전에 큐가 빈다면
		// 사이클이 존재하는 것이고, 모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상 정렬의 결과이다.

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

		// 1. 진입차수가 0인 정점을 큐에 삽입한다.
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			// 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거한다.
			int curr = q.poll();
			System.out.print(curr + " ");

			// 3. 간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입한다.
			for (int i = 0; i < shorterThan[curr].size(); i++) {
				int next = shorterThan[curr].get(i);
				if (--indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}

}
