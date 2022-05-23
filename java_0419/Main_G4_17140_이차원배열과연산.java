package java_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_17140_이차원배열과연산 {

	public static int[][] A = new int[101][101];
	public static int r, c, k, time = 0, rNum = 3, cNum = 3;

	public static class Num implements Comparable<Num> {
		int val, cnt;

		public Num(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Num o) {
			if (this.cnt != o.cnt)
				return Integer.compare(this.cnt, o.cnt);
			else
				return Integer.compare(this.val, o.val);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (time >= 100) {
				System.out.println(-1);
				return;
			}

			if (A[r][c] == k) {
				System.out.println(time);
				return;
			}

			if (rNum >= cNum)
				operateR();
			else
				operateC();

//			for (int i = 1; i <= 10; i++) {
//				for (int j = 1; j <= 10; j++) {
//					System.out.print(A[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("---------- R : " + rNum + ", C : " + cNum + "-------");
			time++;
		}
	}

	public static void operateR() {
		for (int i = 1; i <= rNum; i++) {
			int bs = 0;
			for (int j = 1; j <= 100; j++) {
				if (A[i][j] == 0)
					continue;
				bs++;
			}

			if (bs > 0) {
				int[] before = new int[bs];
				int idx = 0;
				for (int j = 1; j <= 100; j++) {
					if (A[i][j] != 0)
						before[idx++] = A[i][j];
				}

//			System.out.println("before: " + Arrays.toString(before));
				int[] sorted = sort(before);
				int len = sorted.length;
//			System.out.println(Arrays.toString(sorted));
				Arrays.fill(A[i], 0);
				for (int j = 1; j <= len; j++) {
					A[i][j] = sorted[j - 1];
				}

				cNum = Integer.max(cNum, len);
//			System.out.println(Arrays.toString(A[i]));
			}
		}
	}

	public static void operateC() {
		for (int i = 1; i <= cNum; i++) {
			int bs = 0;
			for (int j = 1; j <= 100; j++) {
				if (A[j][i] == 0)
					continue;
				bs++;
			}

			if (bs > 0) {
				int[] before = new int[bs];
				int idx = 0;
				for (int j = 1; j <= 100; j++) {
					if (A[j][i] != 0)
						before[idx++] = A[j][i];
				}

				int[] sorted = sort(before);
				int len = sorted.length;
				for (int j = 1; j <= 100; j++) {
					if (j <= len)
						A[j][i] = sorted[j - 1];
					else
						A[j][i] = 0;
				}

				rNum = Integer.max(rNum, len);
			}
		}
	}

	public static int[] sort(int[] arr) {
		ArrayList<Num> numList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int idx = containsValue(numList, arr[i]);
			if (idx == -1) {
				numList.add(new Num(arr[i], 1));
			} else {
				numList.get(idx).cnt++;
			}
		}

		Collections.sort(numList);

		int size = numList.size();
		int[] result = new int[2 * size];
		for (int i = 0; i < size; i++) {
			result[2 * i] = numList.get(i).val;
			result[2 * i + 1] = numList.get(i).cnt;
		}

		return result;
	}

	public static int containsValue(ArrayList<Num> list, int v) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).val == v) {
				return i;
			}
		}
		return -1;
	}

}
