package java_1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_20364_ºÎµ¿»ê´ÙÅù {

	static int N, Q;
	static boolean[] occupied;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		occupied = new boolean[N + 1];
		for (int i = 0; i < Q; i++) {
			int x = Integer.parseInt(in.readLine());
			int temp = x, land = 0;

			while (temp >= 1) {
				if (occupied[temp]) {
					land = temp;
				}

				temp /= 2;
			}

			if(land == 0)
				occupied[x] = true;
			
			System.out.println(land);
		}
	}

}
