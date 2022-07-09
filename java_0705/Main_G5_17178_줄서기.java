package java_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_17178_�ټ��� {

	public static int N;
	public static Queue<Ticket> line = new LinkedList<>();
	public static Stack<Ticket> waiting = new Stack<>();
	public static Stack<Ticket> entrance = new Stack<>();

	public static class Ticket implements Comparable<Ticket> {
		char abc;
		int num;

		public Ticket(char abc, int num) {
			this.abc = abc;
			this.num = num;
		}

		@Override
		public int compareTo(Ticket o) {
			if (this.abc > o.abc)
				return 1;
			else if (this.abc == o.abc)
				return Integer.compare(this.num, o.num);
			else
				return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				String ticket = st.nextToken();
				char abc = ticket.charAt(0);
				int num = Integer.parseInt(ticket.substring(2));

				line.offer(new Ticket(abc, num));
			}
		}

//		while(true) {
//			if(!entrance.isEmpty()) {
//				Ticket last = entrance.peek();
//				// �ٿ��� ����� �ִ� ���
//				if(!line.isEmpty() && waiting.isEmpty() ) {
//					if(line.peek().compareTo(last) > 0) {
//						entrance.push(line.poll());
//					} else {
//						System.out.println("BAD");
//						return;
//					}
//				}
//				// ��� �������� ����� �ִ� ���
//				else if(line.isEmpty() && !waiting.isEmpty()) {
//					if(waiting.peek().compareTo(last) > 0) {
//						entrance.push(waiting.pop());
//					}else {
//						System.out.println("BAD");
//						return;
//					}
//				}
//				// �� �� �ִ� ���
//				else if(!line.isEmpty() && !waiting.isEmpty()) {
//					if(line.peek().compareTo(last) <0 || waiting.peek().compareTo(last)<0) {
//						System.out.println("BAD");
//						return;
//					} else {
//						if()
//					}
//				}
//				// �� �� ���� ���
//				else if(line.isEmpty() && waiting.isEmpty()) {
//					System.out.println("GOOD");
//					return;
//				}
//			}
//		}
		
		while(true) {
			// �ٿ� ����� �ִ� ���
			if(!line.isEmpty()) {
				Ticket ticket = line.poll();
				if(ticket.compareTo(line.peek()) > 0) {
					waiting.push(ticket);
				} else {
					
				}
			}
			// ��� �������� ����� �ִ� ���
			
			// �� �� �ִ� ���
			
			// �� �� ���� ���
		}

	}

}
