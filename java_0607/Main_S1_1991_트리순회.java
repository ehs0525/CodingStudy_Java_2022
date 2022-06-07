package java_0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1991_트리순회 {

	public static int N;
	public static Node[] nodes;

	public static class Node {
		char root, left, right;

		public Node(char root, char left, char right) {
			this.root = root;
			this.left = left;
			this.right = right;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		nodes = new Node[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			nodes[root - 'A'] = new Node(root, left, right);
		}

		preorder(nodes[0]);
		System.out.println();
		inorder(nodes[0]);
		System.out.println();
		postorder(nodes[0]);
	}

	public static void postorder(Node v) {
		if(v.left != '.')
			postorder(nodes[v.left - 'A']);
		if(v.right != '.')
			postorder(nodes[v.right - 'A']);
		System.out.print(v.root);
		
	}

	public static void inorder(Node v) {
		if(v.left != '.')
			inorder(nodes[v.left - 'A']);
		System.out.print(v.root);
		if(v.right != '.')
			inorder(nodes[v.right - 'A']);
		
	}

	public static void preorder(Node v) {
		System.out.print(v.root);
		if (v.left != '.')
			preorder(nodes[v.left - 'A']);
		if (v.right != '.')
			preorder(nodes[v.right - 'A']);
	}

}
