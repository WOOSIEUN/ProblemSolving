import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class BOJ_2075 {	
	static class Node{
		int vertex, weight;
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}		
	}
	static ArrayList<Node>[] adjList;
	static boolean [] isVisited;
	static int index, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		for (int i = 0; i <= N; i++)
			adjList[i] = new ArrayList<Node>();
		int parent, child, weight;
		for (int i = 0; i < N-1; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	parent = Integer.parseInt(st.nextToken());
	    	child = Integer.parseInt(st.nextToken());
	    	weight = Integer.parseInt(st.nextToken());
	    	adjList[parent].add(new Node(child, weight));
	    	adjList[child].add(new Node(parent, weight));
		}
		
		dfs(1,0);
		isVisited = new boolean[N+1];
		dfs(index,0);
		System.out.println(max);
		br.close();
	}

	private static void dfs(int vertex, int weight) {
		isVisited[vertex] = true;	
		if(max < weight) {
			index = vertex;
			max = weight;
		}
		for (Node cur : adjList[vertex])
			if(!isVisited[cur.vertex])
				dfs(cur.vertex, weight + cur.weight);
	}

}
