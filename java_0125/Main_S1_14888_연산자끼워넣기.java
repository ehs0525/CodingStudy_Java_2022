package java_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_14888_연산자끼워넣기 {

	public static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static int[] A, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		A = new int[N];
		count = new int[4];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		insertOperators(0, A[0]);
		System.out.println(max + "\n" + min);
	}

	public static void insertOperators(int index, int value) {
		if (index == N - 1) {
			max = Integer.max(max, value);
			min = Integer.min(min, value);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (count[i] > 0) {
				count[i]--;
				insertOperators(index + 1, operate(value, i, A[index + 1]));
				count[i]++;
			}
		}

	}

	public static int operate(int num1, int op, int num2) {
		switch (op) {
		case 0:
			return num1 + num2;
		case 1:
			return num1 - num2;
		case 2:
			return num1 * num2;
		case 3:
			return num1 / num2;
		default:
			return -1;
		}
	}

}