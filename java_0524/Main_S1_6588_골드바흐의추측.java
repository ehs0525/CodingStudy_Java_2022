package java_0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S1_6588_∞ÒµÂπŸ»Â¿«√ﬂ√¯ {

	public static int n;
	public static boolean[] isPrime = new boolean[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		setIsPrime();

		while (true) {
			n = Integer.parseInt(in.readLine());

			if (n == 0)
				break;

			boolean flag = false;
			for (int a = 2; a <= n / 2; a++) {
				if (isPrime[a] && isPrime[n - a]) {
					sb.append(n).append(" = ").append(a).append(" + ").append(n - a).append("\n");
					flag = true;
					break;
				}
			}

			if (!flag)
				sb.append("Goldbach's conjecture is wrong.\n");
		}

		System.out.println(sb);

	}

	public static void setIsPrime() {
		Arrays.fill(isPrime, true);

		for (int i = 2; i <= (int) Math.sqrt(1000000); i++) {
			if (isPrime[i]) {
				int j = 2;
				while (i * j <= 1000000) {
					isPrime[i * j] = false;
					j++;
				}
			}
		}
	}

}
