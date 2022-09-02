package java_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main_G4_13701_중복제거 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		BitSet bs = new BitSet();

		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			if (!bs.get(a)) {
				bs.set(a);
				sb.append(a).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
