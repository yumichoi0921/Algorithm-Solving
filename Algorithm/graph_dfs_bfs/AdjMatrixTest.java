package Algorithm.graph_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	
	static int N;	// 정점 개수
	static boolean[][] adjMatrix;	// 인접 행렬(가중치 없음)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(in.readLine());	// 간선 개수
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[from][to] = true;
		}
		System.out.println("============bfs==============");
		bfs();
		System.out.println("============dfs==============");
		dfs(0, new boolean[N]);
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char)(current+65));	// 현재 정점
//		방문하지 않았고 && 현재 정점에서 그 정점으로 갈 수 있다면(인접정점)
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMatrix[current][i]) {
				dfs(i, visited);
				
			}
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		queue.offer(0);
		visited[0] = true;
		while(!queue.isEmpty()) {	
			int current = queue.poll();	// 현재 정점
			System.out.println((char)(current+65));
			
			for (int i = 0; i < N; i++) {
				//	방문하지 않았고 && 현재 정점에서 그 정점으로 갈 수 있다면(인접정점)
				if (!visited[i] && adjMatrix[current][i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

}
