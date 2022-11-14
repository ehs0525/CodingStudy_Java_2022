package java_1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_23295_스터디시간정하기1 {

	static int N, T, K, S, E;
	static int[] participate; // participate[i] : i~(i+1) 시간에 스터디가 가능한 참가자 수

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		participate = new int[100000];
		int first = 100000, last = 0;
		for (int i = 0; i < N; i++) {
			K = Integer.parseInt(in.readLine());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());

				for (int k = S; k < E; k++) {
					participate[k]++;
				}

				first = Integer.min(first, S);
				last = Integer.max(last, E);
			}
		}

		int prev = 0;
		for (int i = first; i < first + T; i++) {
			prev += participate[i];
		}
		int max = prev, maxS = first;
		for (int i = first + 1; i + T <= 100000 && i < last; i++) {
			int curr = prev - participate[i - 1] + participate[i + T - 1];
			if (curr > max) {
				max = curr;
				maxS = i;
			}

			prev = curr;
		}

		System.out.println(maxS + " " + (maxS + T));
	}

}
