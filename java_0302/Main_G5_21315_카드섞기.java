package java_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_21315_카드섞기 {

	public static int N;
	public static int[] result;
	public static Deque<Integer> cards; // Deque 자료구조 : https://soft.plusblog.co.kr/24
	public static ArrayList<Integer> temp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		result = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 2; i < N; i *= 2) {
			for (int j = 2; j < N; j *= 2) {
				cards = new ArrayDeque<>();
				for (int k = 1; k <= N; k++) {
					cards.offerLast(k);
				}

				shuffleCards(i);
				shuffleCards(j);
				
				if (guessedRight()) {
					System.out.println(i / 2 + " " + j / 2);
					return;
				}
			}
		}
	}

	public static boolean guessedRight() {
		for (int i = 0; i < N; i++) {
			if (cards.pollFirst() != result[i]) {
				return false;
			}
		}

		return true;
	}

	public static void shuffleCards(int k) {
		Queue<Integer> temp = new LinkedList<Integer>();
	
		// Step 1 중 temp 처리
		for (int i = 0; i < k; i++) {
			temp.offer(cards.pollLast());
		}

		for (int i = k / 2; i >= 1; i /= 2) {
			for (int j = 0; j < i; j++) {
				temp.offer(temp.poll());
			}
			for (int j = 0; j < i; j++) {
				cards.offerFirst(temp.poll());
			}
		}
		cards.offerFirst(temp.poll());
	}
}