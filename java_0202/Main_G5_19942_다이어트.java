package java_0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_19942_다이어트 {

	public static int N, mp, mf, ms, mv, min = Integer.MAX_VALUE;
	public static Ingredient[] ingredients;
	public static boolean[] isSelected;

	public static class Ingredient {
		int p, f, s, v, c;
		boolean selected;

		public Ingredient(int p, int f, int s, int v, int c) {
			super();
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.c = c;
			this.selected = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		ingredients = new Ingredient[N + 1];
		isSelected = new boolean[N + 1];

		st = new StringTokenizer(in.readLine(), " ");
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ingredients[i] = new Ingredient(p, f, s, v, c);
		}

		findMinSet(1, 0);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			sb.append(min).append("\n");
			for (int i = 1; i <= N; i++) {
				if (ingredients[i].selected) {
					sb.append(i).append(" ");
				}
			}
			System.out.println(sb);
		}
	}

	public static void findMinSet(int index, int cost) {
		if (cost > min)
			return;
		if (index == N + 1) {
			if (meetsMinNutrientCriteria()) {
				min = Integer.min(min, cost);
				for (int i = 1; i <= N; i++) {
					if (isSelected[i]) {
						ingredients[i].selected = true;
					} else {
						ingredients[i].selected = false;
					}
				}
				return;
			} else
				return;
		}

		isSelected[index] = false;
		findMinSet(index + 1, cost);
		isSelected[index] = true;
		findMinSet(index + 1, cost + ingredients[index].c);
	}

	public static boolean meetsMinNutrientCriteria() {
		int psum = 0, fsum = 0, ssum = 0, vsum = 0;
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				psum += ingredients[i].p;
				fsum += ingredients[i].f;
				ssum += ingredients[i].s;
				vsum += ingredients[i].v;
			}
		}

		if (psum < mp || fsum < mf || ssum < ms || vsum < mv)
			return false;
		return true;
	}

}
