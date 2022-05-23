package java_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_13114_ListofUniqueNumbers {

	public static int N, count = 0;
	public static int[] seq;
	public static boolean[] appeared = new boolean[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		seq = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int s = 0, e = -1; s < N; s++) {
			while (e + 1 < N && !appeared[seq[e + 1]]) { // 중복되는 숫자가 나올 때까지 e를 오른쪽으로
				appeared[seq[e + 1]] = true;
				e++;
			}

			count += (e - s + 1);
			appeared[seq[s]] = false;
		}

		System.out.println(count);
	}

}
