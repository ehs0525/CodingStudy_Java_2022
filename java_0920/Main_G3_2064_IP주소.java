package java_0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_2064_IP주소 {

	public static int n;
	public static int[] addresses;

	// 네트워크 마스크 & IP 주소 = 네트워크 주소
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		addresses = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), ".");
			for (int j = 0; j < 4; j++) {
				int b = Integer.parseInt(st.nextToken());
				addresses[i] = (addresses[i] << 8) | b;
			}
		}

		// 앞에서부터 다른 비트 찾기
		int netMask = 0;
		outer: for (int i = 31; i >= 0; i--) {
			int bit = 1 << i;

			for (int j = 1; j < n; j++) {
				if ((addresses[0] & bit) != (addresses[j] & bit))
					break outer;
			}

			netMask |= bit;
		}

		System.out.println(convert(netMask & addresses[0]));
		System.out.println(convert(netMask));
	}

	public static String convert(int network) {
		String ret = "";

		int bit = 255;
		for (int i = 24; i >= 0; i -= 8) {
			ret += String.valueOf((network >> i) & bit);
			if (i > 0)
				ret += ".";
		}

		return ret;
	}

}
