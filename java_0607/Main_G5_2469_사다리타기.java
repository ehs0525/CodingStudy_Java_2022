package java_0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_2469_사다리타기 {

	public static int k, n, hidden;
	public static char[] starting, arrival, ans;
	public static char[][] ladder;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(in.readLine());
		n = Integer.parseInt(in.readLine());

		starting = new char[k];
		arrival = new char[k];
		ladder = new char[n][k - 1];
		ans = new char[k - 1];

		for (int i = 0; i < k; i++)
			starting[i] = (char) ('A' + i);
		arrival = in.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			ladder[i] = in.readLine().toCharArray();
			if (ladder[i][0] == '?')
				hidden = i;
		}

		for (int i = 0; i < hidden; i++)
			ride(starting, ladder[i]);
		for (int i = n - 1; i > hidden; i--)
			ride(arrival, ladder[i]);

		constructHiddenLine();
		System.out.println(ans);
	}

	public static void constructHiddenLine() {
		for (int i = 0; i < k - 1; i++) {
			if (starting[i] == arrival[i + 1] && starting[i + 1] == arrival[i])
				ans[i] = '-';
		}

		for (int i = 0; i < k - 1; i++) {
			if (ans[i] == '-')
				continue;
			if (starting[i] == arrival[i] || starting[i + 1] == arrival[i + 1]
					|| (i - 1 >= 0 && ans[i - 1] == '-' && ans[i + 1] == '-')) {
				ans[i] = '*';
			} else {
				for (int j = 0; j < k - 1; j++)
					ans[j] = 'x';
				break;
			}
		}
	}

	public static void ride(char[] str, char[] ladder) {
		// - 인 곳 swap
		for (int i = 0; i < k - 1; i++) {
			if (ladder[i] == '-') {
				char temp = str[i];
				str[i] = str[i + 1];
				str[i + 1] = temp;
			}
		}
	}

}
