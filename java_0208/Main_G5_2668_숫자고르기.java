package java_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_2668_숫자고르기 {

	public static int N;
	public static int[][] table;
	public static boolean[] visited;
	public static ArrayList<Integer> choosed = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		table = new int[2][N + 1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			table[0][i] = i;
			table[1][i] = Integer.parseInt(in.readLine());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			chooseNumbers(i,i);
			visited[i] = false;
		}

		Collections.sort(choosed);
		System.out.println(choosed.size());
		for (int c : choosed)
			System.out.println(c);
	}

	public static void chooseNumbers(int src, int num) {
		if (table[1][num] == src) {
			choosed.add(num);
			return;
		}
		
		if (!visited[table[1][num]]) {
			visited[table[1][num]] = true;
			chooseNumbers(src, table[1][num]);
			visited[table[1][num]] = false;
		}
	}

}
