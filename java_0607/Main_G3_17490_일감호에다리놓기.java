package java_0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_17490_일감호에다리놓기 {

	public static int N, M;
	public static long K;
	public static int[] S, parent;
	public static boolean[] underConstruction;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		S = new int[N + 1];
		for (int i = 1; i <= N; i++)
			S[i] = Integer.parseInt(st.nextToken());

		underConstruction = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int building1 = Integer.parseInt(st.nextToken());
			int building2 = Integer.parseInt(st.nextToken());

			if ((building1 == N && building2 == 1) || (building1 == 1 && building2 == N))
				underConstruction[Integer.max(building1, building2)] = true;
			else
				underConstruction[Integer.min(building1, building2)] = true;
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
		for (int i = 1; i <= N; i++) {
			if (!underConstruction[i])
				union(i, i % N + 1);
		}

		int parentCnt = 0;
		long stoneCnt = 0;
		for (int i = 1; i <= N; i++) {
			if (find(i) == i) {
				parentCnt++;
				stoneCnt += S[i];
			}
		}

		if (parentCnt == 1 || stoneCnt <= K)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		// 와우도까지 놓아야하는 돌의 개수가 적은 강의동을 부모로
		if (S[a] < S[b])
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

}
