package java_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_2141_¿ìÃ¼±¹ {

	static int N;
	static Village[] villages;

	static class Village implements Comparable<Village> {
		int location, population;

		public Village(int location, int population) {
			super();
			this.location = location;
			this.population = population;
		}

		@Override
		public int compareTo(Village o) {
//			if (o.population == this.population)
//				return Integer.compare(this.location, o.location);
//			return o.population - this.population;
			return Integer.compare(this.location, o.location);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		long totalPop = 0;

		N = Integer.parseInt(in.readLine());
		villages = new Village[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			villages[i] = new Village(x, a);
			totalPop += a;
		}
		Arrays.sort(villages);

		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += villages[i].population;
			if (sum >= (totalPop + 1) / 2) {
				System.out.println(villages[i].location);
				break;
			}
		}
	}

}
