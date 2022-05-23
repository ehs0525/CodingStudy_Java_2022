package java_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_1756_ÇÇÀÚ±Á±â {

	public static int D, N, min = Integer.MAX_VALUE, deepest;
	public static int[] oven, pizza;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		oven = new int[D + 1];
		pizza = new int[N];
		deepest = D + 1;

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= D; i++) {
			min = Integer.min(min, Integer.parseInt(st.nextToken()));
			oven[i] = min;
		}

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			bake(1, deepest - 1, pizza[i]);
		}
		
		System.out.println(deepest);
	}

	public static void bake(int top, int bottom, int pizza) {
		int result  =0;
		while(top <= bottom) {
			int mid = (top+bottom)	/2;
			if(pizza > oven[mid]) {
				bottom = mid -1 ;
			} else {
				top= mid + 1;
				result = mid;
			}
		}
		
		deepest = result;
	}

}
