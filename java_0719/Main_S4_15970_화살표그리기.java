package java_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S4_15970_화살표그리기 {

	public static final int INF = (int) 1e5;

	public static int N, x, y, sum = 0;
	public static ArrayList<Integer>[] position;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		position = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			position[i] = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			position[y].add(x);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(position[i]);

			int size = position[i].size();
			for (int j = 0; j < size; j++) {
				int left = j == 0 ? INF : position[i].get(j) - position[i].get(j - 1);
				int right = j == size - 1 ? INF : position[i].get(j + 1) - position[i].get(j);

				sum += Integer.min(left, right);
			}
		}

		System.out.println(sum);
	}

}
