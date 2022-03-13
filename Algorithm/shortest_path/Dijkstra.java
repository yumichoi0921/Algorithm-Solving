package Algorithm.shortest_path;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
	static int V;
	static int E;
	static int [][] adj;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("mst.txt"));
		Scanner sc= new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			adj[from][to] = weight;
			adj[to][from] = weight;
		}
//		print(adj);
		// Dijkstra
		boolean[] visited = new boolean[V];	// 방문배열
		int[] minDist = new int[V];	// 정점까지 오는 최소비용배열
		Arrays.fill(minDist, Integer.MAX_VALUE);
		
		// 시작정점 -> 0 
		minDist[0] = 0;
		
		// 정점을 선택하는 반복 -> V 또는 V-1만큼 반복
		for (int cnt = 0; cnt < V-1; cnt++) {
			// step1: 방문하지 않은 정점중에서 출발지에서 자신으로의 비용이 최적인 정점 선택
			//	-> 경유지로 고려할 정점 선택
			int minD = Integer.MAX_VALUE;
			int minV = -1;
			for (int i = 0; i < minDist.length; i++) {
				if (!visited[i] && minDist[i]<minD) {
					minD = minDist[i];
					minV = i;
				}
			}

			// step2: 선택한 정점을 경유지로 하여 아직 방문하지 않은 다른 정점과의 비용을 계산하여 최적 갱신
			// minV에 연결되어있는 정점중에 minV를 경유하여 i까지 가는 비용의 합 dist[minIdx]+adj[minIdx][i]과
			// 이제까지 계산한 i까지 가는 비용 dist[i]을 비교하여 dist 배열을 업데이트
			visited[minV] = true;
			for (int i = 0; i < adj[minV].length; i++) {
				if(adj[minV][i] != 0 && !visited[i] && minDist[minV]+adj[minV][i] < minDist[i]) {
					minDist[i] = minDist[minV]+adj[minV][i];
				}
			}
		}
		System.out.println(Arrays.toString(minDist));
		int ans = 0;
		for (int i = 0; i < minDist.length; i++) {
			ans += minDist[i];
		}
		System.out.println(ans);
		
	}
	private static void print(int[][] adj) {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].length; j++) {
				System.out.print(adj[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
