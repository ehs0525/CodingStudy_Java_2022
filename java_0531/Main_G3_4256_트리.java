package java_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_4256_Æ®¸® {

	public static int T, n, idx;
	public static int[] preorder, inorder, postorder;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(in.readLine());

			preorder = new int[n + 1];
			inorder = new int[n + 1];
			postorder = new int[n + 1];
			idx = 0;

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}

			toPostorder(0, 0, n);

			for (int i = 0; i < n; i++) {
				System.out.print(postorder[i] + " ");
			}
			System.out.println();
		}

	}

	public static void toPostorder(int v, int left, int right) {
		int root = preorder[v];

		for (int i = left; i < right; i++) {
			if (inorder[i] == root) {
				toPostorder(v + 1, left, i);
				toPostorder(v + i - left + 1, i + 1, right);
				postorder[idx++] = root;
			}
		}

	}

}
