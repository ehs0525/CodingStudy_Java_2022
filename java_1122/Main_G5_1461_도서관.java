package java_1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G5_1461_µµ¼­°ü {

	static int N, M;
	static ArrayList<Integer> positive = new ArrayList<>();
	static ArrayList<Integer> negative = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int loc = Integer.parseInt(st.nextToken());

			if (loc > 0) {
				positive.add(loc);
			} else if (loc < 0) {
				negative.add(loc);
			}
		}

		Collections.sort(positive);
		Collections.sort(negative);

		ArrayList<Integer> dist = new ArrayList<>();

		int p = positive.size() - 1;
		while (p >= 0) {
			dist.add(positive.get(p));

			int bookCnt = 1;
			while (p >= 0 && bookCnt <= M) {
				p--;
				bookCnt++;
			}
		}

		p = 0;
		while (p < negative.size()) {
			dist.add(-negative.get(p));

			int bookCnt = 1;
			while (p < negative.size() && bookCnt <= M) {
				p++;
				bookCnt++;
			}
		}

		int ans = 0;
		Collections.sort(dist);
		for (int i = 0; i < dist.size(); i++) {
			if (i < dist.size() - 1) {
				ans += dist.get(i) * 2;
			} else {
				ans += dist.get(i);
			}
		}

		System.out.println(ans);
	}

}
