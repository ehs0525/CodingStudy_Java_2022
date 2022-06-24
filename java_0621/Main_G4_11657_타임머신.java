package java_0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_11657_타임머신 {

	public static final long INF = (long) 1e9;

	public static int N, M, A, B, C;
	public static Route[] routes;
	public static long[] d; // 최단 거리 테이블

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
		// 모든 노선 정보 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			// 도시 A에서 도시 B로 버스를 타고 이동하는데 걸리는 시간이 C
			routes[i] = new Route(A, B, C);
		}

		d = new long[N + 1];
		Arrays.fill(d, INF); // 최단 거리 테이블을 모두 무한으로 초기화

		// 벨만 포드 알고리즘
		boolean negative_cycle = bf(1);

		// 시간을 무한히 오래 전으로 되돌릴 수 있다면
		if (negative_cycle) {
			System.out.println(-1);
			return;
		}

		// 1번 도시를 제외한 다른 모든 도시로 가기 위한 최단 거리를 출력
		for (int i = 2; i <= N; i++) {
			// 해당 도시로 가는 경로가 없다면
			if (d[i] == INF) {
				System.out.println(-1);
			} else {
				System.out.println(d[i]);
			}
		}
	}

	public static boolean bf(int start) {
		// 시작도시에 대해서 초기화
		d[start] = 0L;

		// 전체 N - 1번의 라운드(round)를 반복
		for (int i = 0; i < N; i++) {
			// 매 반복마다 "모든 노선"을 확인하며
			for (int j = 0; j < M; j++) {
				int curr = routes[j].src;
				int next = routes[j].dest;
				int time = routes[j].time;

				// 현재 간선을 거쳐서 다른 도시로 이동하는 시간이 더 짧은 경우
				if (d[curr] != INF && d[next] > d[curr] + time) {
					d[next] = d[curr] + time;
					// 마지막 라운드에서도 값이 갱신된다면 음수 순환이 존재
					if (i == N - 1)
						return true;
				}
			}
		}
		return false;
	}

}
