package java_0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_G4_1339_단어수학 {

	public static int N, sum = 0;
	public static int[] coeff = new int[26];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String word = in.readLine();

			for (int j = 0; j < word.length(); j++) {
				coeff[word.charAt(j) - 'A'] += (int) Math.pow(10, word.length() - 1 - j);
			}
		}

		// primitive Type을 Wrapper클래스로 박싱해주어야 reverseOrder 사용가능.
		Integer[] temp = Arrays.stream(coeff).boxed().toArray(Integer[]::new);
		Arrays.sort(temp, Collections.reverseOrder());
		for (int i = 0; i < 10; i++) {
			if (temp[i] == 0)
				break;
			sum += temp[i] * (9 - i);
		}

		System.out.println(sum);
	}

}
