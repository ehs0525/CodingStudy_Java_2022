package java_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_11403_���ã�� {

	public static int INF = (int) 1e9;
	public static int N;
	public static int[][] G;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		G = new int[N][N];

		
		// ������ �ʱ�ȭ => �ڱ��ڽ����� ���°� 0(������� ����!!) => ������ �Է¹���
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(G[i], INF);// ������
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {

				int exists = Integer.parseInt(st.nextToken());
				if (exists == 0)
					continue;
				G[i][j] = exists;
			}
		}

		// �÷��̵� �ͼ�
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					G[i][j] = Math.min(G[i][j], G[i][k] + G[k][j]);
				}
			}
		}
//		System.out.println(Arrays.deepToString(G));
		// ������ �°� ���
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(G[i][j] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(1 + " ");
				}
			}
			System.out.println();
		}
	}

}
