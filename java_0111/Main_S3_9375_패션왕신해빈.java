package java_0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S3_9375_ÆÐ¼Ç¿Õ½ÅÇØºó {

	public static int tc, n;
//	public static ArrayList<Costume> costumes = new ArrayList<>();
//	
//	public static class Costume {
//		String type;
//		int num;
//		
//		public Costume(String type) {
//			this.type = type;
//			this.num = 1;
//		}
//	}
	public static ArrayList<String> types;
	public static ArrayList<Integer> counts;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(in.readLine());
		for (int i = 0; i < tc; i++) {
			types = new ArrayList<>();
			counts = new ArrayList<>();
			n = Integer.parseInt(in.readLine());
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				String name = st.nextToken();
				String type = st.nextToken();

				int index = types.indexOf(type);
				if (index > -1) {
					counts.set(index, counts.get(index) + 1);
				} else {
					types.add(type);
					counts.add(1);
				}
			}
			sb.append(wearNotNaked()).append("\n");
		}

		System.out.println(sb);
	}

	public static int wearNotNaked() {
		int result = 1;
		for (int count : counts) {
			result *= (count + 1);
		}
		return result - 1;
	}

}
