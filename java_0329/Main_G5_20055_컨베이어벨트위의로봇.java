package java_0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_20055_�����̾Ʈ���Ƿκ� {

	public static int N, K, zero, step = 1;
	public static Belt[] belts;

	public static class Belt {
		int A;
		boolean robot;

		public Belt(int A, boolean robot) {
			this.A = A;
			this.robot = robot;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belts = new Belt[2 * N + 1];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= 2 * N; i++) {
			belts[i] = new Belt(Integer.parseInt(st.nextToken()), false);
		}

		proceed();
		
		System.out.println(step);
	}

	public static void proceed() {
		while (true) {

			// 1. ��Ʈ�� �� ĭ ���� �ִ� �κ��� �Բ� �� ĭ ȸ���Ѵ�.
			rotateBeltsWithRobots();
			
			// �������� �κ��� ������ ��ġ�� �����ϸ� �� ��� ������.
			belts[N].robot = false;

			// 2. ���� ���� ��Ʈ�� �ö� �κ�����, ��Ʈ�� ȸ���ϴ� �������� �� ĭ �̵��� �� �ִٸ� �̵��Ѵ�.
			moveRobots();
			
			belts[N].robot = false;
			
			// 3. �ø��� ��ġ�� �ִ� ĭ�� �������� 0�� �ƴϸ� �ø��� ��ġ�� �κ��� �ø���.
			if(belts[1].A != 0) {
				belts[1].robot = true;
				belts[1].A--;
				
				if(belts[1].A ==0) {
					zero++;
				}
			}
			
			// 4. �������� 0�� ĭ�� ������ K�� �̻��̶�� ������ �����Ѵ�.
			if (zero >= K)
				break;
			
			step++;
		}
	}

	public static void moveRobots() {
		for (int i = N; i > 1; i--) {
			// �κ��� �̵��ϱ� ���ؼ��� �̵��Ϸ��� ĭ�� �κ��� ������, �� ĭ�� �������� 1 �̻� ���� �־�� �Ѵ�.
			if (!belts[i].robot && belts[i].A >= 1) {
				if (belts[i - 1].robot) {
					belts[i - 1].robot = false;

					belts[i].robot = true;
					belts[i].A--;

					if (belts[i].A == 0)
						zero++;
				}
			}
		}
	}

	public static void rotateBeltsWithRobots() {
		Belt temp = belts[2 * N];

		for (int i = 2 * N; i > 1; i--) {
			belts[i] = belts[i - 1];
		}

		belts[1] = temp;
	}

}
