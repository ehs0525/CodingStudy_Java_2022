package java_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_13458_시험감독 {

	public static int N, B, C;
	public static int[] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());

		A = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(countProctors());
	}

	public static long countProctors() {
		long cnt = N;

		for (int i = 0; i < N; i++) {
//			while(A[i] - B > 0) {
//				A[i] -= C;
//				cnt++;
//			}

			if(A[i] <= B) continue;
			cnt += (A[i] - B + (C - 1)) / C;
		}
		
		return cnt;
	}

}
