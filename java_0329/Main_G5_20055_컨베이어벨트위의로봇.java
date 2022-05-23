package java_0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_20055_컨베이어벨트위의로봇 {

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

			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			rotateBeltsWithRobots();
			
			// 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다.
			belts[N].robot = false;

			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
			moveRobots();
			
			belts[N].robot = false;
			
			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(belts[1].A != 0) {
				belts[1].robot = true;
				belts[1].A--;
				
				if(belts[1].A ==0) {
					zero++;
				}
			}
			
			// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
			if (zero >= K)
				break;
			
			step++;
		}
	}

	public static void moveRobots() {
		for (int i = N; i > 1; i--) {
			// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
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
