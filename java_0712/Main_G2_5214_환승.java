package java_0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G2_5214_È¯½Â {

	public static int N, K, M;
	public static ArrayList<Integer>[] hypertube;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		st=  new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		hypertube = new ArrayList[M];
		for(int i=0;i<M;i++) {
			hypertube[i] = new ArrayList<>();
		}
		visited = new boolean[M][K];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<K;j++) {
				hypertube[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		bfs(1);
	}

	private static void bfs(int i) {
		// TODO Auto-generated method stub
		
	}

}
