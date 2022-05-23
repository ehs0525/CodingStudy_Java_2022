package java_0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S4_1015_�������� {

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

		// ���ڿ� ���� �񳻸����� �����ϰ�
		Arrays.sort(A, new Comparator<Number>() {

			@Override
			public int compare(Number o1, Number o2) {
				return Integer.compare(o1.num, o2.num);
			}
		});

		// �� Number�� after�� ���� �� �ε����� ����
		for (int i = 0; i < N; i++) {
			A[i].after = i;
		}

		// �������� A�� ���ư��� ���� before�� �񳻸����� ����
		Arrays.sort(A, new Comparator<Number>() {

			@Override
			public int compare(Number o1, Number o2) {
				return Integer.compare(o1.before, o2.before);
			}
		});

		// ������� �� Number�� after�� ���� P�̴�.
		for (int i = 0; i < N; i++) {
			sb.append(A[i].after).append(" ");
		}

		System.out.println(sb);
	}

}
