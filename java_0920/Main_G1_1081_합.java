package java_0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G1_1081_гу {

//	 6 : '0'*1*(0+...+9) + 1*(0+...+(6-1)) + 6*('0'+1)
//	 85 : '0'*10*(0+...+9) + 10*(0+...+(8-1)) + 8*('5'+1)
//			+ '8'*1*(0+...+9) + 1*(0+...+(5-1)) + 5*('0'+1)
//	 357 : '0'*100*(0+...+9) + 100*(0+...+(3-1)) + 3*('57'+1)
//			+ '3'*10*(0+...+9) + 10*(0+...+(5-1)) + 5*('7'+1)
//			+ '35'*1*(0+...+9) + 1*(0+...+(7-1)) + 7*('0'+1)
//	 9283 : '0'*1000*(0+...+9) + 1000*(0+...(9-1)) + 9*('283'+1)
//			+ '9'*100*(0+...+9) + 100*(0+...+(2-1)) + 2*('83'+1)
//			+ '92'*10*(0+...+9) + 10*(0+...+(8-1)) + 8*('3'+1)
//			+ '928'*1*(0+...+9) + 1*(0+...+(3-1)) + 3*('0'+1)

	public static String L, U;
	public static int[] sumTo = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		L = st.nextToken();
		U = st.nextToken();

		for (int i = 1; i < 10; i++)
			sumTo[i] = sumTo[i - 1] + i;

		long ans = getSum(U) - getSum(L);
		for (int i = 0; i < L.length(); i++)
			ans += L.charAt(i) - '0';

		System.out.println(ans);
	}

	public static long getSum(String num) {
		long sum = 0L;
		for (int i = 0; i < num.length(); i++) {
			String left = "0";
			if (i > 0)
				left += num.substring(0, i);
			int now = num.charAt(i) - '0';
			String right = "0";
			if (i < num.length() - 1)
				right += num.substring(i + 1);

			long decPlace = (long) Math.pow(10, right.length() - 1);
			sum += Long.parseLong(left) * decPlace * sumTo[9];
			if (now > 0)
				sum += decPlace * sumTo[now - 1];
			sum += now * (Long.parseLong(right) + 1);
		}

		return sum;
	}

}