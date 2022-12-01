package java_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_19598_최소회의실개수 {

	static int N;
	static Meeting[] meetings;
	static PriorityQueue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>() {
		@Override
		public int compare(Meeting o1, Meeting o2) {
			return Integer.compare(o1.end, o2.end);
		}
	});

	static class Meeting {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			meetings[i] = new Meeting(s, e);
		}

		Arrays.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});

		// 각 회의실을 마지막 회의를 저장할 것임
		pq.offer(meetings[0]);
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			while (!pq.isEmpty() && pq.peek().end <= meetings[i].start)
				pq.poll();
			pq.offer(meetings[i]);
			cnt = Integer.max(cnt, pq.size());
		}

		System.out.println(cnt);
	}
}
