import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JUNGOL_1681 {
	static int N, min = Integer.MAX_VALUE;
	static int [][] adjMatrix;
	static boolean [] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
		}
		visited[0] = true;
		dfs(0, 0, 0);
		bw.write(""+min);
		br.close();
		bw.close();
	}
	
	private static void dfs(int vertex, int depth, int weight) {
		if(weight > min) return;
		if(depth == N-1) {
			if(adjMatrix[vertex][0]!=0)
				min = Math.min(min, weight + adjMatrix[vertex][0]);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i] && adjMatrix[vertex][i]!=0) {
				visited[vertex] = true;
				dfs(i, depth+1, weight + adjMatrix[vertex][i]);
				visited[vertex] = false;
			}
		}
	}
}
