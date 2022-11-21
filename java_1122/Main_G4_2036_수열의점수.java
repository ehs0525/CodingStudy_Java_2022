package java_1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main_G4_2036_수열의점수 {

	static ArrayList<Long> positive = new ArrayList<>();
	static ArrayList<Long> negative = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		boolean zeroExists = false;
		for (int i = 0; i < n; i++) {
			long num = Integer.parseInt(in.readLine());
			if (num > 0)
				positive.add(num);
			else if (num == 0)
				zeroExists = true;
			else
				negative.add(num);
		}

		Collections.sort(positive);
		Collections.sort(negative);

		BigInteger score = new BigInteger("0");

		int p = positive.size() - 1;
		while (p >= 0) {
			if (p - 1 >= 0) {
				long num1 = positive.get(p), num2 = positive.get(p - 1);
				if (num2 == 1) {
					score = score.add(BigInteger.valueOf(num1));
					p--;
				} else {
					score = score.add(BigInteger.valueOf(num1 * num2));
					p -= 2;
				}
			} else {
				score = score.add(BigInteger.valueOf(positive.get(p--)));
			}
		}

		p = 0;
		while (p < negative.size()) {
			if (p + 1 < negative.size()) {
				score = score.add(BigInteger.valueOf(negative.get(p) * negative.get(p + 1)));
				p += 2;
			} else {
				if (!zeroExists)
					score = score.add(BigInteger.valueOf(negative.get(p)));
				p++;
			}
		}

		System.out.println(score);
	}

}
