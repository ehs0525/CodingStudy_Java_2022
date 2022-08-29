package java_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_15961_»∏¿¸√ π‰ {

	public static int N, d, k, c;
	public static int[] sushi, eaten;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N];
		eaten = new int[d + 1];
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(in.readLine());

		System.out.println(solve());
	}

	public static int solve() {
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (eaten[sushi[i]]++ == 0)
				cnt++;
		}
		if (eaten[c]++ == 0)
			cnt++;

		int slided = 1, max = cnt;
		while (slided < N) {
			if (--eaten[sushi[slided - 1]] == 0)
				cnt--;
			if (eaten[sushi[(slided + k - 1) % N]]++ == 0)
				cnt++;

			max = Integer.max(max, cnt);
			slided++;
		}

		return max;
	}

}
