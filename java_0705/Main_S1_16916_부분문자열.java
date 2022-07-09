package java_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_16916_�κй��ڿ� {

	public static char[] S, P;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		S = in.readLine().toCharArray();
		P = in.readLine().toCharArray();

		int sLen = S.length, pLen = P.length;

		// �κ� ��ġ ���̺�(���� �����͸� ���� �Űܾ� �ϴ��� �ε��� ����)
		int[] pi = new int[pLen];
		// i : ���̻� ������(i=1���� ����), j : ���λ� ������
		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}

			// P[i] == P[j]
			if (P[i] == P[j])
				pi[i] = ++j;
			// j == 0
			else
				pi[i] = 0;
		}

		// i : S ������, j : P ������
		for (int i = 0, j = 0; i < sLen; i++) {
			while (j > 0 && S[i] != P[j]) {
				j = pi[j - 1];
			}
			
			if(S[i] == P[j]) { // �� ���ڰ� ��ġ
				if(j == pLen - 1) { // ���� ���� ��� ��ġ
					System.out.println(1);
					return;
				} else { // ���� ��ġ �߰� ����(���� ���� ��ġ�ϸ� �������� ��Ȳ)
					++j;
				}
			}
		}
		
		System.out.println(0);
	}

}
