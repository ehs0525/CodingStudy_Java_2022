package java_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_DFS¿ÍBFS {

	public static int N, M, V;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		visited = new boolean[N + 1];

		while (M-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		for(int i=1;i<=N;i++)
			Collections.sort(graph[i]);

		dfs(V);
		System.out.println();
		bfs(V);
	}

	public static void bfs(int v) {
		visited = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			
			for(int i=0;i<graph[curr].size();i++) {
				int next = graph[curr].get(i);
				
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}

	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int i = 0; i < graph[v].size(); i++) {
			int next = graph[v].get(i);
			if (!visited[next])
				dfs(graph[v].get(i));
		}
	}

}
