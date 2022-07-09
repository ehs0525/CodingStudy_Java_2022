package java_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_16916_부분문자열 {

	public static char[] S, P;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		S = in.readLine().toCharArray();
		P = in.readLine().toCharArray();

		int sLen = S.length, pLen = P.length;

		// 부분 일치 테이블(패턴 포인터를 어디로 옮겨야 하는지 인덱스 저장)
		int[] pi = new int[pLen];
		// i : 접미사 포인터(i=1부터 시작), j : 접두사 포인터
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

		// i : S 포인터, j : P 포인터
		for (int i = 0, j = 0; i < sLen; i++) {
			while (j > 0 && S[i] != P[j]) {
				j = pi[j - 1];
			}
			
			if(S[i] == P[j]) { // 두 글자가 일치
				if(j == pLen - 1) { // 패턴 글자 모두 일치
					System.out.println(1);
					return;
				} else { // 패턴 일치 중간 과정(패턴 앞쪽 일치하며 진행중인 상황)
					++j;
				}
			}
		}
		
		System.out.println(0);
	}

}
