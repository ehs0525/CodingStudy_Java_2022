package java_0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_22234_°¡Èñ¿ÍÀºÇà {

	public static int N, T, W, M;
	public static Queue<Customer> q = new LinkedList<>();
	public static PriorityQueue<Customer> temp = new PriorityQueue<>();

	public static class Customer implements Comparable<Customer> {
		int id, t, c;

		public Customer(int id, int t, int c) {
			this.id = id;
			this.t = t;
			this.c = c;
		}

		@Override
		public int compareTo(Customer o) {
			return Integer.compare(this.c, o.c);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int id = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			q.offer(new Customer(id, t, 0));
		}

		M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int id = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			temp.offer(new Customer(id, t, c));
		}

		process();
	}

	public static void process() {
		int time = 0;

		while (time < W) {
			Customer curr = q.poll();

			// 1
			if (curr.t > T) {
				for (int i = 0; i < T; i++) {
					if (time >= W)
						break;
					System.out.println(curr.id);
					time++;
					curr.t--;
				}
			} else {
				for (int i = 0; i < curr.t; i++) {
					if (time >= W)
						break;
					System.out.println(curr.id);
					time++;
				}
				curr.t = 0;
			}

			while (!temp.isEmpty() && temp.peek().c <= time) {
				q.offer(temp.poll());
			}

			// 2
			if (curr.t > 0) {
				temp.offer(new Customer(curr.id, curr.t, time));
			}
		}

	}

}
