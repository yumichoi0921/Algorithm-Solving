package Algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static Edge[] edgeList;
	
	static int[] parents; //부모 원소 관리 (트리 처럼 사용)
	
	private static void make() 	{
		parents = new int [V];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (a == parents[a]) return a;	// 자신이 대표자
		// 자신이 속한 집합의 대표자를 자신의 부모로 -> Path compression
		return parents[a] = find(parents[a]); 
		
	}
	
	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false; // 이미 같은 집합으로 합치지 않음
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 간선리스트 저장
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(in.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList);
		make(); // 모든 정점을 각각을 집합으로 만들고 출발
		
		// 간선 하나씩 시도하며 트리 만들어감
		int cnt = 0, result = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt == V-1) break; // 신장트리 완성
			}
		}
		
		System.out.println(result);
	}

}
