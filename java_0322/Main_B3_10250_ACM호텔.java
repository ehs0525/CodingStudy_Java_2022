package java_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_10250_ACMÈ£ÅÚ {

	public static int T, H, W, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			if (N % H == 0) {
				sb.append(H);
				if (N / H < 10)
					sb.append(0);
				sb.append(N / H).append("\n");
			} else {
				sb.append(N % H);
				if (N / H + 1 < 10)
					sb.append("0");
				sb.append(N / H + 1).append("\n");
			}
		}

		System.out.println(sb);
	}

}
