package Algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;	// 최소 신장트리 비용
		minEdge[0] = 0;	// 임의의 시작점 0의 간선비용을 0으로 세팅
		
		for (int i = 0; i < N; i++) {
			// 1. 신장트리에 포함되지 않은 정점 중 최소 간선 비용의 정점 찾기
			int minD = Integer.MAX_VALUE;
			int minV = -1;	// 최소간선비용의 정점번호
		
			for (int j = 0; j < N; j++) {
				if(!visited[j] && minD > minEdge[j]) {
					minD = minEdge[j];
					minV = j;
				}
			}
			
			visited[minV] = true; // 신장트리에 포함시킴
			result += minD; // 간선비용 누적
			
			//	2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
			
			for (int j = 0; j < N; j++) {
				// 아직 신장트리에 포함되지 않았고, 인접한 정점이며, 간선 비용이 저장된 최소 비용보다 작을 때
				if (!visited[j] && adjMatrix[minV][j] != 0 && minEdge[j] > adjMatrix[minV][j]) {
					minEdge[j] = adjMatrix[minV][j];	// 최소 간선 비용 업데이트
				}
			}
		}
		System.out.println(result);
	}

}
