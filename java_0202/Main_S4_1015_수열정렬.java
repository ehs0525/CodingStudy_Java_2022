package java_0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S4_1015_수열정렬 {

	public static int N;
	public static Number[] A, P;

	public static class Number {
		public int before, num, after;

		public Number(int before, int num) {
			this.before = before;
			this.num = num;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		A = new Number[N];
		P = new Number[N];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int element = Integer.parseInt(st.nextToken());
			A[i] = new Number(i, element);
		}

		// 숫자에 따라 비내림차순 정렬하고
		Arrays.sort(A, new Comparator<Number>() {

			@Override
			public int compare(Number o1, Number o2) {
				return Integer.compare(o1.num, o2.num);
			}
		});

		// 각 Number의 after에 정렬 후 인덱스를 저장
		for (int i = 0; i < N; i++) {
			A[i].after = i;
		}

		// 원상태의 A로 돌아가기 위해 before로 비내림차순 정렬
		Arrays.sort(A, new Comparator<Number>() {

			@Override
			public int compare(Number o1, Number o2) {
				return Integer.compare(o1.before, o2.before);
			}
		});

		// 순서대로 각 Number의 after는 수열 P이다.
		for (int i = 0; i < N; i++) {
			sb.append(A[i].after).append(" ");
		}

		System.out.println(sb);
	}

}
